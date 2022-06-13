package com.llamitatec.backend.employee.resource;

import com.llamitatec.backend.service.resource.ServiceResource;
import com.llamitatec.backend.user.resource.UserResource;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Getter
@Setter
public class CreateEmployeeResource {
    @NotNull
    @NotBlank
    @Size(max=100)
    private String name;

    private int age;

    @NotNull
    @NotBlank
    @Size(max = 40)
    private String email;

    @NotNull
    @NotBlank
    @Size(max = 9)
    private String phone;

    @NotNull
    @NotBlank
    @Size(max = 5)
    private String altphone;

    @NotNull
    @NotBlank
    private String urlToImage;

    @NotNull
    @NotBlank
    @Size(max = 1000)
    private String description;
}
