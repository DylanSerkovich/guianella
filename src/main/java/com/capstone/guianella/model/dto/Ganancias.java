package com.capstone.guianella.model.dto;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class Ganancias {
    private List<GananciaMes> gananciasPorMes;
}
