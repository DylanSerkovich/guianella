package com.capstone.guianella.model.dto;

import java.util.HashSet;
import java.util.Set;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class FindUser {
    private int idUser;
    private String username;
    private String firstname;
    private String lastname;
    private boolean enable;
    private String email;
    private Set<Rol> roles = new HashSet<>();
}
