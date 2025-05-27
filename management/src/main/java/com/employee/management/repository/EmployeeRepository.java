package com.employee.management.repository;

import com.employee.management.model.Employee;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long> {

    List<Employee> findByRoleId(Long roleId);

    List<Employee> findByDepartmentId(Long departmentId);

    @Query("SELECT e FROM Employee e WHERE " +
            "(:roleId IS NULL OR e.role.id = :roleId) AND " +
            "(:departmentId IS NULL OR e.department.id = :departmentId) AND " +
            "(:keyword IS NULL OR LOWER(e.name) LIKE LOWER(CONCAT('%', :keyword, '%')))")
    Page<Employee> searchEmployees(Long roleId, Long departmentId, String keyword, Pageable pageable);
}
