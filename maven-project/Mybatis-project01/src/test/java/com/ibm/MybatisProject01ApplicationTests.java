package com.ibm;

import com.ibm.mapper.UserMapper;
import com.ibm.pojo.user;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
class MybatisProject01ApplicationTests {

    @Test
    void contextLoads() {
    }

    @Autowired
    private UserMapper userMapper;

    @Test
    public void findAll() {
        List<user> list = userMapper.findAll();
        list.forEach(System.out::println);
    }

}
