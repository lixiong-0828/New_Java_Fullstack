package com.ibm;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class hello {
    @RequestMapping("/hello")
    public String hello(String name) {
        System.out.println("hello ~~~ name:" + name);
    	System.out.println("have a change for github upload!!!");
        return "Hello World, name:" + name;
    }
}
