package com.henzki.postgresql.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import com.henzki.postgresql.dto.TilausriviDTO;
import com.henzki.postgresql.mapper.TilausMapper;
import com.henzki.postgresql.mapper.TilausriviMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.henzki.postgresql.model.Tilausrivi;
import com.henzki.postgresql.repo.TilausriviRepository;

@Service
public class TilausriviService {

    private final TilausriviRepository tiriRepository;

    @Autowired
    public TilausriviService(TilausriviRepository tilausriviRepository) {
        this.tiriRepository = tilausriviRepository;
    }
    
    public List<TilausriviDTO> haeKaikkiTilausrivit() {
        List<Tilausrivi> tilausrivit = tiriRepository.findAll();
        return tilausrivit.stream()
                .map(TilausriviMapper::mapToDTO)
                .collect(Collectors.toList());
    }

    public TilausriviDTO haeTilausrivi(Long id) {
        Optional<Tilausrivi> optionalTilausrivi = tiriRepository.findById(id);
        return optionalTilausrivi.map(TilausriviMapper::mapToDTO).orElse(null);
    }

    public TilausriviDTO lisaaTilausrivi(TilausriviDTO tilausDTO) {
        Tilausrivi tilausrivi = TilausriviMapper.mapToEntity(tilausDTO);
        tilausrivi = tiriRepository.save(tilausrivi);
        return TilausriviMapper.mapToDTO(tilausrivi);
    }

    public TilausriviDTO paivitaTilausrivi(Long id, TilausriviDTO tilausriviDTO) {
        Optional<Tilausrivi> optionalTilausrivi = tiriRepository.findById(id);
        if (optionalTilausrivi.isPresent()) {
            Tilausrivi tilausrivi = TilausriviMapper.mapToEntity(tilausriviDTO);
        	tilausrivi.setTilausrivi_id(id);
            tilausrivi = tiriRepository.save(tilausrivi);
            return TilausriviMapper.mapToDTO(tilausrivi);
        } else {
            return null;
        }
    }

    public boolean poistaTilausrivi(Long id) {
        Optional<Tilausrivi> optionalTilausrivi = tiriRepository.findById(id);
        if (optionalTilausrivi.isPresent()) {
        	tiriRepository.delete(optionalTilausrivi.get());
            return true;
        } else {
            return false;
        }
    }

}
