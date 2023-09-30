package com.capstone.guianella.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import com.capstone.guianella.entity.UserEntity;
import com.capstone.guianella.repository.database.UserMySQLRepository;
import com.capstone.guianella.repository.impl.CustomUserDetails;

public class CustomUserDetailsService implements UserDetailsService {

    @Autowired
    private UserMySQLRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        UserEntity user = userRepository.findByUsername(username).orElse(null);
        if (user == null) {
            throw new UsernameNotFoundException("El usuario no se encontro");
        }
        return new CustomUserDetails(user);
    }
}
