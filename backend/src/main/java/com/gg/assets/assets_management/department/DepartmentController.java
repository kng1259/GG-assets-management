package com.gg.assets.assets_management.department;

import com.gg.assets.assets_management.ApiResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseCookie;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin("*")
@RestController
@RequestMapping("/dept")
public class DepartmentController {
    @Autowired
    DepartmentService departmentService;

    @PostMapping("/create")
    public ResponseEntity<ApiResponse<Department>> createDept(@RequestBody Department newDept) {
        Department result = departmentService.createDept(newDept);
        System.out.print(result) ;
        if(result == null) {
            ApiResponse<Department> reponse = new ApiResponse<>(400, "Cannot create", null);
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(reponse);
        } else {
            ApiResponse<Department> reponse = new ApiResponse<>(200,"Create dept success", result );
            return ResponseEntity.status(HttpStatus.OK).body(reponse);
        }
    }

    @GetMapping("")
    public String deptHi() {
        return "This dept route";
    }

}
