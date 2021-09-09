package com.fullstack.promotion.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;

import java.time.LocalDate;

import static javax.persistence.GenerationType.IDENTITY;

/**
 * @author arturo
 */
@Getter
@Setter
@ToString
@Entity
public class Cliente {

    @Id
    @GeneratedValue(strategy = IDENTITY)
    private Long id;

    @Version
    @Column(nullable = true)
    private Long version;

    @Column(nullable = false)
    private String nombre;

    @Column(nullable = false)
    private String email;

    @Column(nullable = false)
    private int diaNacimiento;

    @Column(nullable = false)
    private int mesNacimiento;

    @Column(nullable = false)
    private int anioNacimiento;

}
