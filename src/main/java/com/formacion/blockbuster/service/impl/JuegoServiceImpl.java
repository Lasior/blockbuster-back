package com.formacion.blockbuster.service.impl;

import java.time.LocalDate;
import java.time.Period;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.formacion.blockbuster.dto.Cliente;
import com.formacion.blockbuster.dto.Stock;
import com.formacion.blockbuster.dto.Tienda;
import com.formacion.blockbuster.enums.Enums;
import com.formacion.blockbuster.exceptions.EdadInsuficienteException;
import com.formacion.blockbuster.service.ClienteService;
import com.formacion.blockbuster.service.InformationService;
import com.formacion.blockbuster.service.JuegoService;

@Service
public class JuegoServiceImpl implements JuegoService{
	
	@Autowired
	InformationService informationService;
	
	@Autowired
	ClienteService clienteService;

	@Override
	public void comprarAlquilarDevolverJuego(String nombreTienda, String nombreJuego, String action, String documentacion) {
		Tienda tienda = informationService.getStores().stream().filter(t -> t.getNombre().equals(nombreTienda)).findFirst().get();
		Cliente cliente = clienteService.getCliente(documentacion);
		
		for (Stock stock : tienda.getStock()) {
			if(stock.getEstado() == Enums.estadoJuego.TIENDA) {
				if(stock.getJuego().getTitulo().equals(nombreJuego)) {
					Period period = Period.between(cliente.getFechaNacimiento(), LocalDate.now());
					if(period.getYears() >= stock.getJuego().getPegi()) {
						stock.setEstado(setEstadoJuego(action));
						cliente.getJuegos().add(stock.getJuego());
						break;
					}
					else {
						throw new EdadInsuficienteException();
					}
				}
			}
		}
	}
	
	private Enums.estadoJuego setEstadoJuego(String action){
		switch (action) {
		case "Comprar":
			return Enums.estadoJuego.VENDIDO;
		case "Alquilar":
			return Enums.estadoJuego.ALQUILADO;
		case "Devolver":
			return Enums.estadoJuego.TIENDA;
		default:
			return null;
		}
	}

}
