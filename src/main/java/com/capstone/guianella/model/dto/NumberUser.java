package com.capstone.guianella.model.dto;

import com.capstone.guianella.projections.CountUserRol;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Setter
@Getter
public class NumberUser {
    private List<CountUserRol> countUserRol;
}
