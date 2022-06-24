package com.llamitatec.backend.employee.domain.persistence;

import com.llamitatec.backend.employee.domain.model.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee,Long> {
    Employee findByUserId(Long userId);
    List<Employee>findAllByServiceId(Long serviceId);
    Employee findByServiceId(Long serviceId);
}
