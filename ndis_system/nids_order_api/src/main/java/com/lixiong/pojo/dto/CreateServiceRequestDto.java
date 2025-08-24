package com.lixiong.pojo.dto;

import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.Digits;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;

@Data
@Component
public class CreateServiceRequestDto {

    @NotBlank(message = "service name is required")
    private String serviceName;

    private String serviceDescription;

    @NotNull
    @Digits(integer = 8, fraction = 2)
    @DecimalMin(value = "0.0", inclusive = false,message = "price must greater than zero!")
    private BigDecimal price ;

    @NotNull(message = "service Type is required")
    private Long serviceTypeId;
    @NotNull(message = "User Id is required")
    private Long userId;

    private String token;

}
