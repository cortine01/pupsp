package com.example.pupsp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.pupsp.entities.Bills;
import com.example.pupsp.repository.BillsRepository;
import com.example.pupsp.repository.HistoryRepository;
import com.example.pupsp.repository.HousesRepository;

@Service
public class HousesService {

    @Autowired
    private HistoryRepository historyRepository;

    @Autowired
    private BillsRepository billRepository;

    @Autowired
    private HousesRepository houseRepository;

    @Transactional
    public void deleteHouseAndDependencies(int houseId) {
        // Paso 1: Obtener todos los recibos relacionados con la casa
        List<Bills> bills = billRepository.findByHouseId(houseId);

        // Paso 2: Eliminar los historiales relacionados con los recibos
        for (Bills bill : bills) {
            historyRepository.deleteByBillsId(bill.getId());
        }

        // Paso 3: Eliminar los recibos relacionados con la casa
        billRepository.deleteByHouseId(houseId);

        // Paso 4: Eliminar la casa
        houseRepository.deleteById(houseId);
    }
}
