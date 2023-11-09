package com.capstone.guianella.service;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capstone.guianella.entity.ConfectionEntity;
import com.capstone.guianella.entity.InversionEntity;
import com.capstone.guianella.entity.ProductEntity;
import com.capstone.guianella.entity.TelaEntity;
import com.capstone.guianella.entity.UserEntity;
import com.capstone.guianella.model.dto.Confeccion;
import com.capstone.guianella.model.dto.FindCost;
import com.capstone.guianella.model.dto.FindIngresos;
import com.capstone.guianella.model.dto.FindInversion;
import com.capstone.guianella.model.dto.InversionCreate;
import com.capstone.guianella.model.dto.Product;
import com.capstone.guianella.model.dto.Tela;
import com.capstone.guianella.projections.InversionTerminateProjection;
import com.capstone.guianella.repository.InversionRepository;
import com.capstone.guianella.repository.database.ProductionMySQLRepository;
import com.capstone.guianella.repository.database.UserMySQLRepository;

@Service
public class InversionService {

        @Autowired
        private InversionRepository inversionRepository;

        @Autowired
        private UserMySQLRepository userMySQLRepository;

        @Autowired
        private ProductionMySQLRepository productionMySQLRepository;

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

        public List<InversionTerminateProjection> getInversionTerminate() {
                return inversionRepository.findAllTerminateProjection();
        }

        // public List<FindInversion> listInversionTerminate() {
        // List<InversionEntity> inversionEntities =
        // inversionRepository.findAllTerminate();
        // List<FindInversion> inversions = inversionEntities.stream()
        // .map(inver -> FindInversion.builder()
        // .idInversion(inver.getIdInversion())
        // .nameInversor(inver.getNameInvestor())
        // .dateRecord(inver.getDateRecord())
        // .cost(calculeCostTotal(inver.getTelas(), inver.getConfection(),
        // inver.getProductos()))
        // .ingresos(calculeIngresos(inver.getProductos()))
        // .build())
        // .collect(Collectors.toList());
        // return inversions;
        // }

        // public List<FindInversion> listInversionNotTerminate() {
        // List<InversionEntity> inversionEntities =
        // inversionRepository.findAllNoTerminate();
        // List<FindInversion> inversions = inversionEntities.stream()
        // .map(inver -> FindInversion.builder()
        // .idInversion(inver.getIdInversion())
        // .nameInversor(inver.getNameInvestor())
        // .dateRecord(inver.getDateRecord())
        // .cost(calculeCostTotal(inver.getTelas(), inver.getConfection(),
        // inver.getProductos()))
        // .build())
        // .collect(Collectors.toList());
        // return inversions;
        // }

        private BigDecimal calculeIngresos(List<ProductEntity> produces) {
                return produces.stream()
                                .map(produce -> {
                                        BigDecimal lot = BigDecimal.valueOf(produce.getLot());
                                        BigDecimal cost = BigDecimal.valueOf(produce.getPriceUnitary());
                                        return lot.multiply(cost).setScale(2, RoundingMode.HALF_UP);
                                })
                                .reduce(BigDecimal.ZERO, BigDecimal::add);
        }

        private BigDecimal calculeCostTotal(List<TelaEntity> telaEntities, ConfectionEntity confeccion,
                        List<ProductEntity> produces) {
                BigDecimal costTotal = BigDecimal.ZERO;

                BigDecimal costTotalTela = calculeCostTela(telaEntities);
                costTotal = costTotal.add(costTotalTela);

                if (confeccion != null) {
                        costTotal = costTotal.add(calculateCostConfeccion(confeccion, produces.stream()
                                        .mapToInt(ProductEntity::getLot) // Convierte a un IntStream
                                        .sum()));
                }

                return costTotal;
        }

        private BigDecimal calculeCostTela(List<TelaEntity> telaEntities) {
                return telaEntities.stream()
                                .map(telaEntity -> {
                                        BigDecimal lot = BigDecimal.valueOf(telaEntity.getLot());
                                        BigDecimal cost = BigDecimal.valueOf(telaEntity.getCost());
                                        return lot.multiply(cost).setScale(2, RoundingMode.HALF_UP);
                                })
                                .reduce(BigDecimal.ZERO, BigDecimal::add);
        }

        private BigDecimal calculateCostConfeccion(ConfectionEntity confeccion, int numeroPolos) {
                BigDecimal costConfeccion = BigDecimal.ZERO;
                BigDecimal sumServicePolo = confeccion.getServicePole();
                costConfeccion = sumServicePolo.multiply(BigDecimal.valueOf(numeroPolos))
                                .add(confeccion.getServiceCuttape()).add(confeccion.getServiceButton())
                                .add(confeccion.getCostPerbutton());
                return costConfeccion;
        }

        public FindIngresos findIngresos(int id) {
                List<ProductEntity> productEntities = productionMySQLRepository.findAllByIdInversion(id);
                List<Product> products = productEntities.stream()
                                .map(product -> Product.builder()
                                                .modelo(product.getModel())
                                                .cantidad(product.getLot())
                                                .precioU(product.getPriceUnitary())
                                                .build())
                                .collect(Collectors.toList());
                return FindIngresos.builder().products(products).totalIngresos(calculeIngresos(productEntities))
                                .build();
        }

        public FindCost findCost(int id) {
                // List<TelaEntity> telaEntities = telaMySQLRepository.findByInversion(id);

                Optional<InversionEntity> iOptional = inversionRepository.findByInversion(id);

                FindCost findCost = new FindCost();

                if (iOptional.isPresent()) {
                        List<Tela> telas = iOptional.get().getTelas().stream().map(tela -> Tela.builder()
                                        .tipo(tela.getType())
                                        .color(tela.getColor())
                                        .rendimiento(tela.getRendimiento())
                                        .cantidad(tela.getLot())
                                        .costo(tela.getCost())
                                        .build())
                                        .collect(Collectors.toList());
                        BigDecimal CostTotalTela = calculeCostTela(iOptional.get().getTelas());

                        findCost = FindCost.builder()
                                        .telas(telas)
                                        .totalInversion(CostTotalTela)
                                        .build();

                        ConfectionEntity confectionEntity = iOptional.get().getConfection();
                        if (confectionEntity != null) {

                                int totalPolos = iOptional.get().getProductos().stream()
                                                .mapToInt(ProductEntity::getLot).sum();

                                Confeccion confeccion = Confeccion.builder()
                                                .servicePolo(confectionEntity.getServicePole().doubleValue()
                                                                * totalPolos)
                                                .serviceCortacinta(confectionEntity.getServiceCuttape().doubleValue())
                                                .serviceBoton(confectionEntity.getServiceButton().doubleValue())
                                                .costBoton(confectionEntity.getCostPerbutton().doubleValue())
                                                .build();
                                BigDecimal costTotalConfeccion = calculateCostConfeccion(confectionEntity, totalPolos);

                                findCost.setConfeccion(confeccion);
                                findCost.setTotalConfeccion(costTotalConfeccion);
                        }
                }

                return findCost;
        }

}
