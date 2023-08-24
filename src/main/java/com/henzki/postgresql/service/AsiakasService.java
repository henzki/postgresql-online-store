package com.henzki.postgresql.service;

import com.henzki.postgresql.dto.AsiakasDTO;
import com.henzki.postgresql.mapper.AsiakasMapper;
import com.henzki.postgresql.model.Asiakas;
import com.henzki.postgresql.repo.AsiakasRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class AsiakasService {

    private final AsiakasRepository asRepository;

    @Autowired
    public AsiakasService(AsiakasRepository asiakasRepository) {
        this.asRepository = asiakasRepository;
    }

    public List<AsiakasDTO> haeKaikkiAsiakkaat() {
        List<Asiakas> asiakkaat = asRepository.findAll();
        return asiakkaat.stream()
            .map(AsiakasMapper::mapToDTO)
            .collect(Collectors.toList());
    }

    public AsiakasDTO haeAsiakas(Long id) {
        Optional<Asiakas> optionalAsiakas = asRepository.findById(id);
        return optionalAsiakas.map(AsiakasMapper::mapToDTO).orElse(null);
    }

    public AsiakasDTO lisaaAsiakas(AsiakasDTO asiakasDTO) {
        Asiakas asiakas = AsiakasMapper.mapToEntity(asiakasDTO);
        asiakas.setSalasana(generatePassword());
        asiakas = asRepository.save(asiakas);
        return AsiakasMapper.mapToDTO(asiakas);
    }

    public AsiakasDTO paivitaAsiakas(Long id, AsiakasDTO asiakasDTO) {
        Optional<Asiakas> optionalAsiakas = asRepository.findById(id);
        if (optionalAsiakas.isPresent()) {
            Asiakas asiakas = optionalAsiakas.get();
            asiakas.setEtunimi(asiakasDTO.getEtunimi());
            asiakas.setSukunimi(asiakasDTO.getSukunimi());
            asiakas.setSahkoposti(asiakasDTO.getSahkoposti());
            asiakas.setOsoite(asiakasDTO.getOsoite());
            asiakas.setPostinumero(asiakasDTO.getPostinumero());
            asiakas.setKaupunki(asiakasDTO.getKaupunki());
            asiakas.setMaa(asiakasDTO.getMaa());
            asiakas = asRepository.save(asiakas);

            return AsiakasMapper.mapToDTO(asiakas);
        } else {
            return null;
        }
    }


    public boolean poistaAsiakas(Long id) {
        Optional<Asiakas> optionalAsiakas = asRepository.findById(id);
        if (optionalAsiakas.isPresent()) {
            asRepository.delete(optionalAsiakas.get());
            return true;
        } else {
            return false;
        }
    }

    public String generatePassword() {
        // Generoi satunnainen salasana UUID:n avulla
        return UUID.randomUUID().toString();
    }
}