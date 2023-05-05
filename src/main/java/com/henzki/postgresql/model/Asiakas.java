package com.henzki.postgresql.model;

import jakarta.persistence.*;

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

	public Asiakas() {
		super();
	}

	public Asiakas(String etunimi, String sukunimi, String sahkoposti, String salasana, String osoite,
			String postinumero, String kaupunki, String maa) {
		super();
		this.etunimi = etunimi;
		this.sukunimi = sukunimi;
		this.sahkoposti = sahkoposti;
		this.salasana = salasana;
		this.osoite = osoite;
		this.postinumero = postinumero;
		this.kaupunki = kaupunki;
		this.maa = maa;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getEtunimi() {
		return etunimi;
	}

	public void setEtunimi(String etunimi) {
		this.etunimi = etunimi;
	}

	public String getSukunimi() {
		return sukunimi;
	}

	public void setSukunimi(String sukunimi) {
		this.sukunimi = sukunimi;
	}

	public String getSahkoposti() {
		return sahkoposti;
	}

	public void setSahkoposti(String sahkoposti) {
		this.sahkoposti = sahkoposti;
	}

	public String getSalasana() {
		return salasana;
	}

	public void setSalasana(String salasana) {
		this.salasana = salasana;
	}

	public String getOsoite() {
		return osoite;
	}

	public void setOsoite(String osoite) {
		this.osoite = osoite;
	}

	public String getPostinumero() {
		return postinumero;
	}

	public void setPostinumero(String postinumero) {
		this.postinumero = postinumero;
	}

	public String getKaupunki() {
		return kaupunki;
	}

	public void setKaupunki(String kaupunki) {
		this.kaupunki = kaupunki;
	}

	public String getMaa() {
		return maa;
	}

	public void setMaa(String maa) {
		this.maa = maa;
	}
    
}
