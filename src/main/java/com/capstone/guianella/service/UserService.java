package com.capstone.guianella.service;

import java.io.UnsupportedEncodingException;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.capstone.guianella.entity.RolEntity;
import com.capstone.guianella.entity.UserEntity;
import com.capstone.guianella.model.dto.UserCreate;
import com.capstone.guianella.repository.database.RolMySQLReporsitory;
import com.capstone.guianella.repository.impl.UserRepositoryImpl;
import jakarta.servlet.http.HttpServletRequest;

import net.bytebuddy.utility.RandomString;

@Service
public class UserService {

    @Autowired
    private UserRepositoryImpl userRepositoryImpl;

    @Autowired
    private RolMySQLReporsitory rolMySQLReporsitory;

    private String PasswordEncode(String password) {
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        String encodedPassword = passwordEncoder.encode(password);
        return encodedPassword;
    }

    public void createUser(UserCreate userCreate) {
        RolEntity rol = rolMySQLReporsitory.findByName("EMPLEADOS");
        Set<RolEntity> roles = new HashSet<>();
        roles.add(rol);
        String pass = RandomString.make(10);
        userRepositoryImpl.save(UserEntity.builder().email(userCreate.getEmail()).username(userCreate.getUsername())
                .password(PasswordEncode(pass)).enable(true).resetPasswordToken(null).roles(roles).build());
    }

    public List<UserEntity> listUsers(String rol) {
        return userRepositoryImpl.findAllNotRol(rol);
    }
}
