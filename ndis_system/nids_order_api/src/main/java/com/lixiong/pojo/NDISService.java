package com.lixiong.pojo;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.time.LocalTime;

@Entity(name = "ndis_service")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class NDISService {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long serviceId;

    @Column(nullable = false)
    private String serviceName;

    private String description;

    @Column(nullable = false)
    private BigDecimal price;

    @ManyToOne
    @JoinColumn(nullable = false,name = "service_type_id")
    private ServiceType serviceType;

    @ManyToOne
    @JoinColumn(nullable = false,name = "provider_id")
    private User provider;

    @Column(nullable = false,updatable = false  )
    private LocalDateTime createTime = LocalDateTime.now();
    private LocalDateTime updateTime = LocalDateTime.now();


}
