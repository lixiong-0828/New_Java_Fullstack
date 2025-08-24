package com.ibm.mapper;


import com.ibm.pojo.dept;
import org.apache.ibatis.annotations.*;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Mapper
public interface DeptMapper {

    /**
     * 3中方法解决映射问题：
     * ①使用【@Result】
     * ②使用别名
     * ③打开，驼峰命名映射开关 <--<--（推荐！！！）
     *
     * @return
     */

//    @Results({
//            @Result(column = "create_time",property = "createTime"),
//            @Result(column = "update_time",property = "updateTime")
//    })
//@Select("select id, name, create_time createTime, update_time updateTime from dept")

    //设置【驼峰命名映射开关打开】后
    @Select("select id, name, create_time, update_time from dept")
    public List<dept> findAll();

    @Delete("delete from dept where id= #{id} ")
    public void deleteById(java.lang.Integer id);

    @Insert("INSERT INTO dept(name, create_time, update_time) values (#{name},#{createTime} ,#{updateTime}) ")
    void add(dept dept);

    @Select("select name from dept where id = #{id} ")
    String getDeptById(Integer id);

    //@Update("update dept set name=#{name} ,update_time=#{updateTime}  where id=#{id} ")
    void updateName(dept dept);
}
