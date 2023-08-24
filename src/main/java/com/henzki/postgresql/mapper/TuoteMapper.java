package com.henzki.postgresql.mapper;

import com.henzki.postgresql.dto.TuoteDTO;
import com.henzki.postgresql.model.Tuote;

public class TuoteMapper {

    public static TuoteDTO mapToDTO(Tuote tuote) {
        TuoteDTO tuoteDTO = new TuoteDTO();
        tuoteDTO.setTuote_id(tuote.getTuote_id());
        tuoteDTO.setNimi(tuote.getNimi());
        tuoteDTO.setKuvaus(tuote.getKuvaus());
        tuoteDTO.setHinta(tuote.getHinta());
        return tuoteDTO;
    }

    public static Tuote mapToEntity(TuoteDTO tuoteDTO) {
        Tuote tuote = new Tuote();
        tuote.setTuote_id(tuoteDTO.getTuote_id());
        tuote.setNimi(tuoteDTO.getNimi());
        tuote.setKuvaus(tuoteDTO.getKuvaus());
        tuote.setHinta(tuoteDTO.getHinta());
        return tuote;
    }
}
