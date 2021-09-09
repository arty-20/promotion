package com.fullstack.promotion.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

import static javax.persistence.GenerationType.IDENTITY;

/**
 * @author arturo
 */
@Getter
@Setter
@Entity
public class Promocion {

    @Id
    @GeneratedValue(strategy = IDENTITY)
    private Long id;

    @Version
    @Column(nullable = true)
    private Long version;

    @Column(nullable = false)
    private String message;
}
