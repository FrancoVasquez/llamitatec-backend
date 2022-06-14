package com.llamitatec.backend.request.api;

import com.llamitatec.backend.request.domain.service.RequestService;
import com.llamitatec.backend.request.mapping.RequestMapper;
import com.llamitatec.backend.request.resource.CreateRequestResource;
import com.llamitatec.backend.request.resource.RequestResource;
import com.llamitatec.backend.request.resource.UpdateRequestResource;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "api/v1/requests")
public class RequestsController {
    private final RequestService requestService;
    private final RequestMapper mapper;

    public RequestsController(RequestService requestService, RequestMapper mapper) {
        this.requestService = requestService;
        this.mapper = mapper;
    }

    @GetMapping("clients/{clientId}")
    public List<RequestResource> getAllRequestsByClientId(@PathVariable Long clientId) {
        return mapper.modelListToResource(requestService.getAllByClientId(clientId));
    }
    @GetMapping("employees/{employeeId}")
    public List<RequestResource> getAllRequestByEmployeeId(@PathVariable Long employeeId) {
        return mapper.modelListToResource(requestService.getAllByEmployeeId(employeeId));
    }

    @PostMapping
    public RequestResource createRequest(Long clientId, Long employeeId, Long serviceId, @RequestBody CreateRequestResource request) {
        return mapper.toResource(requestService.create(clientId,employeeId,serviceId, mapper.toModel(request)));
    }

    @PutMapping("request/{requestId}")
    public RequestResource updateRequest(@PathVariable Long requestId, @RequestBody UpdateRequestResource request) {
        return mapper.toResource(requestService.update(requestId, mapper.toModel(request)));
    }

    @DeleteMapping("request/{requestId}")
    public ResponseEntity<?> deleteRequest(@PathVariable Long requestId) {
        return requestService.delete(requestId);
    }
}
