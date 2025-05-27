package com.employee.management.service;

import com.employee.management.model.Role;
import com.employee.management.repository.RoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class RoleService {

    @Autowired
    private RoleRepository repo;

    public Role create(Role role) {
        return repo.save(role);
    }

    public List<Role> getAll() {
        return repo.findAll();
    }

    public Optional<Role> findById(Long id) {
        return repo.findById(id);
    }

    public void delete(Long id) {
        repo.deleteById(id);
    }

    public Role update(Role role) {
        return repo.save(role);
    }
}
