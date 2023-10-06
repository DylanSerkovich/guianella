package com.capstone.guianella.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/inversiones")
public class Investment {

    @GetMapping
    public String viewInvestmentTemplate() {
        return "inversiones";
    }
}
