package com.fullstack.promotion.service;

import com.fullstack.promotion.model.Cliente;
import com.fullstack.promotion.repository.PromocionRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author arturo
 */
@Service
@RequiredArgsConstructor
public class PromotionService {
    private final PromocionRepository repository;
    private final ClienteService clienteService;
    private final EmailServiceImpl emailService;

    @Value("${promotion.discount}")
    private String discountPromotion;


    public void sendMail(){
        System.out.println(discountPromotion);
        List<Cliente> clientes = clienteService.getClientesConCumpleañosHoy();
        String message = repository.getUniqueMessage();
        System.out.println(message);
        for (Cliente cliente : clientes) {
            System.out.println(cliente);
            message = message.replace("<name>", cliente.getNombre());
            message = message.replace("<discountValue>", discountPromotion);

            System.out.println(message);
            emailService.sendSimpleMessage(cliente.getEmail(), "Discount " + discountPromotion + "%", message);
        }
    }

    public String getMessage(){
        return repository.getUniqueMessage();
    }
}
