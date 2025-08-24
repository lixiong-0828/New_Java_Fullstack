package com.lixiong.service;

import com.lixiong.pojo.LoginRespons;
import com.lixiong.pojo.User;
import com.lixiong.pojo.dto.RegisterDataDto;
import com.lixiong.repository.UserRepository;
import com.lixiong.utils.GetJwtUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

@Service
@Slf4j
public class LoginService {

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private GetJwtUtil getJwtUtil;

    @Autowired
    private PasswordEncoder passwordEncoder;


    public LoginRespons getLoginInfor(String userName, String password) {


        Optional<User> user = userRepository.findByUserName(userName);

        if(user != null && passwordEncoder.matches(password, user.get().getPassword())) {

            Map<String,Object> claims = new HashMap<>();
            claims.put("id", user.get().getUserId());
            claims.put("userName", userName);
            claims.put("name", user.get().getFullName());
            claims.put("email", user.get().getEmail());


            String token = getJwtUtil.getJwt(claims);

            LoginRespons loginRespons = new LoginRespons();
            loginRespons.setToken(token);
            loginRespons.setUsername(userName);
            loginRespons.setName(user.get().getFullName());
            loginRespons.setEmail(user.get().getEmail());

            return loginRespons;
        }else {
            log.info("==========not exsit email : {} , password {}===========", userName , password);
            return null;
        }
    }

    public boolean register(RegisterDataDto registerDataDto) {
        User user = new User();
        user.setUserName(registerDataDto.getUserName());
        user.setFullName(registerDataDto.getFullName());
        user.setEmail(registerDataDto.getEmail());
        user.setPassword(passwordEncoder.encode(registerDataDto.getPassword()));
        user.setRole(User.role.CUSTOMER);

        userRepository.save(user);
        return true;

    }
}

