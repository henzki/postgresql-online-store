package com.henzki.postgresql.model;

import lombok.Data;

import java.math.BigDecimal;

import jakarta.persistence.*;

@Data
@Entity
@Table(name = "Tuote")
public class Tuote {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long tuote_id;

    @Column(name = "nimi", nullable = false)
    private String nimi;

    @Column(name = "kuvaus", nullable = false)
    private String kuvaus;

    @Column(name = "hinta", nullable = false)
    private BigDecimal hinta;
}
