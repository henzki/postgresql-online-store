package com.henzki.postgresql.dto;

public class TilausriviDTO {

    private Long tilausrivi_id;
    private Long tilaus_id;
    private Long tuote_id;
    private Integer maara;

    public TilausriviDTO() {
        super();
    }

    public TilausriviDTO(Long tilausrivi_id, Long tilaus_id, Long tuote_id, Integer maara) {
        super();
        this.tilausrivi_id = tilausrivi_id;
        this.tilaus_id = tilaus_id;
        this.tuote_id = tuote_id;
        this.maara = maara;
    }

    public Long getTilausrivi_id() {
        return tilausrivi_id;
    }

    public void setTilausrivi_id(Long tilausrivi_id) {
        this.tilausrivi_id = tilausrivi_id;
    }

    public Long getTilaus_id() {
        return tilaus_id;
    }

    public void setTilaus_id(Long tilaus_id) {
        this.tilaus_id = tilaus_id;
    }

    public Long getTuote_id() {
        return tuote_id;
    }

    public void setTuote_id(Long tuote_id) {
        this.tuote_id = tuote_id;
    }

    public Integer getMaara() {
        return maara;
    }

    public void setMaara(Integer maara) {
        this.maara = maara;
    }
    
}
