package com.capstone.guianella.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.capstone.guianella.model.dto.FindCost;
import com.capstone.guianella.model.dto.FindIngresos;
import com.capstone.guianella.model.dto.InversionCreate;
import com.capstone.guianella.repository.database.InversionMySQLRepository;
import com.capstone.guianella.repository.impl.CustomUserDetails;
import com.capstone.guianella.service.InversionService;

@Controller
@RequestMapping("/inversiones")
public class InvestmentController {

    @Autowired
    private InversionService inversionService;

    @Autowired
    private InversionMySQLRepository inversionMySQLRepository;

    @GetMapping
    public String viewInvestmentTemplate(Model model) {

        // model.addAttribute("inversiones",
        // inversionMySQLRepository.findAllTerminateProjection());
        model.addAttribute("inversiones", inversionMySQLRepository.findAllNotTerminateProjection());

        return "inversiones";
    }

    @PostMapping(value = "/inversion", consumes = "application/json")
    public ResponseEntity<Void> createInvestment(@RequestBody InversionCreate inversionCreate,
            @AuthenticationPrincipal CustomUserDetails userDetails) {

        System.out.println(userDetails.getUsername());
        System.out.println(inversionCreate.toString());

        inversionService.saveInversion(inversionCreate, userDetails.getUsername());

        return ResponseEntity.ok().build();
    }

    @GetMapping("/{id}/costos")
    public ResponseEntity<FindCost> findCostInversion(@PathVariable("id") int id) {
        return ResponseEntity.ok(inversionService.findCost(id));
    }

    @GetMapping("/{id}/ingresos")
    public ResponseEntity<FindIngresos> findIngresosInversion(@PathVariable("id") int id) {
        return ResponseEntity.ok(inversionService.findIngresos(id));
    }
}
