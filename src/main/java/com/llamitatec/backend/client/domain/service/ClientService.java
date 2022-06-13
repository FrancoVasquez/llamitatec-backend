package com.llamitatec.backend.client.domain.service;

import com.llamitatec.backend.client.domain.model.entity.Client;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;

import java.awt.print.Pageable;
import java.util.List;

public interface ClientService {
    List<Client> getAll();
    Page<Client> getAll(Pageable pageable);
    Client getById(Long clientId);
    Client create(Client director);
    Client update(Long userId, Client client);
    ResponseEntity<?> delete(Long userId);
}
