package com.llamitatec.backend.service.service;

import com.llamitatec.backend.service.domain.persistence.ServiceRepository;
import com.llamitatec.backend.service.domain.service.ServiceService;
import com.llamitatec.backend.shared.exception.ResourceNotFoundException;
import com.llamitatec.backend.shared.exception.ResourceValidationException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import javax.validation.ConstraintViolation;
import javax.validation.Validator;
import java.util.List;
import java.util.Set;

@Service
public class ServiceServiceImpl implements ServiceService {
    private static final String ENTITY = "Service";
    private final ServiceRepository serviceRepository;
    private final Validator validator;

    public ServiceServiceImpl(ServiceRepository serviceRepository, Validator validator) {
        this.serviceRepository = serviceRepository;
        this.validator = validator;
    }

    @Override
    public List<com.llamitatec.backend.service.domain.model.entity.Service> getAll() {
        return serviceRepository.findAll();
    }

    @Override
    public Page<com.llamitatec.backend.service.domain.model.entity.Service> getAll(Pageable pageable) {
        return serviceRepository.findAll(pageable);
    }

    @Override
    public com.llamitatec.backend.service.domain.model.entity.Service getById(Long serviceId) {
        return serviceRepository.findById(serviceId)
                .orElseThrow(()-> new ResourceNotFoundException(ENTITY,serviceId)) ;
    }

    @Override
    public com.llamitatec.backend.service.domain.model.entity.Service create(com.llamitatec.backend.service.domain.model.entity.Service service) {
        Set<ConstraintViolation<com.llamitatec.backend.service.domain.model.entity.Service>> violations=validator.validate(service);

        if(!violations.isEmpty())
            throw new ResourceValidationException(ENTITY,violations);

        return serviceRepository.save(service);
    }

    @Override
    public com.llamitatec.backend.service.domain.model.entity.Service update(Long serviceId, com.llamitatec.backend.service.domain.model.entity.Service request) {
        Set<ConstraintViolation<com.llamitatec.backend.service.domain.model.entity.Service>> violations=validator.validate(request);
        if(!violations.isEmpty())
            throw new ResourceValidationException(ENTITY,violations);

        if(!serviceRepository.existsById(serviceId))
            throw new ResourceNotFoundException("Service", serviceId);

        return serviceRepository.findById(serviceId).map(user ->
                        serviceRepository.save(user.withName(request.getName())
                                .withDescription(request.getDescription())
                                .withUrlToImage(request.getUrlToImage())))
                .orElseThrow(()-> new ResourceNotFoundException(ENTITY,serviceId));
    }

    @Override
    public ResponseEntity<?> delete(Long serviceId) {
        return serviceRepository.findById(serviceId).map(data ->{
            serviceRepository.delete(data);
            return ResponseEntity.ok().build();
        }).orElseThrow(()-> new ResourceNotFoundException(ENTITY,serviceId));
    }
}
