package com.formacion.blockbuster.service.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.formacion.blockbuster.converters.DtoToEntity;
import com.formacion.blockbuster.converters.EntityToDto;
import com.formacion.blockbuster.dto.JuegoDTO;
import com.formacion.blockbuster.entity.Juego;
import com.formacion.blockbuster.repository.JuegoRepository;
import com.formacion.blockbuster.service.JuegoService;

@Service
public class JuegoServiceImpl implements JuegoService {

    @Autowired
    private EntityToDto entityToDto;

    @Autowired
    DtoToEntity dtoToEntity;

    @Autowired
    private JuegoRepository juegoRepository;

    @Override
    public List<JuegoDTO> getJuegos() {
        return juegoRepository.findAll().stream().map(juego -> entityToDto.getJuegoDTO(juego)).collect(Collectors.toList());
    }

    @Override
    public JuegoDTO createJuego(JuegoDTO juegoDto) {
        Juego juego = dtoToEntity.getJuego(juegoDto);
        return entityToDto.getJuegoDTO(juegoRepository.save(juego));
    }

    @Override
    public JuegoDTO getJuego(Long id) {
        return entityToDto.getJuegoDTO(juegoRepository.findById(id).get());
    }

    @Override
    public JuegoDTO updateJuego(Long id, JuegoDTO juegoDto) {
        Juego juego = dtoToEntity.getJuego(juegoDto);
        juego.setIdJuego(id);
        return entityToDto.getJuegoDTO(juegoRepository.save(juego));
    }

    @Override
    public void deleteJuego(Long id) {
        juegoRepository.deleteById(id);
    }

}
