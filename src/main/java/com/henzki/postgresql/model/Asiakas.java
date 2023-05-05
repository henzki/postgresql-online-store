package com.henzki.postgresql.model;

import lombok.Data;

import jakarta.persistence.*;

@Data
@Entity
@Table(name = "Asiakas")
public class Asiakas {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false, updatable = false)
    private Long id;
    
    @Column(name = "etunimi", nullable = false)
    private String etunimi;

    @Column(name = "sukunimi", nullable = false)
    private String sukunimi;
    
    @Column(name = "sahkoposti", nullable = false, unique = true)
    private String sahkoposti;
    
    @Column(name = "salasana", nullable = false)
    private String salasana;
    
    @Column(name = "osoite", nullable = false)
    private String osoite;
    
    @Column(name = "postinumero", nullable = false)
    private String postinumero;
    
    @Column(name = "kaupunki", nullable = false)
    private String kaupunki;
    
    @Column(name = "maa", nullable = false)
    private String maa;
}
