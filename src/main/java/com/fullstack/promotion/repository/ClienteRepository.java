package com.fullstack.promotion.repository;

import com.fullstack.promotion.model.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

/**
 * @author arturo
 */
public interface ClienteRepository extends JpaRepository<Cliente, Long> {

    @Query("select c from Cliente c where c.diaNacimiento = ?1 and c.mesNacimiento = ?2")
    List<Cliente> getClienteByBirthday(int day, int month);
}
