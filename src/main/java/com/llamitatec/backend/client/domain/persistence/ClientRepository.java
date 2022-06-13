package com.llamitatec.backend.client.domain.persistence;

import com.llamitatec.backend.client.domain.model.entity.Client;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ClientRepository extends JpaRepository<Client, Long> {
    List<Client> findByUserId(Long userId);
    Page<Client> findByUserId(Long userId, Pageable pageable);
}
