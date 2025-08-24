package com.lixiong.pojo.http;

import lombok.Data;

@Data
public class LoginRequest {

    private String userName;
    private String password;
    private String email;
}
