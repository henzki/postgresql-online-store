package com.henzki.postgresql.mapper;

import com.henzki.postgresql.dto.TilausDTO;
import com.henzki.postgresql.dto.TilausriviDTO;
import com.henzki.postgresql.model.Asiakas;
import com.henzki.postgresql.model.Tilaus;
import com.henzki.postgresql.model.Tilausrivi;
import com.henzki.postgresql.model.Tuote;

public class TilausriviMapper {

    public static TilausriviDTO mapToDTO(Tilausrivi tilausrivi) {
        TilausriviDTO tilausriviDTO = new TilausriviDTO();
        tilausriviDTO.setTilausrivi_id(tilausrivi.getTilausrivi_id());

        if (tilausrivi.getTilaus() != null) {
            tilausriviDTO.setTilaus_id(tilausrivi.getTilaus().getTilaus_id());
        }
        if (tilausrivi.getTuote() != null) {
            tilausriviDTO.setTuote_id(tilausrivi.getTuote().getTuote_id());
        }

        tilausriviDTO.setMaara(tilausrivi.getMaara());
        return tilausriviDTO;
    }

    public static Tilausrivi mapToEntity(TilausriviDTO tilausriviDTO) {
        Tilausrivi tilausrivi = new Tilausrivi();
        tilausrivi.setTilausrivi_id(tilausriviDTO.getTilausrivi_id());

        if (tilausriviDTO.getTilaus_id() != null) {
            Tilaus tilaus = new Tilaus();
            tilaus.setTilaus_id(tilausriviDTO.getTilaus_id());
            tilausrivi.setTilaus(tilaus);
        }
        if (tilausriviDTO.getTuote_id() != null) {
            Tuote tuote = new Tuote();
            tuote.setTuote_id(tilausriviDTO.getTuote_id());
            tilausrivi.setTuote(tuote);
        }

        tilausrivi.setTilaus_id(tilausriviDTO.getTilaus_id());
        tilausrivi.setTuote_id(tilausriviDTO.getTuote_id());
        tilausrivi.setMaara(tilausriviDTO.getMaara());
        return tilausrivi;
    }
}
