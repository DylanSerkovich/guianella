package com.capstone.guianella.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.capstone.guianella.model.dto.NewProduction;
import com.capstone.guianella.repository.database.InversionMySQLRepository;
import com.capstone.guianella.service.ProductionService;

@Controller
@RequestMapping("/produccion")
public class ProductionController {

    @Autowired
    private InversionMySQLRepository inversionMySQLRepository;

    @Autowired
    private ProductionService productionService;

    @GetMapping
    public String viewProductionTemplate(Model model) {

        model.addAttribute("inversiones", inversionMySQLRepository.findAllNoTerminate());
        return "produccion";
    }

    @PostMapping(value = "/{IdInversion}/inversion", consumes = "application/json")
    public ResponseEntity<Void> addProductionInvestment(@PathVariable("IdInversion") int id,@RequestBody NewProduction production) { 
        System.out.println(production);
        productionService.saveProductionConfección(id,production);
        return ResponseEntity.ok().build();
    }

}
