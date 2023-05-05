package com.henzki.postgresql.model;

import java.math.BigDecimal;

import jakarta.persistence.*;

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
    
    public Tuote() {
		super();
	}

	public Tuote(String nimi, String kuvaus, BigDecimal hinta) {
		super();
		this.nimi = nimi;
		this.kuvaus = kuvaus;
		this.hinta = hinta;
	}

	public Long getTuote_id() {
		return tuote_id;
	}

	public void setTuote_id(Long tuote_id) {
		this.tuote_id = tuote_id;
	}

	public String getNimi() {
		return nimi;
	}

	public void setNimi(String nimi) {
		this.nimi = nimi;
	}

	public String getKuvaus() {
		return kuvaus;
	}

	public void setKuvaus(String kuvaus) {
		this.kuvaus = kuvaus;
	}

	public BigDecimal getHinta() {
		return hinta;
	}

	public void setHinta(BigDecimal hinta) {
		this.hinta = hinta;
	}
  
}
