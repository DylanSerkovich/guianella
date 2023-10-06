/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.capstone.guianella.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import java.math.BigDecimal;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 *
 * @author INTEL
 */
@Entity
@Table(name = "tela")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
public class TelaEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_tela")
    private int idTela;

    private String type;

    private String color;

    private float rendimiento;

    private int lot;

    private float cost;

    @ManyToOne
    @JoinColumn(name = "id_inversion", referencedColumnName = "id_inversion")
    private InversionEntity inversion;
}
