package com.lixiong.repository;

import com.lixiong.pojo.NDISService;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ServiceRepository extends JpaRepository<NDISService, Long> {
    boolean existsByServiceName(String serviceName);
}
