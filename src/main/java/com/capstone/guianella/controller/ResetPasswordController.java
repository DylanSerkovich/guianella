package com.capstone.guianella.controller;

import java.io.UnsupportedEncodingException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.capstone.guianella.exception.UserNotFoundException;
import com.capstone.guianella.service.UserService;

import jakarta.mail.MessagingException;
import jakarta.servlet.http.HttpServletRequest;

@Controller
@RequestMapping("/password")
public class ResetPasswordController {

    @Autowired

    private UserService userService;

    @GetMapping
    public String showResetPage() {
        return "password";
    }

    @PostMapping
    public String sendTokenEmail(@RequestParam("email") String email, HttpServletRequest request,
            RedirectAttributes redirectAttributes) {
        try {
            userService.sendResetPasswordToken(email, true, request);
            redirectAttributes.addFlashAttribute("mensaje",
                    "Hemos enviado un enlace para restablecer la contraseña a su Email");
        } catch (UnsupportedEncodingException | MessagingException e) {
            redirectAttributes.addFlashAttribute("errorMessage", "Error al enviar Mensaje");
        } catch (UserNotFoundException e) {
            redirectAttributes.addFlashAttribute("errorMessage", e.getMessage());
        }
        return "redirect:password";
    }

    @GetMapping("/new_password")
    public String NewPassword(@Param(value = "token") String token, Model model) {
        try {
            userService.setResetPasswordToken(token);
            model.addAttribute("token", token);
        } catch (UserNotFoundException e) {
            model.addAttribute("title", "Error en Restablecer Contraseña");
            model.addAttribute("mensaje", e.getMessage());
            return "mensaje";
        }
        return "new_password_form";
    }

    // ElderAdmin25#23
    @PostMapping("/new_password")
    public String ProcesoNewPassword(@RequestParam("password") String password,
            @RequestParam("token") String token, Model model, RedirectAttributes redirect) {

        try {
            userService.updatePassword(token, password);
            redirect.addFlashAttribute("flag", "passwordRest");
            return "redirect:/login";
        } catch (UserNotFoundException e) {
            model.addAttribute("title", "Error en Restablecer Contraseña");
            model.addAttribute("mensaje", e.getMessage());
            return "mensaje";
        }
    }

}
