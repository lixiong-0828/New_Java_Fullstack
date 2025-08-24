package com.ibm.mapper;
import com.ibm.pojo.user;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.jdbc.support.CustomSQLErrorCodesTranslation;

import java.util.List;

//声明当前接口是mybatis的持久层接口，框架运行时，自动为该接口生成实例（代理对象），且把实例交给IOC容器管理
@Mapper
public interface UserMapper {

    //@Select("select id, username, name, age, gender from user")
    public List<user> findAll();
}
