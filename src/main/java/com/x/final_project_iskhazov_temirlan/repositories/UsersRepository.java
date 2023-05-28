package com.x.final_project_iskhazov_temirlan.repositories;

import com.x.final_project_iskhazov_temirlan.classes.Gender;
import com.x.final_project_iskhazov_temirlan.classes.Users;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsersRepository extends JpaRepository<Users, Long> {
    Users findByMail(String mail);
}
