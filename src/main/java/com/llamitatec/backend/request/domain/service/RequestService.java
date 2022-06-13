package com.llamitatec.backend.request.domain.service;

import com.llamitatec.backend.request.domain.model.entity.Request;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;

import java.awt.print.Pageable;
import java.util.List;

public interface RequestService {
    List<Request> getAllClientId(Long clientId);
    Page<Request> getAllClientId(Long clientId, Pageable pageable);
    List<Request> getAllEmployeeId(Long employeeId);
    Page<Request> getAllEmployeeId(Long employeeId, Pageable pageable);

    //post, put, delete
    Request create(Long employeeId, Long clientId, Request request);
    Request update(Long requestId, Request request);
    ResponseEntity<?> delete(Long requestId);
}
