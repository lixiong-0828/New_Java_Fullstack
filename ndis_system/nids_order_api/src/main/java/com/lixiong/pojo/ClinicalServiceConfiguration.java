package com.lixiong.pojo;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.time.LocalTime;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ClinicalServiceConfiguration {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long configureId;

    @OneToOne
    @JoinColumn(name = "order_id", nullable=false)
    private ServiceOrder serviceOrder;

    @Column(nullable = false )
    private Integer maxSessionPerWeek;

    @Column(nullable = false )
    private Boolean requiredDoctorApproval;

    @Column(nullable = false )
    private Integer therapyDurationMinutes;

    @Column(nullable = false,updatable = false  )
    private LocalDateTime createTime = LocalDateTime.now();
    private LocalDateTime updateTime = LocalDateTime.now();


}
