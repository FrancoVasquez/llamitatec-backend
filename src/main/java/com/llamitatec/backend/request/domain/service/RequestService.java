package com.llamitatec.backend.request.domain.service;

import com.llamitatec.backend.request.domain.model.entity.Request;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface RequestService {
    List<Request> getAllByClientId(Long clientId);
    Page<Request> getAllByClientId(Long clientId, Pageable pageable);
    List<Request> getAllByEmployeeId(Long employeeId);
    Page<Request> getAllByEmployeeId(Long employeeId, Pageable pageable);

    //post, put, delete
    Request create(Long clientId, Request request);
    Request update(Long requestId, Request request);
    ResponseEntity<?> delete(Long requestId);
}
