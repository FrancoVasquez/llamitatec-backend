package com.llamitatec.backend.request.domain.service;

import com.llamitatec.backend.employee.domain.model.entity.Employee;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;

import java.awt.print.Pageable;
import java.util.List;

public interface RequestService {
    List<Employee> getAllClientId(Long clientId);
    Page<Employee> getAllClientId(Long clientId, Pageable pageable);
    List<Employee> getAllEmployeeId(Long employeeId);
    Page<Employee> getAllEmployeeId(Long employeeId, Pageable pageable);

    //post, put, delete
    Employee create(Employee employee);
    Employee update(Long employeeId, Employee request);
    ResponseEntity<?> delete(Long employeeId);
}
