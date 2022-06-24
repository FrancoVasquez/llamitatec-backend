package com.llamitatec.backend.user.resource;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserResource {
    private Long id;
    private String email;
    private String typeuser;
    private String password;
}

