package com.employee.management.controller;

import com.employee.management.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping("/api/employees")
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    // ✅ Upload resume for employee
    @PostMapping("/{id}/upload-resume")
    public ResponseEntity<String> uploadResume(
            @PathVariable Long id,
            @RequestParam("file") MultipartFile file) {
        return employeeService.uploadResume(id, file);
    }

    // ✅ Search employees with filters and pagination
    @GetMapping("/search")
    public ResponseEntity<?> searchEmployees(
            @RequestParam(required = false) Long roleId,
            @RequestParam(required = false) Long departmentId,
            @RequestParam(required = false) String keyword,
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "5") int size
    ) {
        return ResponseEntity.ok(employeeService.getFilteredEmployees(roleId, departmentId, keyword, page, size));
    }
}
