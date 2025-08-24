package com.lixiong.pojo.dto;

import lombok.Data;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;

@Data
@Component
public class ServiceResponseDto {

    private Long serviceId;
    private String serviceName;

    private String serviceDescription;

    private BigDecimal price ;

    private String serviceTypeName;

    private String providerName;
}
