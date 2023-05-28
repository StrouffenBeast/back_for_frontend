package com.x.final_project_iskhazov_temirlan.repositories;

import com.x.final_project_iskhazov_temirlan.classes.Gender;
import com.x.final_project_iskhazov_temirlan.classes.RegularCustomer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RegularCustomerRepository extends JpaRepository<RegularCustomer, Long> {
}
