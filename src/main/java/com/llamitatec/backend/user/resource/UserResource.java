package com.llamitatec.backend.user.resource;

import com.llamitatec.backend.security.resource.RoleResource;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class UserResource {
    private Long id;
    private String email;
    private List<RoleResource> roles;
}

