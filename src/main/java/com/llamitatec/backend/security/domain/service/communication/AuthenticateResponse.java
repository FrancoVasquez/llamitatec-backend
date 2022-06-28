package com.llamitatec.backend.security.domain.service.communication;

import com.llamitatec.backend.security.resource.AuthenticateResource;
import com.llamitatec.backend.shared.domain.service.communication.BaseResponse;

public class AuthenticateResponse extends BaseResponse<AuthenticateResource> {
    public AuthenticateResponse(String message) {
        super(message);
    }

    public AuthenticateResponse(AuthenticateResource resource) {
        super(resource);
    }
}
