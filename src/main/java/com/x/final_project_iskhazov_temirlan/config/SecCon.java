package com.x.final_project_iskhazov_temirlan.config;

import com.x.final_project_iskhazov_temirlan.services.GamingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true,securedEnabled = true,proxyTargetClass = true)
public class SecCon extends WebSecurityConfigurerAdapter {

    @Autowired
    private GamingService gamingService;

    @Bean
    public BCryptPasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(gamingService);
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.exceptionHandling().accessDeniedPage("/403");

        http.authorizeRequests().antMatchers("/", "/css/**","/js/**").permitAll();

        http.formLogin()
                .loginPage("/login").permitAll()
                .usernameParameter("mail_field")
                .passwordParameter("password_field")
                .loginProcessingUrl("/auth").permitAll()
                .failureUrl("/login?error")
                .defaultSuccessUrl("/profile");
        http.logout()
                .logoutUrl("/logout").permitAll()
                .logoutSuccessUrl("/login");
        http.csrf().disable();
    }
}

