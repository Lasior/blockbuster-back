package com.formacion.blockbuster.converters;

import com.formacion.blockbuster.dto.ClienteDTO;
import com.formacion.blockbuster.dto.CompanyDTO;
import com.formacion.blockbuster.dto.JuegoDTO;
import com.formacion.blockbuster.dto.StockDTO;
import com.formacion.blockbuster.dto.TiendaDTO;
import com.formacion.blockbuster.entity.Cliente;
import com.formacion.blockbuster.entity.Company;
import com.formacion.blockbuster.entity.Juego;
import com.formacion.blockbuster.entity.Stock;
import com.formacion.blockbuster.entity.Tienda;

public interface EntityToDto {
	
	public ClienteDTO getClienteDTO(Cliente cliente);
	public JuegoDTO getJuegoDTO(Juego juego);
	public TiendaDTO getTiendaDTO(Tienda tienda);
	public CompanyDTO getCompanyDTO(Company company);
	public StockDTO getStockDTO(Stock stock);

}
