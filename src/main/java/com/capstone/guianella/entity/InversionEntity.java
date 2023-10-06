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
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import java.sql.Date;
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
@Table(name = "inversion")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
public class InversionEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_inversion")
    private int idInversion;

    private String nameInvestor;

    private Date dateRecord;

    private Date dateComplete;

    private String unitFabric;
    
    /*   Entidades | FK   */
    @ManyToOne
    @JoinColumn(name = "id_user",referencedColumnName = "id_user", nullable=true)
    private UserEntity user;
    
    @OneToOne
    @JoinColumn(name = "id_confection",referencedColumnName = "id_confection", nullable=true)
    private ConfectionEntity confection;
}
