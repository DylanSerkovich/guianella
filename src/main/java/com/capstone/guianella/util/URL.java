package com.capstone.guianella.util;

import jakarta.servlet.http.HttpServletRequest;

public class URL {

    static public String getSiteURL(HttpServletRequest request) {
        String siteURL = request.getRequestURL().toString();
        System.out.println("Entro HTTP URL");
        return siteURL.replace(request.getServletPath(), "");
    }

}
