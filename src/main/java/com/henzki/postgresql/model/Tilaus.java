package com.henzki.postgresql.model;

import java.time.LocalDate;
import jakarta.persistence.*;


@Entity
@Table(name = "Tilaus")
public class Tilaus {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long tilaus_id;

    @ManyToOne
    @JoinColumn(name = "asiakas_id", nullable = false)
    private Asiakas asiakas;
    
    @Column(nullable = false, insertable = false, updatable = false)
    private Long asiakas_id;

    @Column(name = "tilauspaiva", nullable = false)
    private LocalDate tilauspaiva;

    @Column(name = "toimituspaiva")
    private LocalDate toimituspaiva;

    @Column(name = "tila", nullable = false)
    private String tila;
    
    public Tilaus() {
		super();
	}

	public Tilaus(Asiakas asiakas, LocalDate tilauspaiva, LocalDate toimituspaiva, String tila) {
		super();
		this.asiakas = asiakas;
		this.tilauspaiva = tilauspaiva;
		this.toimituspaiva = toimituspaiva;
		this.tila = tila;
	}

	public Long getTilaus_id() {
		return tilaus_id;
	}

	public void setTilaus_id(Long tilaus_id) {
		this.tilaus_id = tilaus_id;
	}

	public Asiakas getAsiakas() {
		return asiakas;
	}

	public void setAsiakas(Asiakas asiakas) {
		this.asiakas = asiakas;
	}

	public LocalDate getTilauspaiva() {
		return tilauspaiva;
	}

	public void setTilauspaiva(LocalDate tilauspaiva) {
		this.tilauspaiva = tilauspaiva;
	}

	public LocalDate getToimituspaiva() {
		return toimituspaiva;
	}

	public void setToimituspaiva(LocalDate toimituspaiva) {
		this.toimituspaiva = toimituspaiva;
	}

	public String getTila() {
		return tila;
	}

	public void setTila(String tila) {
		this.tila = tila;
	}
	
	public Long getAsiakas_id() {
        if (asiakas != null) {
            return asiakas.getId();
        }
        return null;
    }
	
	public void setAsiakas_id(Long asiakas_id) {
        this.asiakas_id = asiakas_id;
    }
    
}
