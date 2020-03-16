package com.formacion.blockbuster.service;

import com.formacion.blockbuster.dto.CompanyDTO;
import com.formacion.blockbuster.dto.JuegoDTO;
import com.formacion.blockbuster.dto.TiendaDTO;

public interface GenerateDataService {

	public void addCompany(CompanyDTO companyDTO);
	
	public void addTienda(TiendaDTO tiendaDTO);
	
	public void addJuego(JuegoDTO juegoDTO);
	
}
