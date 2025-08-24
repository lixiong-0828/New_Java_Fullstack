package com.lixiong.pojo;

import jakarta.persistence.*;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;


@Entity
@Component
@Data
@AllArgsConstructor
@NoArgsConstructor
public class OrderType {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long orderTypeId;

    @Column(nullable = false, unique = true)
    private String orderTypeName;

    private String description;

  }
