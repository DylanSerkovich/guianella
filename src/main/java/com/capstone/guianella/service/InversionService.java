package com.capstone.guianella.service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capstone.guianella.entity.InversionEntity;
import com.capstone.guianella.entity.TelaEntity;
import com.capstone.guianella.entity.UserEntity;
import com.capstone.guianella.model.dto.InversionCreate;
import com.capstone.guianella.repository.InversionRepository;
import com.capstone.guianella.repository.database.UserMySQLRepository;

@Service
public class InversionService {

        @Autowired
        private InversionRepository inversionRepository;

        @Autowired
        private UserMySQLRepository userMySQLRepository;

        /*
         * En la tabla Tela no se adjunta el id de la Inversion
         * El Costo lo pone en 0
         * El nombre del inversor aun no esta puesto
         */
        public void saveInversion(InversionCreate inversion, String username) {

                List<TelaEntity> telas = inversion.getTelas().stream()
                                .map(tela -> TelaEntity.builder()
                                                .type(tela.getTipo())
                                                .color(tela.getColor())
                                                .rendimiento(tela.getRendimiento())
                                                .lot(tela.getCantidad())
                                                .cost(tela.getCosto())
                                                .inversion(null)
                                                .build())
                                .collect(Collectors.toList());

                UserEntity user = userMySQLRepository.findByUsername(username).orElse(null);

                InversionEntity inversionEntity = InversionEntity.builder()
                                .unitFabric(inversion.getUnidad())
                                .telas(telas)
                                .user(user)
                                .nameInvestor(user.getFirstName() + " " + user.getLastName())
                                .build();
                inversionEntity.getTelas().forEach(tela -> tela.setInversion(inversionEntity));

                inversionRepository.save(inversionEntity);
        }

        // List<TelaEntity> telas = new ArrayList<>();
        // List<Tela> telascreList = inversion.getTelas();
        // for(Tela tela: telascreList){
        // TelaEntity telaEntity = TelaEntity.builder()
        // .type(tela.getTipo())
        // .color(tela.getColor())
        // .rendimiento(tela.getRendimiento())
        // .lot(tela.getCantidad())
        // .lot(tela.getCosto())
        // .build();

        // }

}
