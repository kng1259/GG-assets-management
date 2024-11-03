package com.gg.assets.assets_management.department;

import com.gg.assets.assets_management.exception.DepartmentNotFound;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DepartmentService {
    @Autowired
    DepartmentRepository departmentRepository;

    public Department createDept(Department newDept) {
        return departmentRepository.save(newDept);
    }

    public List<Department> getAllDept() {
        return departmentRepository.findAll();
    }

    public Optional<Department> getByID(Long id) {
        Optional<Department> optionalDepartment = departmentRepository.findById(id);
        Department dept = optionalDepartment.orElseThrow(()->new DepartmentNotFound("department not found"));
        return optionalDepartment;
    }

}
