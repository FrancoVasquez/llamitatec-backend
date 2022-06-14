package com.llamitatec.backend.employee.mapping;

import com.llamitatec.backend.employee.domain.model.entity.Employee;
import com.llamitatec.backend.employee.resource.CreateEmployeeResource;
import com.llamitatec.backend.employee.resource.EmployeeResource;
import com.llamitatec.backend.employee.resource.UpdateEmployeeResource;
import com.llamitatec.backend.shared.mapping.EnhancedModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;

import java.io.Serializable;
import java.util.List;

public class EmployeeMapper implements Serializable {
    @Autowired
    EnhancedModelMapper mapper;

    //Object Mapping
    public EmployeeResource toResource(Employee model){
        return mapper.map(model,EmployeeResource.class);
    }

    public Page<EmployeeResource> modelListPage(List<Employee> modelList, Pageable pageable){
        return new PageImpl<>(mapper.mapList(modelList,EmployeeResource.class),pageable,modelList.size());
    }

    public Employee toModel(CreateEmployeeResource resource){
        return mapper.map(resource,Employee.class);
    }

    public Employee toModel(UpdateEmployeeResource resource){
        return mapper.map(resource,Employee.class);
    }
}
