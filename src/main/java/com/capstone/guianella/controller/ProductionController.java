package com.capstone.guianella.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.capstone.guianella.repository.database.InversionMySQLRepository;

@Controller
@RequestMapping("/produccion")
public class ProductionController {

    @Autowired
    private InversionMySQLRepository inversionMySQLRepository;

    @GetMapping
    public String viewProductionTemplate(Model model) {

        model.addAttribute("inversiones", inversionMySQLRepository.findAllNoTerminate());
        return "produccion";
    }

}
