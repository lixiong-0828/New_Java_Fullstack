package com.lixiong.utils;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;
import jakarta.annotation.Resource;
import jakarta.websocket.server.PathParam;
import jdk.dynalink.beans.StaticClass;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.PropertySources;
import org.springframework.data.repository.query.Param;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PathVariable;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.Base64;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.security.Key;

@Slf4j
@Component
public class GetJwtUtil {

    @Value("${jwt.securityKey}")
    private String securityKey ;

    private static String encode64 = "";


    /**
     * 令牌生成
     */
    private  String generateJwt(Map<String,Object> claims) {

        encode64 = Base64.getEncoder().encodeToString(securityKey.getBytes(StandardCharsets.UTF_8));
        byte[] keyBytes = Base64.getDecoder().decode(encode64);
        Key key = Keys.hmacShaKeyFor(keyBytes);

        String jwt = Jwts.builder()
                //.signWith(SignatureAlgorithm.HS256, "5p2O6ZuE")  //【"5p2O6ZuE"】：base64 加密/解密 时的密码
                .signWith(key, SignatureAlgorithm.HS256)
                .setExpiration(new Date(System.currentTimeMillis() + 1000*60*10*12))  //10分钟期限的令牌
                .addClaims(claims)
                .setSubject(claims.get("email").toString())
                .setIssuedAt(new Date(System.currentTimeMillis()))
                .compact();

        //System.out.println(jwt);
        log.info("=========Generated JWT : {}=============" ,jwt);
        return jwt;
    }

    public  String getJwt(Map<String,Object> claims){

        String jwt = generateJwt(claims);
        return jwt;

    }

    /**
     * 解析令牌
     * 令牌解析出错，2种情况：
     * 1，令牌被串改
     * 2，令牌的失效：有效期已过
     * @throws IOException
     */
    public  Claims paarseJwt(String jwt) throws IOException {

        encode64 = Base64.getEncoder().encodeToString(securityKey.getBytes(StandardCharsets.UTF_8));
        byte[] keyBytes = Base64.getDecoder().decode(encode64);
        Key key = Keys.hmacShaKeyFor(keyBytes);

        Claims claims = Jwts.parser()
                .setSigningKey(key)    //这个必须跟，加密时的密钥一致！！
                .parseClaimsJws(jwt) //是【parseClaimsJws】，不是【parseClaimsJwt】
                .getBody();

        //System.out.println(claims);
        return claims;
    }

    // isExpired?
    private boolean isTokenExpired(String jwt) {
        encode64 = Base64.getEncoder().encodeToString(securityKey.getBytes(StandardCharsets.UTF_8));
        byte[] keyBytes = Base64.getDecoder().decode(encode64);
        Key key = Keys.hmacShaKeyFor(keyBytes);

        return Jwts.parser()
                .setSigningKey(key)    //这个必须跟，加密时的密钥一致！！
                .parseClaimsJws(jwt) //是【parseClaimsJws】，不是【parseClaimsJwt】
                .getBody()
                .getExpiration().before(new Date()); // isExpired?
    }

    public boolean verifyJwt(String jwt , UserDetails userDetails) throws IOException {

        String email = paarseJwt(jwt).get("email").toString() ;

        return email.equals(userDetails.getUsername()) && !isTokenExpired(jwt);

    }
}
