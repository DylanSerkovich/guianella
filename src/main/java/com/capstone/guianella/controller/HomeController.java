package com.capstone.guianella.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

    @GetMapping("/home")
    public String goHome() {
        return "record";
    }

    @GetMapping("/home2")
    public String goHome2() {
        return "record";
    }

}
