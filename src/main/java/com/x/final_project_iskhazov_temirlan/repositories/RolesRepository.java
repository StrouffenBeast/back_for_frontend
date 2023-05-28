package com.x.final_project_iskhazov_temirlan.repositories;

import com.x.final_project_iskhazov_temirlan.classes.Gender;
import com.x.final_project_iskhazov_temirlan.classes.Roles;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RolesRepository extends JpaRepository<Roles, Long> {
    Roles findByRole(String role);
}
