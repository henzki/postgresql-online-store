package com.henzki.postgresql.dto;

public class AsiakasDTO {
	private Long id;
	private String etunimi;
	private String sukunimi;
	private String sahkoposti;
	private String osoite;
	private String postinumero;
	private String kaupunki;
	private String maa;

	public AsiakasDTO() {
	    super();
	}

	public AsiakasDTO(Long id, String etunimi, String sukunimi, String sahkoposti, String osoite, String postinumero, String kaupunki, String maa) {
	    super();
	    this.id = id;
	    this.etunimi = etunimi;
	    this.sukunimi = sukunimi;
	    this.sahkoposti = sahkoposti;
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
