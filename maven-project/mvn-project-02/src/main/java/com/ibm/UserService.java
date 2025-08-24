package com.ibm;

//import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;

public class UserService {
    /**
     * 根据身份证，算出年龄
     * @param idCard
     * @return
     */

    public Integer getAge(String idCard){
        String birthDay = idCard.substring(6, 14);
        LocalDate birthDate = LocalDate.parse(birthDay, DateTimeFormatter.ofPattern("yyyyMMdd"));
        return Period.between(birthDate, LocalDate.now()).getYears();
    }

    /**
     * 根据身份证，算出性别
     * @param idCard
     * @return
     */
    public String getGender(String idCard){
        return Integer.parseInt(idCard.substring(16, 17)) % 2 == 1? "男" : "女";
    }

    /**
     * 由于，Junit包的范围为【test】，所以不能再【main】使用
     */
//    @Test
//    public void getGender3(){
//        String gender = new UserService().getGender("22240519790928061X");
//        System.out.println(gender);
//
//    }


}
