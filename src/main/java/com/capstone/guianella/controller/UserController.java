package com.capstone.guianella.controller;

import java.io.UnsupportedEncodingException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;

import com.capstone.guianella.model.dto.UserCreate;
import com.capstone.guianella.model.response.ResponseUserCreate;
import com.capstone.guianella.repository.impl.UserRepositoryImpl;
// import com.capstone.guianella.service.UserService;
import com.capstone.guianella.service.UserService;

import jakarta.mail.MessagingException;
import jakarta.servlet.http.HttpServletRequest;

@Controller
@RequestMapping("/usuarios")
public class UserController {

    @Autowired
    private UserService userService;

    @Autowired
    private UserRepositoryImpl userRepositoryImpl;

    @GetMapping
    public String users(Model model) {
        model.addAttribute("users", userService.listUsers("ADMIN"));
        // System.out.println(userService.listUsers("ADMIN").toString());
        model.addAttribute("newUser", new UserCreate());
        model.addAttribute("rolesAdd", userService.listOptionsRol());
        return "usuarios";
    }

    // @PostMapping("/usuario")
    // public String Adduser(@ModelAttribute() UserCreate userCreate) {
    // System.out.println("user: ");
    // System.out.println(userCreate);

    // // System.out.println(userCreate.toString());
    // userService.createUser(userCreate);
    // return "redirect:/usuarios";
    // }
    @PostMapping(value = "/usuario", produces = { MediaType.APPLICATION_JSON_VALUE })
    @ResponseBody
    public ResponseUserCreate Adduser(@ModelAttribute UserCreate userCreate, HttpServletRequest request)
            throws UnsupportedEncodingException, MessagingException {
        System.out.println("user: ");
        System.out.println(userCreate);
        ResponseUserCreate responseUserCreate = new ResponseUserCreate();
        if (userRepositoryImpl.findByEmailOrUsername(userCreate.getEmail(), userCreate.getUsername()) == null) {
            responseUserCreate.setExists(false);
            userService.createUser(userCreate, request);
        } else {
            responseUserCreate.setExists(true);
        }
        return responseUserCreate;
    }

    // @PreAuthorize("hasRole('ADMIN')")
    @PatchMapping("/{id}/estado")
    public ResponseEntity<Void> cambiarEstado(@PathVariable("id") int id, @RequestParam boolean enabled) {
        System.out.println("id= " + id);
        System.out.println("habilitado= " + enabled);
        if (userRepositoryImpl.updateEnabledUser(enabled, id)) {
            System.out.println("El usuario se modifico");
            return ResponseEntity.ok().build();
        } else {
            System.out.println("No se encontro");
            return ResponseEntity.notFound().build();
        }
    }

}
