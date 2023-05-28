package com.x.final_project_iskhazov_temirlan.controllers;

import com.x.final_project_iskhazov_temirlan.classes.Gender;
import com.x.final_project_iskhazov_temirlan.classes.Users;
import com.x.final_project_iskhazov_temirlan.classes.UsersFRE;
import com.x.final_project_iskhazov_temirlan.services.GamingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/api/")
public class HomeController {
    @Autowired
    private GamingService gamingService;

    @GetMapping("users")
    public List<Users> getUsers(){
        return gamingService.getUsers();
    }
    @GetMapping("getUser/{id}")
    public Users getUserById(@PathVariable Long id){
        return gamingService.getUser(id);
    }

    @DeleteMapping("delete-user/{id}")
    public void deleteAnimal(@PathVariable Long id){
        gamingService.deleteUser(id);
    }

    @PostMapping("add-user")
    public Users addUser(@RequestBody UsersFRE usersFRE){
        Users user = new Users();
        Gender gender = gamingService.getGender(usersFRE.getGender_id());
        user.setGender(gender);
        user.setMail(usersFRE.getMail());
        user.setPassword(usersFRE.getPassword());
        user.setName(usersFRE.getName());
        user.setSurname(usersFRE.getSurname());
        user.setAge(usersFRE.getAge());
        user.setAbout(usersFRE.getAbout());
        return gamingService.createUser(user);
    }

    @PutMapping("update-user/{id}")
    public Users updateUser(@PathVariable Long id, @RequestBody UsersFRE usersFRE) {
        System.out.println("----------------------------------------------------------------------------------------------------");
        System.out.println(usersFRE);
        Users user = gamingService.getUser(id);
        if(usersFRE.getMail() != null){
            user.setMail(usersFRE.getMail());
        }
        if(usersFRE.getPassword()!=user.getPassword() && usersFRE.getPassword()!=null){
            user.setPassword(usersFRE.getPassword());
        }
        if(usersFRE.getName()!=null){
            user.setName(usersFRE.getName());
        }
        if(usersFRE.getSurname()!=null){
            user.setSurname(usersFRE.getSurname());
        }
        if(usersFRE.getAge()!=0){
            user.setAge(usersFRE.getAge());
        }
        if(usersFRE.getAbout()!=null){
            user.setAbout(usersFRE.getAbout());
        }
        if(usersFRE.getGender_id()!=null){
            Gender gender = gamingService.getGender(usersFRE.getGender_id());
            user.setGender(gender);
        }

        return gamingService.saveUser(user);
    }

}
