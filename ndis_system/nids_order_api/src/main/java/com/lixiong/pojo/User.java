package com.lixiong.pojo;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long userId;

    @Column(unique=true, nullable=false)
    private String userName;

    private String password;

    @Column(unique=true, nullable=false)
    private String email;

    private String phone;

    private String fullName;

    public enum role{
        PROVIDER,CUSTOMER,ADMIN
    }

    @Column(nullable=false)
    @Enumerated(EnumType.STRING)
    private role role;


}
