package com.lixiong.service;

import com.lixiong.pojo.NDISService;
import com.lixiong.pojo.ServiceType;
import com.lixiong.pojo.User;
import com.lixiong.pojo.dto.CreateServiceRequestDto;
import com.lixiong.pojo.dto.ServiceResponseDto;
import com.lixiong.pojo.exception.ResourceNotFoundException;
import com.lixiong.repository.NDISServiceRepository;
import com.lixiong.repository.ServiceTypeRepository;
import com.lixiong.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class NDISServiceService {


    private ServiceTypeRepository serviceTypeRepository;
    private UserRepository userRepository;
    private NDISServiceRepository ndisServiceRepository;

    @Autowired
    private NDISServiceService(ServiceTypeRepository serviceTypeRepository,UserRepository userRepository,NDISServiceRepository ndisServiceRepository) {
        this.serviceTypeRepository = serviceTypeRepository;
        this.userRepository = userRepository;
        this.ndisServiceRepository = ndisServiceRepository;
    }


    public ServiceResponseDto CreateNDISService(CreateServiceRequestDto createServiceRequestDto) {


        NDISService ndisService = new NDISService();
        ServiceType serviceType = serviceTypeRepository.findById(createServiceRequestDto.getServiceTypeId()).orElseThrow(() -> new ResourceNotFoundException("Service Type Not Found"));
        User user = userRepository.findById(createServiceRequestDto.getUserId()).orElseThrow(() -> new ResourceNotFoundException("User Not Found"));

        ndisService.setServiceName(createServiceRequestDto.getServiceName());
        ndisService.setServiceType(serviceType);
        ndisService.setDescription(createServiceRequestDto.getServiceDescription());
        ndisService.setPrice(createServiceRequestDto.getPrice());
        ndisService.setProvider(user);

        NDISService newService = ndisServiceRepository.save(ndisService);

        ServiceResponseDto serviceResponseDto = new ServiceResponseDto();
        serviceResponseDto.setServiceName(newService.getServiceName());
        serviceResponseDto.setServiceId(newService.getServiceId());
        serviceResponseDto.setServiceDescription(newService.getDescription());
        serviceResponseDto.setPrice(newService.getPrice());
        serviceResponseDto.setServiceTypeName(newService.getServiceType().getServiceTypeName());
        serviceResponseDto.setProviderName(newService.getProvider().getFullName());

        return serviceResponseDto;


    }

}
