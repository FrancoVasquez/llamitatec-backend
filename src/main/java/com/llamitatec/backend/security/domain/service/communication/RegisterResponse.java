package com.llamitatec.backend.security.domain.service.communication;

import com.llamitatec.backend.shared.domain.service.communication.BaseResponse;
import com.llamitatec.backend.user.resource.UserResource;

public class RegisterResponse extends BaseResponse<UserResource> {
    public RegisterResponse(String message) {
        super(message);
    }

    public RegisterResponse(UserResource resource) {
        super(resource);
    }
}