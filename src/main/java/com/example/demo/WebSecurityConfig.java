package com.example.demo;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

//import com.example.demo.web.UserDetailServiceImpl;


@Configuration
@EnableMethodSecurity(securedEnabled = true)
public class WebSecurityConfig {



//@Autowired
//private UserDetailServiceImpl userDetailsService;


@Bean
public SecurityFilterChain configure(HttpSecurity http)
throws Exception {
    http
    .authorizeHttpRequests( authorize -> authorize
        .requestMatchers("/index").permitAll()
         .anyRequest().authenticated()
    )
    .formLogin(formlogin -> formlogin
        .loginPage("/login")
        .defaultSuccessUrl("/booklist", true)
        .permitAll()
    )
    .logout(logout -> logout
        .permitAll()
     );
     return http.build();
    }


@Bean
public UserDetailsService userDetailsService() {
     UserDetails user = User.withDefaultPasswordEncoder()
    .username("user")
    .password("user")
     .roles("USER")
     .build();

    List<UserDetails> users = new ArrayList<UserDetails>();
    users.add(user);

    user = User.withDefaultPasswordEncoder()
    .username("admin")
    .password("admin")
     .roles("USER", "ADMIN")
     .build();

     users.add(user);


     return new InMemoryUserDetailsManager(users);
    }


/*
    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userDetailsService).passwordEncoder(new BCryptPasswordEncoder());
    }
*/
}