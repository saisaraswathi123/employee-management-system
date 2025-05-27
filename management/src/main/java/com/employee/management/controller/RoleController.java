package com.employee.management.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import com.employee.management.model.Role;
import com.employee.management.repository.RoleRepository;

@RestController
@RequestMapping("/api/roles")
public class RoleController {

    @Autowired
    private RoleRepository repo;

    @PostMapping
    public Role create(@RequestBody Role r) {
        return repo.save(r);
    }

    @GetMapping
    public List<Role> getAll() {
        return repo.findAll();
    }

    @PutMapping("/{id}")
    public ResponseEntity<Role> update(@PathVariable Long id, @RequestBody Role r) {
        Role existing = repo.findById(id).orElse(null);
        if (existing != null) {
            existing.setName(r.getName());
            return ResponseEntity.ok(repo.save(existing));
        }
        return ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        repo.deleteById(id);
    }
}
