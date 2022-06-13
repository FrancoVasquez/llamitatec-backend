package com.llamitatec.backend.client.service;

import com.llamitatec.backend.client.domain.model.entity.Client;
import com.llamitatec.backend.client.domain.persistence.ClientRepository;
import com.llamitatec.backend.client.domain.service.ClientService;
import com.llamitatec.backend.shared.exception.ResourceNotFoundException;
import com.llamitatec.backend.shared.exception.ResourceValidationException;
import com.llamitatec.backend.user.domain.model.entity.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import javax.validation.ConstraintViolation;
import javax.validation.Validator;
import java.util.List;
import java.util.Set;

@Service
public class ClientServiceImpl implements ClientService {
    private static final String ENTITY = "Client";
    private final ClientRepository clientRepository;
    private final Validator validator;

    public ClientServiceImpl(ClientRepository clientRepository, Validator validator) {
        this.clientRepository = clientRepository;
        this.validator = validator;
    }

    @Override
    public List<Client> getAll() {
        return clientRepository.findAll();
    }

    @Override
    public Page<Client> getAll(Pageable pageable) {
        return clientRepository.findAll(pageable);
    }

    @Override
    public Client getById(Long clientId) {
        return clientRepository.findByUserId(clientId);
    }

    @Override
    public Client create(Client client) {
        Set<ConstraintViolation<Client>> violations=validator.validate(client);

        if(!violations.isEmpty())
            throw new ResourceValidationException(ENTITY,violations);

        return clientRepository.save(client);
    }

    @Override
    public Client update(Long clientId, Client client) {
        Set<ConstraintViolation<Client>> violations=validator.validate(client);
        if(!violations.isEmpty())
            throw new ResourceValidationException(ENTITY,violations);

        if(!clientRepository.existsById(clientId))
            throw new ResourceNotFoundException("User", clientId);

        return clientRepository.findById(clientId).map(data ->
                        clientRepository.save(data.withAddress(client.getAddress())
                                .withAge(client.getAge())
                                .withAltphone(client.getAltphone())
                                .withDescription(client.getDescription())
                                .withEmail(client.getEmail())
                                .withPhone(client.getPhone())
                                .withUrlToImage(client.getUrlToImage())
                                ))
                .orElseThrow(()-> new ResourceNotFoundException(ENTITY, clientId));
    }

    @Override
    public ResponseEntity<?> delete(Long clientId,Long userId) {
        return clientRepository.findByIdAndUserId(clientId, userId).map(data ->{
            clientRepository.delete(data);
            return ResponseEntity.ok().build();
        }).orElseThrow(()-> new ResourceNotFoundException(ENTITY,clientId));
    }
}
