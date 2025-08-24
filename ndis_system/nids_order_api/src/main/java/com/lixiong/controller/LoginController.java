package com.lixiong.controller;

import com.lixiong.pojo.LoginRespons;
import com.lixiong.pojo.Result;
import com.lixiong.pojo.User;
import com.lixiong.pojo.dto.RegisterDataDto;
import com.lixiong.pojo.http.LoginRequest;
import com.lixiong.service.LoginService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@Slf4j
@RequestMapping("/api")
public class LoginController {

    private LoginService loginService;

    @Autowired
    public LoginController(LoginService loginService) {
        this.loginService = loginService;
    }

    @PostMapping("/login")
    public Result getLoginInfor(@RequestBody  LoginRequest loginRequest) {

            log.info("Get Login In :email : {} , password {}", loginRequest.getUserName() , loginRequest.getPassword());

        LoginRespons loginRespons = loginService.getLoginInfor(loginRequest.getUserName(),loginRequest.getPassword());

        if(loginRespons == null) {
            return  Result.error("登录失败，请重新登入");        }

        return  Result.success(loginRespons);
    }

    @PostMapping("/register")
    public Result register(@RequestBody  RegisterDataDto registerDataDto) {
        boolean res = loginService.register(registerDataDto);
        return Result.success();
    }
}
