package com.henzki.postgresql.dto;

import java.time.LocalDate;

public class TilausDTO {

    private Long tilaus_id;
    private Long asiakas_id;
    private LocalDate tilauspaiva;
    private LocalDate toimituspaiva;
    private String tila;
    
    public TilausDTO() {
        super();
    }

    public TilausDTO(Long tilaus_id, Long asiakas_id, LocalDate tilauspaiva, LocalDate toimituspaiva, String tila) {
        super();
        this.tilaus_id = tilaus_id;
        this.asiakas_id = asiakas_id;
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

    public Long getAsiakas_id() {
        return asiakas_id;
    }

    public void setAsiakas_id(Long asiakas_id) {
        this.asiakas_id = asiakas_id;
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
    
}
