package com.lixiong.service;

import com.lixiong.pojo.User;
import com.lixiong.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService {

    private UserRepository userRepository;
    //private User user;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
        //this.user = newUser;
    }

    public User getUserByPhone(String phone) {

        return userRepository.findByPhone(phone);

    }

//    public void updateUser(User user) {
//        userRepository.Update(user);
//    }
}
