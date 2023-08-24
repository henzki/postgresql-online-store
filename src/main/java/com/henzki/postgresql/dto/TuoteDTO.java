package com.henzki.postgresql.dto;

import java.math.BigDecimal;

public class TuoteDTO {

    private Long tuote_id;
    private String nimi;
    private String kuvaus;
    private BigDecimal hinta;

    public TuoteDTO() {
        super();
    }

    public TuoteDTO(Long tuote_id, String nimi, String kuvaus, BigDecimal hinta) {
        super();
        this.tuote_id = tuote_id;
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

