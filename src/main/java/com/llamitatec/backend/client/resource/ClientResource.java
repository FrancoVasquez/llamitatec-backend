package com.llamitatec.backend.client.resource;

import com.llamitatec.backend.user.resource.UserResource;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ClientResource {
    private Long id;
    private int age;
    private String email;
    private String phone;
    private String altphone;
    private String urlToImage;
    private String address;
    private String description;
    private UserResource user;
}
