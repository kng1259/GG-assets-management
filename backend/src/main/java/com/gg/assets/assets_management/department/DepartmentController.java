package com.gg.assets.assets_management.department;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@CrossOrigin("*")
@RestController
@RequestMapping("/dept")
public class DepartmentController {
    @Autowired
    DepartmentService departmentService;

    @PostMapping("/create")
    public Department createDepartment(@RequestBody Department department) {
        return departmentService.createDept(department);
    }


    @GetMapping("")
    public String deptHi() {
        return "This dept route";
    }

}
