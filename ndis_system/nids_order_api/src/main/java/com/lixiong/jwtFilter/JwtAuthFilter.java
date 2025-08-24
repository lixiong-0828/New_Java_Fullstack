package com.lixiong.jwtFilter;

import com.lixiong.utils.GetJwtUtil;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.core.annotation.Order;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

@Slf4j
@Component
public class JwtAuthFilter extends OncePerRequestFilter {

    private GetJwtUtil getJwtUtil;
    private ApplicationContext applicationContext;

    // 定义不需要Token验证的路径
    private static final List<String> EXCLUDE_URLS = Arrays.asList(
            "/api/login",
            "/api/register"
    );

    @Autowired
    public JwtAuthFilter(GetJwtUtil getJwtUtil, ApplicationContext applicationContext) {
        this.getJwtUtil = getJwtUtil;
        this.applicationContext = applicationContext;

    }

    public JwtAuthFilter() {}

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {

        String requestPath = request.getRequestURI();

        // 检查当前请求是否在排除列表中
        if (EXCLUDE_URLS.stream().anyMatch(requestPath::equals)) {
            filterChain.doFilter(request, response);
            return;
        }

        String authHeader = request.getHeader("Authorization");
        if (authHeader == null && !authHeader.startsWith("Bearer ")) {
            filterChain.doFilter(request, response);
        }
        String token = authHeader.substring(7);
        String email = getJwtUtil.paarseJwt(token).get("email").toString();

        if(email != null && SecurityContextHolder.getContext().getAuthentication() == null) {
            UserDetails userDetails = applicationContext.getBean(CustomUserDetailService.class).loadUserByUsername(email);

            if(getJwtUtil.verifyJwt(token, userDetails)) {
                UsernamePasswordAuthenticationToken authToken = new UsernamePasswordAuthenticationToken(userDetails,null, userDetails.getAuthorities());
                authToken.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
                SecurityContextHolder.getContext().setAuthentication(authToken);
            }
        }

        log.info("============ token parse success!!!! ");
        filterChain.doFilter(request, response);


    }
}
