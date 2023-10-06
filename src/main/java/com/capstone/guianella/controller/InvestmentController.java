package com.capstone.guianella.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.capstone.guianella.model.dto.InversionCreate;

@Controller
@RequestMapping("/inversiones")
public class InvestmentController {

    @GetMapping
    public String viewInvestmentTemplate() {
        return "inversiones";
    }

    @PostMapping(value = "/inversion", consumes = "application/json")
    public ResponseEntity<Void> createInvestment(@RequestBody InversionCreate inversionCreate) {

        
        System.out.println(inversionCreate.toString());
        return ResponseEntity.ok().build();
    }
}
