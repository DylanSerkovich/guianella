package com.capstone.guianella.service;

import java.io.UnsupportedEncodingException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import com.capstone.guianella.util.ContentMessage;

import jakarta.mail.MessagingException;
import jakarta.mail.internet.MimeMessage;

@Service
public class MailService {

    @Autowired
    private JavaMailSender mailSender;

    @Async
    public void SenResetPassEmail(String email, String request, String url)
            throws MessagingException, UnsupportedEncodingException {
        MimeMessage message = mailSender.createMimeMessage();
        MimeMessageHelper helper = new MimeMessageHelper(message);

        helper.setFrom("enviacms123@gmail.com", "Soporte de Guianella");
        helper.setTo(email);

        String subject = "Aquí esta el enlace para restablecer contraseña";

        String content = ContentMessage.resPassHTML(url, request);

        helper.setSubject(subject);

        helper.setText(content, true);
        System.out.println("Se envio");
        mailSender.send(message);
    }

}
