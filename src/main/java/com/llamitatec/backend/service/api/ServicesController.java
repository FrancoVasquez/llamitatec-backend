package com.llamitatec.backend.service.api;

import com.llamitatec.backend.service.domain.service.ServiceService;
import com.llamitatec.backend.service.mapping.ServiceMapper;

import com.llamitatec.backend.service.resource.CreateServiceResource;
import com.llamitatec.backend.service.resource.ServiceResource;
import com.llamitatec.backend.service.resource.UpdateServiceResource;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "api/v1/services")
public class ServicesController {
    private final ServiceService serviceService;
    private final ServiceMapper mapper;


    public ServicesController(ServiceService serviceService, ServiceMapper mapper) {
        this.serviceService = serviceService;
        this.mapper = mapper;
    }

    @GetMapping
    public Page<ServiceResource> getAllServices(Pageable pageable){
        return mapper.modelListPage(serviceService.getAll(),pageable);
    }

    @GetMapping("{serviceId}")
    public ServiceResource getServiceById(@PathVariable("serviceId") Long serviceId){
        return mapper.toResource(serviceService.getById(serviceId));
    }

    @PostMapping
    public ServiceResource createService(@RequestBody CreateServiceResource resource){
        return mapper.toResource(serviceService.create(mapper.toModel(resource)));
    }

    @PutMapping("{serviceId}")
    private ServiceResource updateService(@PathVariable("serviceId") Long serviceId,@RequestBody UpdateServiceResource resource){
        return mapper.toResource(serviceService.update(serviceId,mapper.toModel(resource)));
    }

    @DeleteMapping("{serviceId}")
    public ResponseEntity<?> deleteService(@PathVariable("serviceId") Long serviceId){
        return serviceService.delete(serviceId);
    }
}
