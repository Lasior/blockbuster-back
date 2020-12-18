package com.formacion.blockbuster.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.formacion.blockbuster.dto.JuegoDTO;
import com.formacion.blockbuster.service.JuegoService;

@RestController
@RequestMapping("juegos")
public class JuegoController {

    @Autowired
    private JuegoService juegoService;

    @GetMapping
    public List<JuegoDTO> getJuegos() {
        return juegoService.getJuegos();
    }

    @GetMapping("/{id}")
    public JuegoDTO getJuego(@PathVariable Long id) {
        return juegoService.getJuego(id);
    }

    @PostMapping
    public JuegoDTO createJuego(@Valid @RequestBody JuegoDTO juego) {
        return juegoService.createJuego(juego);
    }

    @PutMapping("/{id}")
    public JuegoDTO updateJuego(@PathVariable Long id, @Valid @RequestBody JuegoDTO juego) {
        return juegoService.updateJuego(id, juego);
    }

    @DeleteMapping("/{id}")
    public void deleteJuego(@PathVariable Long id) {
        juegoService.deleteJuego(id);
    }

}
