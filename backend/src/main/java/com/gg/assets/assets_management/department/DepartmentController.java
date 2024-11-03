package com.gg.assets.assets_management.department;

import com.gg.assets.assets_management.ApiResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseCookie;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@CrossOrigin("*")
@RestController
@RequestMapping("/dept")
public class DepartmentController {
    @Autowired
    DepartmentService departmentService;

    @GetMapping("")
    public ResponseEntity<ApiResponse<List<Department>>> getAllDept() {
        List<Department> result = departmentService.getAllDept();
        ApiResponse<List<Department>> reponse = new ApiResponse<List<Department>>(400, "Dept list", result);
        return ResponseEntity.status(HttpStatus.OK).body(reponse);
    }

    @PostMapping("/create")
    public ResponseEntity<ApiResponse<Department>> createDept(@RequestBody Department newDept) {
        System.out.print(newDept);
        Department result = departmentService.createDept(newDept);
        System.out.print(result) ;
        if(result == null) {
            ApiResponse<Department> reponse = new ApiResponse<Department>(400, "Cannot create", null);
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(reponse);
        } else {
            ApiResponse<Department> reponse = new ApiResponse<Department>(200,"Create dept success", result );
            return ResponseEntity.status(HttpStatus.OK).body(reponse);
        }
    }
}
