package com.x.final_project_iskhazov_temirlan.classes;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UsersFRE {
    private Long id;

    private String mail;

    private String password;

    private String name;

    private String surname;

    private int age;

    private String about;

    private Long gender_id;


    public UsersFRE(String mail, String password, String name, String surname, int age, String about, Long gender_id) {
        this.mail = mail;
        this.password = password;
        this.name = name;
        this.surname = surname;
        this.age = age;
        this.about = about;
        this.gender_id = gender_id;
    }
}
