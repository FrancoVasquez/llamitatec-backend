package com.llamitatec.backend.service.domain.persistence;

import com.llamitatec.backend.service.domain.model.entity.Service;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ServiceRepository extends JpaRepository<Service,Long> {
    Service findByName(String name);
}
