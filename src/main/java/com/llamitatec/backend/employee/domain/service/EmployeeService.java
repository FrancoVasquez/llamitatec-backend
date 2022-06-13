package com.llamitatec.backend.employee.domain.service;

import com.llamitatec.backend.employee.domain.model.entity.Employee;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface EmployeeService {
    List<Employee> getAll();
    Page<Employee> getAll(Pageable pageable);
    Employee getById(Long employeeId);
    Employee create(Employee employee);
    Employee update(Long employeeId, Employee employee);
    ResponseEntity<?> delete(Long employeeId, Long userId);
}
