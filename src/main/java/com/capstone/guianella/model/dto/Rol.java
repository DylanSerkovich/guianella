package com.capstone.guianella.model.dto;

import lombok.Data;

@Data
public class Rol {
    private int rolId;
    private String name;

    public Rol(int rolId, String name) {
        this.rolId = rolId;
        this.name = name;
    }

}
