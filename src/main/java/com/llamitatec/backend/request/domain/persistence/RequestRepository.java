package com.llamitatec.backend.request.domain.persistence;

import com.llamitatec.backend.client.domain.model.entity.Client;
import com.llamitatec.backend.employee.domain.model.entity.Employee;
import com.llamitatec.backend.request.domain.model.entity.Request;
import org.springframework.data.domain.Page;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.awt.print.Pageable;
import java.util.List;

@Repository
public interface RequestRepository extends JpaRepository<Request,Long> {
    List<Client> findByClientId(Long clientId);
    Page<Client> findByClientId(Long clientId, Pageable pageable);
    List<Employee> findByEmployeeId(Long employeeId);
    Page<Employee> findByEmployeeId(Long employeeId, Pageable pageable);
}
