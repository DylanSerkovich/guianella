package com.capstone.guianella.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.capstone.guianella.repository.database.InversionMySQLRepository;

@Controller
public class DashboardController {

    @Autowired
    private InversionMySQLRepository inversionMySQLRepository;

    @GetMapping("/")
    public String goHome(Model model) {
        model.addAttribute("count", inversionMySQLRepository.findCountInvestProduct());
        return "dashboard";
    }
}
