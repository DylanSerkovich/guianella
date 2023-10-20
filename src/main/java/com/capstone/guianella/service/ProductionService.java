package com.capstone.guianella.service;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capstone.guianella.entity.ConfectionEntity;
import com.capstone.guianella.entity.InversionEntity;
import com.capstone.guianella.entity.ProductEntity;
import com.capstone.guianella.model.dto.NewProduction;
import com.capstone.guianella.repository.InversionRepository;
import com.capstone.guianella.repository.database.ConfeccionMySQLRepository;
import com.capstone.guianella.repository.database.InversionMySQLRepository;
import com.capstone.guianella.repository.database.ProductionMySQLRepository;

@Service
public class ProductionService {

    @Autowired
    private ConfeccionMySQLRepository confeccionMySQLRepository;

    @Autowired
    private InversionMySQLRepository inversionMySQLRepository;

    @Autowired
    private ProductionMySQLRepository productionMySQLRepository;

    public void saveProductionConfección(int idInversion, NewProduction production) {
        // InversionEntity inversionEntity =

        Optional<InversionEntity> iOptional = inversionMySQLRepository.findById(idInversion);
        if (iOptional.isPresent()) {
            InversionEntity inversionEntity = iOptional.orElse(null);
            System.out.println("id: " + inversionEntity.getIdInversion());

            List<ProductEntity> productions = production.getProducts().stream()
                    .map(product -> ProductEntity.builder()
                            .model(product.getModelo())
                            .lot(product.getCantidad())
                            .priceUnitary(product.getPrecioU())
                            .build())
                    .collect(Collectors.toList());

            productions.forEach(product -> product.setInversion(inversionEntity));

            productionMySQLRepository.saveAll(productions);

            ConfectionEntity confectionEntity = ConfectionEntity.builder()
                    .costPerbutton(new BigDecimal(production.getConfeccion().getCostBoton()))
                    .servicePole(new BigDecimal(production.getConfeccion().getServicePolo()))
                    .serviceButton(new BigDecimal(production.getConfeccion().getServiceBoton()))
                    .serviceCuttape(new BigDecimal(production.getConfeccion().getServiceCortacinta()))
                    .build();

            ConfectionEntity confectionEntity2= confeccionMySQLRepository.save(confectionEntity);

            inversionMySQLRepository.updateConfeccionDateTerminate(idInversion, confectionEntity2.getIdConfection(), new Date());

            // inversionEntity.setProductos(productions);
            // inversionEntity.getProductos().forEach(prod ->
            // prod.setInversion(inversionEntity));
            // inversionEntity.setConfection(confectionEntity);
            // inversionEntity.getConfection().setInversion(inversionEntity);
            // inversionEntity.setDateComplete(new Date());

            // inversionMySQLRepository.save(inversionEntity);
        }

    }
}
