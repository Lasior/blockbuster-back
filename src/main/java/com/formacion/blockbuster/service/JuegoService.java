package com.formacion.blockbuster.service;

import java.util.List;

import com.formacion.blockbuster.dto.JuegoDTO;

public interface JuegoService {

    public List<JuegoDTO> getJuegos();

    public JuegoDTO createJuego(JuegoDTO juego);

    public JuegoDTO getJuego(Long id);

    public JuegoDTO updateJuego(Long id, JuegoDTO juego);

    public void deleteJuego(Long id);

}
