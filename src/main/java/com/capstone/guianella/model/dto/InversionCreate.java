package com.capstone.guianella.model.dto;

import java.util.List;

import lombok.Data;

@Data
public class InversionCreate {
    private String unidad;

    private List<Tela> telas;

}
