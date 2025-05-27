package com.employee.management.controller;

import com.employee.management.model.Department; // ✅ ADD THIS
import com.employee.management.repository.DepartmentRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/departments")
public class DepartmentController {

    @Autowired
    private DepartmentRepository repo;

    @PostMapping
    public Department create(@RequestBody Department d) {
        return repo.save(d);
    }

    @GetMapping
    public List<Department> getAll() {
        return repo.findAll();
    }

    @PutMapping("/{id}")
    public ResponseEntity<Department> update(@PathVariable Long id, @RequestBody Department d) {
        Department existing = repo.findById(id).orElse(null);
        if (existing != null) {
            existing.setName(d.getName());
            return ResponseEntity.ok(repo.save(existing));
        }
        return ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        repo.deleteById(id);
    }
}
