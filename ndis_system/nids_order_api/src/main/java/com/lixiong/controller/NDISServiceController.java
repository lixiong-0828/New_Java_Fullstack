package com.lixiong.controller;

import com.lixiong.pojo.NDISService;
import com.lixiong.pojo.Result;
import com.lixiong.pojo.dto.CreateServiceRequestDto;
import com.lixiong.pojo.dto.ServiceResponseDto;
import com.lixiong.service.NDISServiceService;
import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping("/api")
public class NDISServiceController {

    @Autowired
    private NDISServiceService ndisServiceService;

    public NDISServiceController() {}

    @PostMapping("/ndis-service")
    public Result createNDISService(@RequestBody CreateServiceRequestDto requestDto) {

        log.info("Create NDIS Service : {}", requestDto);
        ServiceResponseDto serviceResponseDto = ndisServiceService.CreateNDISService(requestDto);
        if(serviceResponseDto !=null) {
            return  Result.success(serviceResponseDto);
        }else {
            return Result.error("Create NDIS Service Failed");
        }



    }
}
