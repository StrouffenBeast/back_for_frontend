package com.x.final_project_iskhazov_temirlan.classes;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table

@AllArgsConstructor
@NoArgsConstructor
@Data
public class RegularCustomer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "is_regular_customer")
    private boolean is_regular_customer;
}
