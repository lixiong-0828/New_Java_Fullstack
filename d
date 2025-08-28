[1mdiff --git a/ndis_system/.idea/vcs.xml b/ndis_system/.idea/vcs.xml[m
[1mindex 6c0b863..d843f34 100644[m
[1m--- a/ndis_system/.idea/vcs.xml[m
[1m+++ b/ndis_system/.idea/vcs.xml[m
[36m@@ -1,6 +1,4 @@[m
 <?xml version="1.0" encoding="UTF-8"?>[m
 <project version="4">[m
[31m-  <component name="VcsDirectoryMappings">[m
[31m-    <mapping directory="$PROJECT_DIR$/.." vcs="Git" />[m
[31m-  </component>[m
[32m+[m[32m  <component name="VcsDirectoryMappings" defaultProject="true" />[m
 </project>[m
\ No newline at end of file[m
[1mdiff --git a/ndis_system/nids_order_api/src/main/java/com/lixiong/controller/LoginController.java b/ndis_system/nids_order_api/src/main/java/com/lixiong/controller/LoginController.java[m
[1mindex 691b345..d3a49ba 100644[m
[1m--- a/ndis_system/nids_order_api/src/main/java/com/lixiong/controller/LoginController.java[m
[1m+++ b/ndis_system/nids_order_api/src/main/java/com/lixiong/controller/LoginController.java[m
[36m@@ -2,11 +2,14 @@[m [mpackage com.lixiong.controller;[m
 [m
 import com.lixiong.pojo.LoginRespons;[m
 import com.lixiong.pojo.Result;[m
[32m+[m[32mimport com.lixiong.pojo.User;[m
 import com.lixiong.pojo.dto.RegisterDataDto;[m
 import com.lixiong.pojo.http.LoginRequest;[m
 import com.lixiong.service.LoginService;[m
 import lombok.extern.slf4j.Slf4j;[m
 import org.springframework.beans.factory.annotation.Autowired;[m
[32m+[m[32mimport org.springframework.http.HttpStatus;[m
[32m+[m[32mimport org.springframework.http.ResponseEntity;[m
 import org.springframework.web.bind.annotation.*;[m
 [m
 @RestController[m
[36m@@ -34,19 +37,6 @@[m [mpublic class LoginController {[m
         return  Result.success(loginRespons);[m
     }[m
 [m
[31m-    @GetMapping("/loginByName")[m
[31m-    public Result getLoginInfor(String userName,String password) {[m
[31m-[m
[31m-        log.info("Get Login In :email : {} , password {}", userName , password);[m
[31m-[m
[31m-        LoginRespons loginRespons = loginService.getLoginInfor(userName,password);[m
[31m-[m
[31m-        if(loginRespons == null) {[m
[31m-            return  Result.error("登录失败，请重新登入");        }[m
[31m-[m
[31m-        return  Result.success(loginRespons);[m
[31m-    }[m
[31m-[m
     @PostMapping("/register")[m
     public Result register(@RequestBody  RegisterDataDto registerDataDto) {[m
         boolean res = loginService.register(registerDataDto);[m
[1mdiff --git a/ndis_system/nids_order_api/src/main/java/com/lixiong/controller/UserController.java b/ndis_system/nids_order_api/src/main/java/com/lixiong/controller/UserController.java[m
[1mdeleted file mode 100644[m
[1mindex 92d185d..0000000[m
[1m--- a/ndis_system/nids_order_api/src/main/java/com/lixiong/controller/UserController.java[m
[1m+++ /dev/null[m
[36m@@ -1,52 +0,0 @@[m
[31m-package com.lixiong.controller;[m
[31m-[m
[31m-import com.lixiong.pojo.Result;[m
[31m-import com.lixiong.pojo.User;[m
[31m-import com.lixiong.repository.UserRepository;[m
[31m-import lombok.extern.slf4j.Slf4j;[m
[31m-import org.springframework.beans.factory.annotation.Autowired;[m
[31m-import org.springframework.stereotype.Controller;[m
[31m-import org.springframework.web.bind.annotation.GetMapping;[m
[31m-import org.springframework.web.bind.annotation.PutMapping;[m
[31m-import org.springframework.web.bind.annotation.RequestBody;[m
[31m-import org.springframework.web.bind.annotation.RequestMapping;[m
[31m-[m
[31m-@Slf4j[m
[31m-@Controller[m
[31m-@RequestMapping("/user")[m
[31m-public class UserController {[m
[31m-[m
[31m-[m
[31m-    private UserRepository userRepository;[m
[31m-[m
[31m-    @Autowired[m
[31m-    public UserController(UserRepository userRepository) {[m
[31m-        this.userRepository = userRepository;[m
[31m-    }[m
[31m-[m
[31m-[m
[31m-[m
[31m-    @GetMapping("/getByPhone")[m
[31m-    public Result getUserByPhone(String phone) {[m
[31m-[m
[31m-        log.info( "getUserByPhone " + phone );[m
[31m-[m
[31m-        try{[m
[31m-            return Result.success(userRepository.findByPhone(phone));[m
[31m-        } catch (Exception e) {[m
[31m-            return Result.error(e.getMessage());[m
[31m-        }[m
[31m-[m
[31m-[m
[31m-    }[m
[31m-[m
[31m-//    @PutMapping("/putaAll")[m
[31m-//    public Result updateUser(@RequestBody User user) {[m
[31m-//        try{[m
[31m-//            userRepository.Update(user);[m
[31m-//            return Result.success("success!!");[m
[31m-//        } catch (Exception e) {[m
[31m-//            return Result.error(e.getMessage());[m
[31m-//        }[m
[31m-//    }[m
[31m-}[m
[1mdiff --git a/ndis_system/nids_order_api/src/main/java/com/lixiong/jwtFilter/JwtAuthFilter.java b/ndis_system/nids_order_api/src/main/java/com/lixiong/jwtFilter/JwtAuthFilter.java[m
[1mindex 52931dd..1c59f9a 100644[m
[1m--- a/ndis_system/nids_order_api/src/main/java/com/lixiong/jwtFilter/JwtAuthFilter.java[m
[1m+++ b/ndis_system/nids_order_api/src/main/java/com/lixiong/jwtFilter/JwtAuthFilter.java[m
[36m@@ -30,7 +30,6 @@[m [mpublic class JwtAuthFilter extends OncePerRequestFilter {[m
     // 定义不需要Token验证的路径[m
     private static final List<String> EXCLUDE_URLS = Arrays.asList([m
             "/api/login",[m
[31m-            "/api/loginByName",[m
             "/api/register"[m
     );[m
 [m
[36m@@ -49,8 +48,7 @@[m [mpublic class JwtAuthFilter extends OncePerRequestFilter {[m
         String requestPath = request.getRequestURI();[m
 [m
         // 检查当前请求是否在排除列表中[m
[31m-        //if (EXCLUDE_URLS.stream().anyMatch(requestPath::equals)) {[m
[31m-        if (EXCLUDE_URLS.stream().anyMatch(requestPath::equals) || 1==1) {[m
[32m+[m[32m        if (EXCLUDE_URLS.stream().anyMatch(requestPath::equals)) {[m
             filterChain.doFilter(request, response);[m
             return;[m
         }[m
[1mdiff --git a/ndis_system/nids_order_api/src/main/java/com/lixiong/jwtFilter/SecurityConfig.java b/ndis_system/nids_order_api/src/main/java/com/lixiong/jwtFilter/SecurityConfig.java[m
[1mindex 72cd760..f8446e4 100644[m
[1m--- a/ndis_system/nids_order_api/src/main/java/com/lixiong/jwtFilter/SecurityConfig.java[m
[1m+++ b/ndis_system/nids_order_api/src/main/java/com/lixiong/jwtFilter/SecurityConfig.java[m
[36m@@ -48,25 +48,25 @@[m [mpublic class SecurityConfig  {[m
          return new BCryptPasswordEncoder();[m
     }[m
 [m
[31m-//    @Bean[m
[31m-//    public CorsFilter corsFilter(){[m
[31m-//[m
[31m-//        CorsConfiguration config = new CorsConfiguration();[m
[31m-//[m
[31m-//        config.addAllowedOrigin("http://localhost:4200"); //允许【Angular】的前端访问[m
[31m-//        config.addAllowedOrigin("http://localhost:5173"); //允许【React】的前端访问[m
[31m-//        //config.addAllowedHeader("*");[m
[31m-//        config.setAllowedHeaders(Arrays.asList("*"));[m
[31m-//        config.setExposedHeaders(Arrays.asList("Authorization","token"));  // 暴露自定义头，以便前端可以读取[m
[31m-//[m
[31m-//        config.setAllowedMethods(Arrays.asList("GET", "POST", "PUT", "DELETE", "OPTIONS"));[m
[31m-//        //config.addAllowedMethod("*");[m
[31m-//        config.setAllowCredentials(true);[m
[31m-//[m
[31m-//        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();[m
[31m-//        source.registerCorsConfiguration("/**", config);[m
[31m-//        return new CorsFilter(source);[m
[31m-//    }[m
[32m+[m[32m    @Bean[m
[32m+[m[32m    public CorsFilter corsFilter(){[m
[32m+[m
[32m+[m[32m        CorsConfiguration config = new CorsConfiguration();[m
[32m+[m
[32m+[m[32m        config.addAllowedOrigin("http://localhost:4200"); //允许【Angular】的前端访问[m
[32m+[m[32m        config.addAllowedOrigin("http://localhost:5173"); //允许【React】的前端访问[m
[32m+[m[32m        //config.addAllowedHeader("*");[m
[32m+[m[32m        config.setAllowedHeaders(Arrays.asList("*"));[m
[32m+[m[32m        config.setExposedHeaders(Arrays.asList("Authorization","token"));  // 暴露自定义头，以便前端可以读取[m
[32m+[m
[32m+[m[32m        config.setAllowedMethods(Arrays.asList("GET", "POST", "PUT", "DELETE", "OPTIONS"));[m
[32m+[m[32m        //config.addAllowedMethod("*");[m
[32m+[m[32m        config.setAllowCredentials(true);[m
[32m+[m
[32m+[m[32m        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();[m
[32m+[m[32m        source.registerCorsConfiguration("/**", config);[m
[32m+[m[32m        return new CorsFilter(source);[m
[32m+[m[32m    }[m
 [m
 [m
     // 显式CORS配置（避免默认配置不生效）[m
[1mdiff --git a/ndis_system/nids_order_api/src/main/java/com/lixiong/pojo/NDISService.java b/ndis_system/nids_order_api/src/main/java/com/lixiong/pojo/NDISService.java[m
[1mindex 07ea097..f839813 100644[m
[1m--- a/ndis_system/nids_order_api/src/main/java/com/lixiong/pojo/NDISService.java[m
[1m+++ b/ndis_system/nids_order_api/src/main/java/com/lixiong/pojo/NDISService.java[m
[36m@@ -4,9 +4,11 @@[m [mimport jakarta.persistence.*;[m
 import lombok.AllArgsConstructor;[m
 import lombok.Data;[m
 import lombok.NoArgsConstructor;[m
[32m+[m[32mimport org.springframework.stereotype.Component;[m
 [m
 import java.math.BigDecimal;[m
 import java.time.LocalDateTime;[m
[32m+[m[32mimport java.time.LocalTime;[m
 [m
 @Entity(name = "ndis_service")[m
 @Data[m
[1mdiff --git a/ndis_system/nids_order_api/src/main/java/com/lixiong/pojo/ServiceOrder.java b/ndis_system/nids_order_api/src/main/java/com/lixiong/pojo/ServiceOrder.java[m
[1mindex e35d527..20dc7ea 100644[m
[1m--- a/ndis_system/nids_order_api/src/main/java/com/lixiong/pojo/ServiceOrder.java[m
[1m+++ b/ndis_system/nids_order_api/src/main/java/com/lixiong/pojo/ServiceOrder.java[m
[36m@@ -4,6 +4,7 @@[m [mimport jakarta.persistence.*;[m
 import lombok.AllArgsConstructor;[m
 import lombok.Data;[m
 import lombok.NoArgsConstructor;[m
[32m+[m[32mimport org.springframework.stereotype.Component;[m
 [m
 import java.time.LocalDateTime;[m
 import java.time.LocalTime;[m
[1mdiff --git a/ndis_system/nids_order_api/src/main/java/com/lixiong/pojo/User.java b/ndis_system/nids_order_api/src/main/java/com/lixiong/pojo/User.java[m
[1mindex 17b5fdb..9ae409e 100644[m
[1m--- a/ndis_system/nids_order_api/src/main/java/com/lixiong/pojo/User.java[m
[1m+++ b/ndis_system/nids_order_api/src/main/java/com/lixiong/pojo/User.java[m
[36m@@ -4,6 +4,7 @@[m [mimport jakarta.persistence.*;[m
 import lombok.AllArgsConstructor;[m
 import lombok.Data;[m
 import lombok.NoArgsConstructor;[m
[32m+[m[32mimport org.springframework.stereotype.Component;[m
 [m
 @Entity[m
 @Data[m
[1mdiff --git a/ndis_system/nids_order_api/src/main/java/com/lixiong/pojo/http/CorsConfig.java b/ndis_system/nids_order_api/src/main/java/com/lixiong/pojo/http/CorsConfig.java[m
[1mindex 0e2eded..8fcec33 100644[m
[1m--- a/ndis_system/nids_order_api/src/main/java/com/lixiong/pojo/http/CorsConfig.java[m
[1m+++ b/ndis_system/nids_order_api/src/main/java/com/lixiong/pojo/http/CorsConfig.java[m
[36m@@ -1,35 +1,34 @@[m
[31m-package com.lixiong.pojo.http;[m
[31m-[m
[31m-import lombok.AllArgsConstructor;[m
[31m-import org.springframework.context.annotation.Bean;[m
[31m-import org.springframework.context.annotation.Configuration;[m
[31m-import org.springframework.web.cors.CorsConfiguration;[m
[31m-import org.springframework.web.cors.UrlBasedCorsConfigurationSource;[m
[31m-import org.springframework.web.filter.CorsFilter;[m
[31m-[m
[31m-/**[m
[31m- * 【CorsConfig】是，前后端跨域访问时，限制不明的访问！！！[m
[31m- * 只有被允许的【路径】才能访问后端。[m
[31m- * 如：以下【"http://localhost:4200"】[m
[31m- *[m
[31m- */[m
[31m-@Configuration[m
[31m-public class CorsConfig {[m
[31m-[m
[31m-    @Bean[m
[31m-    public CorsFilter corsFilter(){[m
[31m-[m
[31m-        CorsConfiguration config = new CorsConfiguration();[m
[31m-[m
[31m-        config.addAllowedOrigin("http://localhost:4200"); //允许【Angular】的前端访问[m
[31m-        config.addAllowedOrigin("http://localhost:5173"); //允许【React】的前端访问[m
[31m-        config.addAllowedHeader("*");[m
[31m-        config.addAllowedMethod("*");[m
[31m-        config.setAllowCredentials(true);[m
[31m-[m
[31m-        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();[m
[31m-        source.registerCorsConfiguration("/**", config);[m
[31m-        return new CorsFilter(source);[m
[31m-    }[m
[31m-[m
[31m-}[m
[32m+[m[32m//package com.lixiong.pojo.http;[m
[32m+[m[32m//[m
[32m+[m[32m//import lombok.AllArgsConstructor;[m
[32m+[m[32m//import org.springframework.context.annotation.Bean;[m
[32m+[m[32m//import org.springframework.context.annotation.Configuration;[m
[32m+[m[32m//import org.springframework.web.cors.CorsConfiguration;[m
[32m+[m[32m//import org.springframework.web.cors.UrlBasedCorsConfigurationSource;[m
[32m+[m[32m//import org.springframework.web.filter.CorsFilter;[m
[32m+[m[32m//[m
[32m+[m[32m///**[m
[32m+[m[32m// * 【CorsConfig】是，前后端跨域访问时，限制不明的访问！！！[m
[32m+[m[32m// * 只有被允许的【路径】才能访问后端。[m
[32m+[m[32m// * 如：以下【"http://localhost:4200"】[m
[32m+[m[32m// *[m
[32m+[m[32m// */[m
[32m+[m[32m//@Configuration[m
[32m+[m[32m//public class CorsConfig {[m
[32m+[m[32m//[m
[32m+[m[32m//    @Bean[m
[32m+[m[32m//    public CorsFilter corsFilter(){[m
[32m+[m[32m//[m
[32m+[m[32m//        CorsConfiguration config = new CorsConfiguration();[m
[32m+[m[32m//[m
[32m+[m[32m//        config.addAllowedOrigin("http://localhost:4200"); //允许【Angular】的前端访问[m
[32m+[m[32m//        config.addAllowedHeader("*");[m
[32m+[m[32m//        config.addAllowedMethod("*");[m
[32m+[m[32m//        config.setAllowCredentials(true);[m
[32m+[m[32m//[m
[32m+[m[32m//        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();[m
[32m+[m[32m//        source.registerCorsConfiguration("/**", config);[m
[32m+[m[32m//        return new CorsFilter(source);[m
[32m+[m[32m//    }[m
[32m+[m[32m//[m
[32m+[m[32m//}[m
[1mdiff --git a/ndis_system/nids_order_api/src/main/java/com/lixiong/repository/UserRepository.java b/ndis_system/nids_order_api/src/main/java/com/lixiong/repository/UserRepository.java[m
[1mindex 5c07c2b..f5a5cf4 100644[m
[1m--- a/ndis_system/nids_order_api/src/main/java/com/lixiong/repository/UserRepository.java[m
[1m+++ b/ndis_system/nids_order_api/src/main/java/com/lixiong/repository/UserRepository.java[m
[36m@@ -1,10 +1,6 @@[m
 package com.lixiong.repository;[m
 [m
 import com.lixiong.pojo.User;[m
[31m-import com.mysql.cj.x.protobuf.MysqlxCrud;[m
[31m-import com.mysql.cj.xdevapi.UpdateParams;[m
[31m-import org.hibernate.annotations.SQLUpdate;[m
[31m-import org.hibernate.sql.Update;[m
 import org.springframework.data.jpa.repository.JpaRepository;[m
 [m
 import java.util.List;[m
[36m@@ -15,13 +11,5 @@[m [mpublic interface UserRepository extends JpaRepository<User, Long> {[m
 [m
      Optional<User> findByUserName(String userName);[m
 [m
[31m-     User findByPhone(String phone);[m
 [m
[31m-     //User findByEmail(String email);[m
[31m-[m
[31m-[m
[31m-     //void Update(User user);[m
[31m-[m
[31m-[m
[31m-[m
[31m-     }[m
[32m+[m[32m}[m
[1mdiff --git a/ndis_system/nids_order_api/src/main/java/com/lixiong/service/NDISServiceService.java b/ndis_system/nids_order_api/src/main/java/com/lixiong/service/NDISServiceService.java[m
[1mindex b1d7b51..596bcb6 100644[m
[1m--- a/ndis_system/nids_order_api/src/main/java/com/lixiong/service/NDISServiceService.java[m
[1m+++ b/ndis_system/nids_order_api/src/main/java/com/lixiong/service/NDISServiceService.java[m
[36m@@ -21,7 +21,7 @@[m [mpublic class NDISServiceService {[m
     private NDISServiceRepository ndisServiceRepository;[m
 [m
     @Autowired[m
[31m-    public NDISServiceService(ServiceTypeRepository serviceTypeRepository,UserRepository userRepository,NDISServiceRepository ndisServiceRepository) {[m
[32m+[m[32m    private NDISServiceService(ServiceTypeRepository serviceTypeRepository,UserRepository userRepository,NDISServiceRepository ndisServiceRepository) {[m
         this.serviceTypeRepository = serviceTypeRepository;[m
         this.userRepository = userRepository;[m
         this.ndisServiceRepository = ndisServiceRepository;[m
[1mdiff --git a/ndis_system/nids_order_api/src/main/java/com/lixiong/service/UserService.java b/ndis_system/nids_order_api/src/main/java/com/lixiong/service/UserService.java[m
[1mdeleted file mode 100644[m
[1mindex e8cf30b..0000000[m
[1m--- a/ndis_system/nids_order_api/src/main/java/com/lixiong/service/UserService.java[m
[1m+++ /dev/null[m
[36m@@ -1,29 +0,0 @@[m
[31m-package com.lixiong.service;[m
[31m-[m
[31m-import com.lixiong.pojo.User;[m
[31m-import com.lixiong.repository.UserRepository;[m
[31m-import org.springframework.stereotype.Service;[m
[31m-[m
[31m-import java.util.Optional;[m
[31m-[m
[31m-@Service[m
[31m-public class UserService {[m
[31m-[m
[31m-    private UserRepository userRepository;[m
[31m-    //private User user;[m
[31m-[m
[31m-    public UserService(UserRepository userRepository) {[m
[31m-        this.userRepository = userRepository;[m
[31m-        //this.user = newUser;[m
[31m-    }[m
[31m-[m
[31m-    public User getUserByPhone(String phone) {[m
[31m-[m
[31m-        return userRepository.findByPhone(phone);[m
[31m-[m
[31m-    }[m
[31m-[m
[31m-//    public void updateUser(User user) {[m
[31m-//        userRepository.Update(user);[m
[31m-//    }[m
[31m-}[m
[1mdiff --git a/ndis_system/nids_order_api/target/classes/com/lixiong/controller/LoginController.class b/ndis_system/nids_order_api/target/classes/com/lixiong/controller/LoginController.class[m
[1mindex 76c78e9..ad846d2 100644[m
Binary files a/ndis_system/nids_order_api/target/classes/com/lixiong/controller/LoginController.class and b/ndis_system/nids_order_api/target/classes/com/lixiong/controller/LoginController.class differ
[1mdiff --git a/ndis_system/nids_order_api/target/classes/com/lixiong/controller/UserController.class b/ndis_system/nids_order_api/target/classes/com/lixiong/controller/UserController.class[m
[1mdeleted file mode 100644[m
[1mindex 1496ab4..0000000[m
Binary files a/ndis_system/nids_order_api/target/classes/com/lixiong/controller/UserController.class and /dev/null differ
[1mdiff --git a/ndis_system/nids_order_api/target/classes/com/lixiong/jwtFilter/JwtAuthFilter.class b/ndis_system/nids_order_api/target/classes/com/lixiong/jwtFilter/JwtAuthFilter.class[m
[1mindex 064c05b..d4142f6 100644[m
Binary files a/ndis_system/nids_order_api/target/classes/com/lixiong/jwtFilter/JwtAuthFilter.class and b/ndis_system/nids_order_api/target/classes/com/lixiong/jwtFilter/JwtAuthFilter.class differ
[1mdiff --git a/ndis_system/nids_order_api/target/classes/com/lixiong/jwtFilter/SecurityConfig.class b/ndis_system/nids_order_api/target/classes/com/lixiong/jwtFilter/SecurityConfig.class[m
[1mindex 134a22d..4afa489 100644[m
Binary files a/ndis_system/nids_order_api/target/classes/com/lixiong/jwtFilter/SecurityConfig.class and b/ndis_system/nids_order_api/target/classes/com/lixiong/jwtFilter/SecurityConfig.class differ
[1mdiff --git a/ndis_system/nids_order_api/target/classes/com/lixiong/pojo/NDISService.class b/ndis_system/nids_order_api/target/classes/com/lixiong/pojo/NDISService.class[m
[1mindex 4234cdd..f165cb8 100644[m
Binary files a/ndis_system/nids_order_api/target/classes/com/lixiong/pojo/NDISService.class and b/ndis_system/nids_order_api/target/classes/com/lixiong/pojo/NDISService.class differ
[1mdiff --git a/ndis_system/nids_order_api/target/classes/com/lixiong/pojo/ServiceOrder.class b/ndis_system/nids_order_api/target/classes/com/lixiong/pojo/ServiceOrder.class[m
[1mindex 697b46d..33f1e0c 100644[m
Binary files a/ndis_system/nids_order_api/target/classes/com/lixiong/pojo/ServiceOrder.class and b/ndis_system/nids_order_api/target/classes/com/lixiong/pojo/ServiceOrder.class differ
[1mdiff --git a/ndis_system/nids_order_api/target/classes/com/lixiong/pojo/User$role.class b/ndis_system/nids_order_api/target/classes/com/lixiong/pojo/User$role.class[m
[1mindex 1b7050b..17e715b 100644[m
Binary files a/ndis_system/nids_order_api/target/classes/com/lixiong/pojo/User$role.class and b/ndis_system/nids_order_api/target/classes/com/lixiong/pojo/User$role.class differ
[1mdiff --git a/ndis_system/nids_order_api/target/classes/com/lixiong/pojo/User.class b/ndis_system/nids_order_api/target/classes/com/lixiong/pojo/User.class[m
[1mindex 6cf159f..fdc8093 100644[m
Binary files a/ndis_system/nids_order_api/target/classes/com/lixiong/pojo/User.class and b/ndis_system/nids_order_api/target/classes/com/lixiong/pojo/User.class differ
[1mdiff --git a/ndis_system/nids_order_api/target/classes/com/lixiong/pojo/http/CorsConfig.class b/ndis_system/nids_order_api/target/classes/com/lixiong/pojo/http/CorsConfig.class[m
[1mdeleted file mode 100644[m
[1mindex c573b6d..0000000[m
Binary files a/ndis_system/nids_order_api/target/classes/com/lixiong/pojo/http/CorsConfig.class and /dev/null differ
[1mdiff --git a/ndis_system/nids_order_api/target/classes/com/lixiong/repository/UserRepository.class b/ndis_system/nids_order_api/target/classes/com/lixiong/repository/UserRepository.class[m
[1mindex 6ebf974..48beb50 100644[m
Binary files a/ndis_system/nids_order_api/target/classes/com/lixiong/repository/UserRepository.class and b/ndis_system/nids_order_api/target/classes/com/lixiong/repository/UserRepository.class differ
[1mdiff --git a/ndis_system/nids_order_api/target/classes/com/lixiong/service/NDISServiceService.class b/ndis_system/nids_order_api/target/classes/com/lixiong/service/NDISServiceService.class[m
[1mindex 0625f61..410e72b 100644[m
Binary files a/ndis_system/nids_order_api/target/classes/com/lixiong/service/NDISServiceService.class and b/ndis_system/nids_order_api/target/classes/com/lixiong/service/NDISServiceService.class differ
[1mdiff --git a/ndis_system/nids_order_api/target/classes/com/lixiong/service/UserService.class b/ndis_system/nids_order_api/target/classes/com/lixiong/service/UserService.class[m
[1mdeleted file mode 100644[m
[1mindex f39fb8f..0000000[m
Binary files a/ndis_system/nids_order_api/target/classes/com/lixiong/service/UserService.class and /dev/null differ
