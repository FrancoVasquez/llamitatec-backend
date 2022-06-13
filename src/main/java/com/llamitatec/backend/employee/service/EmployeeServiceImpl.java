package com.llamitatec.backend.employee.service;

import com.llamitatec.backend.employee.domain.model.entity.Employee;
import com.llamitatec.backend.employee.domain.persistence.EmployeeRepository;
import com.llamitatec.backend.employee.domain.service.EmployeeService;
import com.llamitatec.backend.shared.exception.ResourceNotFoundException;
import com.llamitatec.backend.shared.exception.ResourceValidationException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import javax.validation.ConstraintViolation;
import javax.validation.Validator;
import java.util.List;
import java.util.Set;

@Service
public class EmployeeServiceImpl implements EmployeeService {
    private static final String ENTITY = "Employee";
    private final EmployeeRepository employeeRepository;
    private final Validator validator;

    public EmployeeServiceImpl(EmployeeRepository employeeRepository, Validator validator) {
        this.employeeRepository = employeeRepository;
        this.validator = validator;
    }

    @Override
    public List<Employee> getAll() {
        return employeeRepository.findAll();
    }

    @Override
    public Page<Employee> getAll(Pageable pageable) {
        return employeeRepository.findAll(pageable);
    }

    @Override
    public Employee getById(Long employeeId) {
        return employeeRepository.findByUserId(employeeId);
    }

    @Override
    public Employee create(Employee employee) {
        Set<ConstraintViolation<Employee>> violations=validator.validate(employee);

        if(!violations.isEmpty())
            throw new ResourceValidationException(ENTITY,violations);

        return employeeRepository.save(employee);
    }

    @Override
    public Employee update(Long employeeId, Employee employee) {
        Set<ConstraintViolation<Employee>> violations=validator.validate(employee);
        if(!violations.isEmpty())
            throw new ResourceValidationException(ENTITY,violations);

        if(!employeeRepository.existsById(employeeId))
            throw new ResourceNotFoundException("Employee", employeeId);

        return employeeRepository.findById(employeeId).map(data ->
                        employeeRepository.save(data.withAge(employee.getAge())
                                .withAltphone(employee.getAltphone())
                                .withDescription(employee.getDescription())
                                .withEmail(employee.getEmail())
                                .withPhone(employee.getPhone())
                                .withUrlToImage(employee.getUrlToImage())
                        ))
                .orElseThrow(()-> new ResourceNotFoundException(ENTITY, employeeId));
    }

    @Override
    public ResponseEntity<?> delete(Long employeeId) {
        return employeeRepository.findById(employeeId).map(data ->{
            employeeRepository.delete(data);
            return ResponseEntity.ok().build();
        }).orElseThrow(()-> new ResourceNotFoundException(ENTITY,employeeId));
    }
}
