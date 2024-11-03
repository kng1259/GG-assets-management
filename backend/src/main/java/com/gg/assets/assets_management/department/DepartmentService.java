package com.gg.assets.assets_management.department;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DepartmentService {
    @Autowired
    DepartmentRepository departmentRepository;

    public Department createDept(Department newDept) {
        return departmentRepository.save(newDept);
    }
}
