package com.capstone.guianella.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/estimacion")
public class EstimationController {

    @GetMapping("/beneficios")
    public String goEstimationBenefits() {
        return "estimation_benefits";
    }

}
