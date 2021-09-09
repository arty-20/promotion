package com.fullstack.promotion.service;

import com.fullstack.promotion.model.Cliente;
import com.fullstack.promotion.repository.ClienteRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

/**
 * @author arturo
 */
@Service
@AllArgsConstructor
public class ClienteService {
    private final ClienteRepository repository;

    public List<Cliente> getClientesConCumpleañosHoy(){
        LocalDate localDate = LocalDate.now();
        int day = localDate.getDayOfMonth();
        int month = localDate.getMonthValue();
        return repository.getClienteByBirthday(day, month);
    }
}
