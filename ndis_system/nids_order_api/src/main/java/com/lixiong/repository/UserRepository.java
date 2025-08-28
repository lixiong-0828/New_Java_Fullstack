package com.lixiong.repository;

import com.lixiong.pojo.User;
import com.mysql.cj.x.protobuf.MysqlxCrud;
import com.mysql.cj.xdevapi.UpdateParams;
import org.hibernate.annotations.SQLUpdate;
import org.hibernate.sql.Update;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {
     Optional<User> findByEmail(String email);

     Optional<User> findByUserName(String userName);

     User findByPhone(String phone);

     //User findByEmail(String email);


     //void Update(User user);



     }
