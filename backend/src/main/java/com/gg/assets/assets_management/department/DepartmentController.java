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
        // Process the request body here, such as saving to the database
        return departmentService.createDept(department);
    }


    @GetMapping("")
    public String deptHi() {
        return "This dept route";
    }

}
