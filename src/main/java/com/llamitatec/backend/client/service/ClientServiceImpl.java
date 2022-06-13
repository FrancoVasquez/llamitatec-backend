package com.llamitatec.backend.client.service;

import com.llamitatec.backend.client.domain.model.entity.Client;
import com.llamitatec.backend.client.domain.service.ClientService;
import com.llamitatec.backend.client.resource.ClientResource;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;

import javax.validation.Validator;
import java.awt.print.Pageable;
import java.util.List;

public class ClientServiceImpl implements ClientService {
    private static final String ENTITY = "Client";
    private final ClientResource clientResource;
    private final Validator validator;

    public ClientServiceImpl(ClientResource clientResource, Validator validator) {
        this.clientResource = clientResource;
        this.validator = validator;
    }

    @Override
    public List<Client> getAll() {
        return null;
    }

    @Override
    public Page<Client> getAll(Pageable pageable) {
        return null;
    }

    @Override
    public Client getById(Long clientId) {
        return null;
    }

    @Override
    public Client create(Client director) {
        return null;
    }

    @Override
    public Client update(Long userId, Client client) {
        return null;
    }

    @Override
    public ResponseEntity<?> delete(Long userId) {
        return null;
    }
}
