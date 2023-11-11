package com.capstone.guianella.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.capstone.guianella.projections.InversionTerminateProjection;
import com.capstone.guianella.repository.database.InversionMySQLRepository;
import com.capstone.guianella.service.InversionService;

@Controller
public class HomeController {

    @Autowired
    private InversionService inversionService;

    @Autowired
    private InversionMySQLRepository repository;

    @GetMapping("/reporte")
    public String goHome(Model model) {

        List<InversionTerminateProjection> inversiones = inversionService.getInversionTerminate();

        model.addAttribute("inversiones", inversiones);

        inversionService.calcularGananciasPorMes(repository.findAllTerminateDateProjection())
                .forEach(gm -> System.out.println("Mes: " + gm.getMes() + ", Ganancia: " + gm.getGanancia()));

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
