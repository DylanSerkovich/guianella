package com.capstone.guianella.model.dto;

import lombok.Data;

@Data
public class UserCreate {
    private String firstname;
    private String lastname;
    private String username;
    private String email;
    private String idRol;
    private Boolean enable;
}
