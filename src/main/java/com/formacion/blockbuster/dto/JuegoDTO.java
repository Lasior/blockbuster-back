package com.formacion.blockbuster.dto;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.formacion.blockbuster.enums.Enums;

import lombok.Data;

@Data
public class JuegoDTO {

    private Long idJuego;

    @NotBlank(message = "Debe rellenar el título del Juego")
    private String titulo;

    @NotNull
    @JsonFormat(pattern = "yyyy-MM-dd", locale = "ES")
    private Date fechaLanzamiento;

    @NotNull
    private Integer precio, pegi;

    private Enums.categoriaJuego categoria;

    private List<CompanyDTO> companies = new ArrayList<>();

}
