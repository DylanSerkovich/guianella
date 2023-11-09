package com.capstone.guianella.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.capstone.guianella.service.InversionService;

@Controller
public class HomeController {

    @Autowired
    private InversionService inversionService;

    @GetMapping("/")
    public String goHome(Model model) {

        model.addAttribute("inversiones", inversionService.getInversionTerminate());

        return "index";
    }

    @GetMapping("/login")
    public String LoginCliente() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if (authentication == null || authentication instanceof AnonymousAuthenticationToken) {
            return "login";
        }
        return "redirect:/";
    }
}
