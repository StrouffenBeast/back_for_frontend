package com.x.final_project_iskhazov_temirlan.services;

import com.x.final_project_iskhazov_temirlan.classes.Gender;
import com.x.final_project_iskhazov_temirlan.classes.RegularCustomer;
import com.x.final_project_iskhazov_temirlan.classes.Roles;
import com.x.final_project_iskhazov_temirlan.classes.Users;
import com.x.final_project_iskhazov_temirlan.repositories.GenderRepository;
import com.x.final_project_iskhazov_temirlan.repositories.RegularCustomerRepository;
import com.x.final_project_iskhazov_temirlan.repositories.RolesRepository;
import com.x.final_project_iskhazov_temirlan.repositories.UsersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class GamingService implements UserDetailsService {
    @Autowired
    private GenderRepository genderRepository;

    @Autowired
    private RegularCustomerRepository regularCustomerRepository;

    @Autowired
    private RolesRepository rolesRepository;

    @Autowired
    private UsersRepository usersRepository;

    @Autowired
    private BCryptPasswordEncoder passwordEncoder;

    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        Users myUser = usersRepository.findByMail(s);
        if(myUser != null)
        {
            User secUser = new User(myUser.getMail(), myUser.getPassword(),myUser.getRolesList());
            return secUser;
        }

        throw new UsernameNotFoundException("User Not Found");

    }

    public Users getUserByMail(String mail) {
        return usersRepository.findByMail(mail);
    }

    public void deleteUser(Long id){
        usersRepository.deleteById(id);
    }

    public Users createUser(Users user) {
        Users checkUser = usersRepository.findByMail(user.getMail());
        if(checkUser == null){
            System.out.println("There is email");
            Roles role = rolesRepository.findByRole("ROLE_USER");
            RegularCustomer regularCustomer = regularCustomerRepository.findById(2L).get();
            if(role!=null)
            {
                ArrayList<Roles> roles = new ArrayList<>();
                roles.add(role);
                user.setRolesList(roles);
                user.setPassword(passwordEncoder.encode(user.getPassword()));
                user.setRegularCustomer(regularCustomer);
                System.out.println("Created user: " + user);
                return usersRepository.save(user);
            }
        }
        System.out.println("user is not null");
        return null;
    }

    public Users getUser(Long id) {
        return usersRepository.findById(id).get();
    }

    public Gender getGender(Long id) {
        return genderRepository.findById(id).get();
    }

    public Users saveUser(Users user) {
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        return usersRepository.save(user);
    }
    public List<Users> getUsers() {
        return usersRepository.findAll();
    }
    public List<Gender> getAllGender() {
        return genderRepository.findAll();
    }

    public List<Roles> getAllRoles(){
        return rolesRepository.findAll();
    }

    public RegularCustomer getRegularCustomer(Long id){
        return regularCustomerRepository.findById(id).get();
    }


}
