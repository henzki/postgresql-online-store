package com.henzki.postgresql.mapper;

import com.henzki.postgresql.model.Asiakas;
import com.henzki.postgresql.model.Tilaus;
import com.henzki.postgresql.dto.TilausDTO;

public class TilausMapper {

    public static TilausDTO mapToDTO(Tilaus tilaus) {
        TilausDTO tilausDTO = new TilausDTO();
        tilausDTO.setTilaus_id(tilaus.getTilaus_id());

        if (tilaus.getAsiakas() != null) {
            tilausDTO.setAsiakas_id(tilaus.getAsiakas().getId());
        }

        tilausDTO.setTilauspaiva(tilaus.getTilauspaiva());
        tilausDTO.setToimituspaiva(tilaus.getToimituspaiva());
        tilausDTO.setTila(tilaus.getTila());
        return tilausDTO;
    }

    public static Tilaus mapToEntity(TilausDTO tilausDTO) {
        Tilaus tilaus = new Tilaus();
        tilaus.setTilaus_id(tilausDTO.getTilaus_id());

        if (tilausDTO.getAsiakas_id() != null) {
            Asiakas asiakas = new Asiakas();
            asiakas.setId(tilausDTO.getAsiakas_id());
            tilaus.setAsiakas(asiakas);
        }

        tilaus.setTilauspaiva(tilausDTO.getTilauspaiva());
        tilaus.setToimituspaiva(tilausDTO.getToimituspaiva());
        tilaus.setTila(tilausDTO.getTila());
        return tilaus;
    }
}