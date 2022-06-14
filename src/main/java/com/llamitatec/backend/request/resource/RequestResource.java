package com.llamitatec.backend.request.resource;

import com.llamitatec.backend.client.resource.ClientResource;
import com.llamitatec.backend.employee.resource.EmployeeResource;
import com.llamitatec.backend.service.resource.ServiceResource;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class RequestResource {
    private Long id;
    private String title;
    private String description;
    private String urlToImage;
    private Boolean paid;
    private ServiceResource service;
    private ClientResource client;
    private EmployeeResource employee;
}
