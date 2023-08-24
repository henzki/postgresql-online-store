package com.henzki.postgresql.mapper;

import com.henzki.postgresql.model.Asiakas;
import com.henzki.postgresql.dto.AsiakasDTO;

public class AsiakasMapper {

    public static AsiakasDTO mapToDTO(Asiakas asiakas) {
        AsiakasDTO asiakasDTO = new AsiakasDTO();
        asiakasDTO.setId(asiakas.getId());
        asiakasDTO.setEtunimi(asiakas.getEtunimi());
        asiakasDTO.setSukunimi(asiakas.getSukunimi());
        asiakasDTO.setSahkoposti(asiakas.getSahkoposti());
        asiakasDTO.setOsoite(asiakas.getOsoite());
        asiakasDTO.setPostinumero(asiakas.getPostinumero());
        asiakasDTO.setKaupunki(asiakas.getKaupunki());
        asiakasDTO.setMaa(asiakas.getMaa());
        return asiakasDTO;
    }

    public static Asiakas mapToEntity(AsiakasDTO asiakasDTO) {
        Asiakas asiakas = new Asiakas();
        asiakas.setId(asiakasDTO.getId());
        asiakas.setEtunimi(asiakasDTO.getEtunimi());
        asiakas.setSukunimi(asiakasDTO.getSukunimi());
        asiakas.setSahkoposti(asiakasDTO.getSahkoposti());
        asiakas.setOsoite(asiakasDTO.getOsoite());
        asiakas.setPostinumero(asiakasDTO.getPostinumero());
        asiakas.setKaupunki(asiakasDTO.getKaupunki());
        asiakas.setMaa(asiakasDTO.getMaa());
        return asiakas;
    }
}