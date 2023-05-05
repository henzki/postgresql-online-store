package com.henzki.postgresql.model;

import lombok.Data;

import jakarta.persistence.*;

@Data
@Entity
@Table(name = "Tilausrivi")
public class Tilausrivi {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long tilausrivi_id;

    @ManyToOne
    @JoinColumn(name = "tilaus_id", nullable = false)
    private Tilaus tilaus;

    @ManyToOne
    @JoinColumn(name = "tuote_id", nullable = false)
    private Tuote tuote;

    @Column(nullable = false)
    private Integer maara;
}

