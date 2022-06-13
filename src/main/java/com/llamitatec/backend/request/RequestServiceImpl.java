package com.llamitatec.backend.request;

import com.llamitatec.backend.client.domain.persistence.ClientRepository;
import com.llamitatec.backend.employee.domain.persistence.EmployeeRepository;
import com.llamitatec.backend.request.domain.model.entity.Request;
import com.llamitatec.backend.request.domain.persistence.RequestRepository;
import com.llamitatec.backend.request.domain.service.RequestService;
import com.llamitatec.backend.shared.exception.ResourceNotFoundException;
import com.llamitatec.backend.shared.exception.ResourceValidationException;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import javax.validation.ConstraintViolation;
import javax.validation.Validator;
import java.awt.print.Pageable;
import java.util.List;
import java.util.Set;

@Service
public class RequestServiceImpl implements RequestService {
    private static final String ENTITY = "Service";
    private final EmployeeRepository employeeRepository;
    private final ClientRepository clientRepository;
    private final RequestRepository requestRepository;
    private final Validator validator;

    public RequestServiceImpl(EmployeeRepository employeeRepository, ClientRepository clientRepository, RequestRepository requestRepository, Validator validator) {
        this.employeeRepository = employeeRepository;
        this.clientRepository = clientRepository;
        this.requestRepository = requestRepository;
        this.validator = validator;
    }

    @Override
    public List<Request> getAllByClientId(Long clientId) {
        var existingClient = requestRepository.findById(clientId);

        if(existingClient.isEmpty())
            throw new ResourceNotFoundException("Client", clientId);

        return requestRepository.findByClientId(clientId);
    }

    @Override
    public Page<Request> getAllByClientId(Long clientId, Pageable pageable) {
        return requestRepository.findByClientId(clientId, pageable);
    }

    @Override
    public List<Request> getAllByEmployeeId(Long employeeId) {
        var existingEmployee = requestRepository.findById(employeeId);

        if(existingEmployee.isEmpty())
            throw new ResourceNotFoundException("Employee", employeeId);

        return requestRepository.findByEmployeeId(employeeId);
    }

    @Override
    public Page<Request> getAllByEmployeeId(Long employeeId, Pageable pageable) {
        return requestRepository.findByEmployeeId(employeeId, pageable);
    }

    @Override
    public Request create(Long employeeId, Long clientId, Request request) {
        Set<ConstraintViolation<Request>> violations = validator.validate(request);

        if(!violations.isEmpty())
            throw new ResourceValidationException(ENTITY, violations);

        return clientRepository.findById(clientId).map(data -> {
            request.setClient(data);
            return requestRepository.save(request);
        }).orElseThrow(() -> new ResourceNotFoundException("Client", clientId));
    }

    @Override
    public Request update(Long requestId, Request request) {
        Set<ConstraintViolation<Request>> violations = validator.validate(request);

        if(!violations.isEmpty())
            throw new ResourceValidationException(ENTITY, violations);

        return requestRepository.findById(requestId).map(data ->
                requestRepository.save(
                        data.withTitle(request.getTitle())
                                .withDescription(request.getDescription())
                                .withUrlToImage(request.getUrlToImage())
                                .withPaid(request.getPaid()))
        ).orElseThrow(() -> new ResourceNotFoundException(ENTITY, requestId));
    }

    @Override
    public ResponseEntity<?> delete(Long requestId) {
        return requestRepository.findById(requestId).map(announcement -> {
            requestRepository.delete(announcement);
            return ResponseEntity.ok().build();
        }).orElseThrow(() -> new ResourceNotFoundException(ENTITY, requestId));
    }
}
