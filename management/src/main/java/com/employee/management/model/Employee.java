package com.employee.management.model;
import jakarta.persistence.*; // for JPA annotations
import lombok.*;
import com.employee.management.model.Department;
import com.employee.management.model.Role;
// for @Data, @NoArgsConstructor, etc.

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String email;
    private String phone;
    private String designation;
    private String joiningDate;

    @ManyToOne
    private Department department;

    @ManyToOne
    private Role role;

    @Column(name = "resume_path") // ✅ Correct usage
    private String resumePath;
}
