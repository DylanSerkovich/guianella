package com.capstone.guianella.service;

import java.io.UnsupportedEncodingException;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.capstone.guianella.entity.RolEntity;
import com.capstone.guianella.entity.UserEntity;
import com.capstone.guianella.exception.UserNotFoundException;
import com.capstone.guianella.model.dto.Rol;
import com.capstone.guianella.model.dto.UserCreate;
import com.capstone.guianella.repository.database.RolMySQLReporsitory;
import com.capstone.guianella.repository.impl.UserRepositoryImpl;
import com.capstone.guianella.util.URL;

import jakarta.mail.MessagingException;
import jakarta.servlet.http.HttpServletRequest;

import net.bytebuddy.utility.RandomString;

@Service
public class UserService {

    @Autowired
    private UserRepositoryImpl userRepositoryImpl;

    @Autowired
    private RolMySQLReporsitory rolMySQLReporsitory;

    @Autowired
    private MailService mailService;

    public void sendResetPasswordToken(String email, boolean enable, HttpServletRequest request)
            throws UserNotFoundException, UnsupportedEncodingException, MessagingException {
        UserEntity user = userRepositoryImpl.findByEmail(email, enable);
        String token = RandomString.make(30);
        if (user != null) {

            String LinkResetPass = URL.getSiteURL(request) + "/password/new_password?token=" + token;

            String requestUrl = URL.getSiteURL(request);

            System.out.println("link: " + LinkResetPass);

            userRepositoryImpl.save(UserEntity.builder()
                    .idUser(user.getIdUser())
                    .username(user.getUsername())
                    .email(user.getEmail())
                    .password(user.getPassword())
                    .enable(user.isEnable())
                    .createDate(user.getCreateDate())
                    .resetPasswordToken(token)
                    .roles(user.getRoles())
                    .build());
            mailService.SenResetPassEmail(email, requestUrl, LinkResetPass);
        } else {
            throw new UserNotFoundException("No se pudo encontrar ningún cliente con el correo electrónico. " + email);
        }
    }

    public void setResetPasswordToken(String token) throws UserNotFoundException {
        UserEntity user = userRepositoryImpl.finByResetPasswordToken(token);
        if (user == null) {
            throw new UserNotFoundException("Token Invalido");
        }
    }

    public void updatePassword(String token, String newPassword) throws UserNotFoundException {
        UserEntity user = userRepositoryImpl.finByResetPasswordToken(token);
        if (user == null) {
            throw new UserNotFoundException("Token Invalido");
        } else {
            userRepositoryImpl.save(UserEntity.builder()
                    .idUser(user.getIdUser())
                    .username(user.getUsername())
                    .email(user.getEmail())
                    .password(PasswordEncode(newPassword))
                    .enable(user.isEnable())
                    .createDate(user.getCreateDate())
                    .resetPasswordToken(null)
                    .roles(user.getRoles())
                    .build());
        }
    }

    private String PasswordEncode(String password) {
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        String encodedPassword = passwordEncoder.encode(password);
        return encodedPassword;
    }

    public void createUser(UserCreate userCreate) {
        Optional<RolEntity> targetRolOptional = rolMySQLReporsitory.findAllNotAdmin().stream()
                .filter(rol -> rol.getRolId() == (Integer.parseInt(userCreate.getIdRol())))
                .findFirst();
        RolEntity targetRol = targetRolOptional.orElse(rolMySQLReporsitory.findByName("EMPLEADOS"));
        Set<RolEntity> roles = new HashSet<>();
        roles.add(targetRol);
        String pass = RandomString.make(10);
        String token = RandomString.make(30);
        userRepositoryImpl.save(UserEntity.builder().email(userCreate.getEmail()).username(userCreate.getUsername())
                .firstName(userCreate.getFirstname())
                .lastName(userCreate.getLastname())
                .locked(true)
                .password(PasswordEncode(pass)).enable(userCreate.getEnable()).resetPasswordToken(token).roles(roles)
                .build());
    }

    public List<UserEntity> listUsers(String rol) {
        return userRepositoryImpl.findAllNotRol(rol);
    }

    public List<Rol> listOptionsRol() {
        List<RolEntity> rolEntities = rolMySQLReporsitory.findAllNotAdmin();
        // Convierte la lista de RolEntity en una lista de Rol
        List<Rol> roles = rolEntities.stream()
                .map(rolEntity -> new Rol(rolEntity.getRolId(), rolEntity.getName())) // Supongamos que Rol tiene
                                                                                      // constructor con id y nombre
                .collect(Collectors.toList());
        return roles;
    }

    
}
