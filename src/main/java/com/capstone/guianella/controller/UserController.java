package com.capstone.guianella.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.capstone.guianella.model.dto.UserCreate;
// import com.capstone.guianella.service.UserService;
import com.capstone.guianella.service.UserService;

@Controller
@RequestMapping("/usuarios")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping
    public String users(Model model) {;
        model.addAttribute("users", userService.listUsers("ADMIN"));
        System.out.println(userService.listUsers("ADMIN").toString());
        return "usuarios";
    }

    @PostMapping("/usuario")
    public String Adduser(UserCreate userCreate) {
        System.out.println(userCreate.toString());
        userService.createUser(userCreate);
        return "redirect:/usuarios";
    }

}
