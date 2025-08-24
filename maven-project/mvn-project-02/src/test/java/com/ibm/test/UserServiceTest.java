package com.ibm.test;

import com.ibm.UserService;
import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;


public class UserServiceTest {

    @BeforeAll
    public static void beforeAll(){
        System.out.println("before all");
    }

    @AfterAll
    public static void afterAll(){
        System.out.println("after all");
    }

    @BeforeEach
    public void beforeEach(){
        System.out.println("beforeEach");
    }

    @AfterEach
    public void afterEach(){
        System.out.println("afterEach");
    }

    @Test
    public void testGetAge(){
        Integer age = new UserService().getAge("22240519800828061X");
        System.out.println(age);
    }


    @Test
    public void getGender(){
        String gender = new UserService().getGender("22240519800828061X");
        System.out.println(gender);
    }

    /**
     * 参数化测试
     */
    @DisplayName("参数化测试")
    @ValueSource(strings = {"22240519800828061X","22240519760828060X"})
    @ParameterizedTest
    public void getGender2(String idCard){
        String gender = new UserService().getGender(idCard);
        System.out.println(gender);
    }

    /**
     * Assertion ：断言
     */
    @DisplayName("断言测试")
    @Test
    public void getGender3(){
        String gender = new UserService().getGender("22240519790928061X");
        Assertions.assertEquals("男", gender);
    }

    /**
     * Assertion ：断言
     */
    @DisplayName("带信息的断言测试")
    @Test
    public void getGender4(){
        String gender = new UserService().getGender("22240519790928061X");

        //Assertions.assertEquals("女", gender,"性别算出错误");
        Assertions.assertEquals("男", gender,"性别算出正确");
    }

}
