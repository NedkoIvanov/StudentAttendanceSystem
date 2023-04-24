package com.attendance.demo.service;


import com.attendance.demo.model.entity.RoleEntity;
import com.attendance.demo.model.entity.UserEntity;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.ArrayList;
import java.util.stream.Collectors;

@Service
public class StudentAttendanceUserDetailsService implements UserDetailsService {

    private final UserService userService;

    public StudentAttendanceUserDetailsService(UserService userService) {
        this.userService = userService;
    }

    @Override
    @Transactional
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        //finding existing user by email
        UserEntity user = this.userService.findByEmail(email);

        /*
        //finding authorities of authenticated user
        List<GrantedAuthority> grantedAuthority = new ArrayList<>();
        List<SimpleGrantedAuthority> simpleGrantedAuthority = new ArrayList<>();
        List<RoleEntity> roles =  user.getRoles();
        for(RoleEntity role : roles){
            simpleGrantedAuthority.add( new SimpleGrantedAuthority("ROLE_" + role.getRoles().name()));
        }
        grantedAuthority.addAll(simpleGrantedAuthority);

         */

        List<GrantedAuthority> authorities = user
                .getRoles()
                .stream()
                .map(r -> new SimpleGrantedAuthority("ROLE_" + r.getRoles().name()))
                .collect(Collectors.toList());

        //setting User constructor with : email,password and roles in the app
        return new User(user.getEmail(),user.getPassword(),authorities);
    }
}
