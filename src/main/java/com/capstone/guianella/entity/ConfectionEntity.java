/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.capstone.guianella.entity;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import java.math.BigDecimal;
import java.math.RoundingMode;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

/**
 *
 * @author INTEL
 */
@Entity
@Table(name = "confection")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Builder
public class ConfectionEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_confection")
    private int idConfection;

    private BigDecimal servicePole;

    private BigDecimal serviceCuttape;

    private BigDecimal serviceButton;

    private BigDecimal costPerbutton;

    public void setIdConfection(int idConfection) {
        this.idConfection = idConfection;
    }

    public void setServicePole(BigDecimal servicePole) {
        this.servicePole = servicePole.setScale(2, RoundingMode.HALF_UP);
    }

    public void setServiceCuttape(BigDecimal serviceCuttape) {
        this.serviceCuttape = serviceCuttape.setScale(2, RoundingMode.HALF_UP);
    }

    public void setServiceButton(BigDecimal serviceButton) {
        this.serviceButton = serviceButton.setScale(2, RoundingMode.HALF_UP);
    }

    public void setCostPerbutton(BigDecimal costPerbutton) {
        this.costPerbutton = costPerbutton.setScale(2, RoundingMode.HALF_UP);
    }
    
    @OneToOne(mappedBy = "confection", cascade = CascadeType.ALL, orphanRemoval = false, fetch = FetchType.LAZY)
    private InversionEntity inversion;

    public void setInversion(InversionEntity inversion) {
        this.inversion = inversion;
    }

    
}
