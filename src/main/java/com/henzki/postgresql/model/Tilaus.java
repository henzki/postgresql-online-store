package com.henzki.postgresql.model;
import lombok.Data;

import java.time.LocalDate;

import jakarta.persistence.*;

@Data
@Entity
@Table(name = "Tilaus")
public class Tilaus {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long tilaus_id;

    @ManyToOne
    @JoinColumn(name = "asiakas_id", nullable = false)
    private Asiakas asiakas;

    @Column(name = "tilauspaiva", nullable = false)
    private LocalDate tilauspaiva;

    @Column(name = "toimituspaiva")
    private LocalDate toimituspaiva;

    @Column(name = "tila", nullable = false)
    private String tila;
}
