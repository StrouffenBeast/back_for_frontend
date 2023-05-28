package com.x.final_project_iskhazov_temirlan.classes;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Entity
@Table

@AllArgsConstructor
@NoArgsConstructor
@Data
public class Users {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "mail", unique = true)
    private String mail;

    @Column(name = "password")
    private String password;

    @Column(name = "name")
    private String name;

    @Column(name = "surname")
    private String surname;

    @Column(name = "age")
    private int age;

    @Column(name = "about")
    private String about;

    @ManyToOne(fetch = FetchType.EAGER)
    private Gender gender;

    @ManyToMany(fetch = FetchType.EAGER)
    private List<Roles> rolesList;

    @ManyToOne(fetch = FetchType.EAGER)
    private RegularCustomer regularCustomer;
}
