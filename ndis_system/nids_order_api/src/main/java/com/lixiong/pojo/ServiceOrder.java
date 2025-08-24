package com.lixiong.pojo;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.time.LocalTime;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ServiceOrder {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long orderId;

    @ManyToOne
    @JoinColumn(name = "user", nullable=false)
    private User user;

    @ManyToOne
    @JoinColumn(name = "order_type_id", nullable=false)
    private OrderType orderType;

    @ManyToOne
    @JoinColumn(name = "order_status_id", nullable=false)
    private OrderStatus orderStatus;

    @ManyToOne
    @JoinColumn(name = "service_id", nullable=false)
    private NDISService ndisService;


    @Column(nullable=false)
    private LocalTime orderDate;

    @Column(nullable = false,updatable = false  )
    private LocalDateTime createTime = LocalDateTime.now();
    private LocalDateTime updateTime = LocalDateTime.now();


}
