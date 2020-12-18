package com.formacion.blockbuster.dto;

import java.util.ArrayList;
import java.util.List;

import javax.validation.constraints.NotBlank;

import lombok.Data;

@Data
public class CompanyDTO {

    private Long idCompany;

    @NotBlank
    private String cif, nombre;

    private List<JuegoDTO> juegos = new ArrayList<JuegoDTO>();

}
