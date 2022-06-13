package com.llamitatec.backend.employee.resource;

import com.llamitatec.backend.service.resource.ServiceResource;
import com.llamitatec.backend.user.resource.UserResource;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class EmployeeResource {
    private Long id;
    private String name;
    private int age;
    private String email;
    private String phone;
    private String altphone;
    private String urlToImage;
    private String description;
    private ServiceResource service;
    private UserResource user;
}
