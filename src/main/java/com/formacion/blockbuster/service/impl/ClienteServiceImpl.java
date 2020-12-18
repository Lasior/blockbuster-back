package com.formacion.blockbuster.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.formacion.blockbuster.converters.DtoToEntity;
import com.formacion.blockbuster.converters.EntityToDto;
import com.formacion.blockbuster.dto.ClienteDTO;
import com.formacion.blockbuster.dto.CompanyDTO;
import com.formacion.blockbuster.dto.JuegoDTO;
import com.formacion.blockbuster.dto.StockDTO;
import com.formacion.blockbuster.dto.TiendaDTO;
import com.formacion.blockbuster.entity.Cliente;
import com.formacion.blockbuster.entity.Company;
import com.formacion.blockbuster.entity.Rol;
import com.formacion.blockbuster.entity.Stock;
import com.formacion.blockbuster.enums.Enums;
import com.formacion.blockbuster.exceptions.custom.ClienteNoContentException;
import com.formacion.blockbuster.exceptions.custom.RolNoContentException;
import com.formacion.blockbuster.repository.ClienteRepository;
import com.formacion.blockbuster.repository.RolRepository;
import com.formacion.blockbuster.service.ClienteService;

@Service
public class ClienteServiceImpl implements ClienteService {

    Logger log = LoggerFactory.getLogger(this.getClass());

    @Autowired
    ClienteRepository cR;

    @Autowired
    RolRepository rR;

    @Autowired
    EntityToDto etd;

    @Autowired
    DtoToEntity dte;

    @Override
    public ClienteDTO getCliente(String documentacion) {
        Cliente cliente = cR.findByDocumentacion(documentacion).orElseThrow(() -> {
            log.error("El cliente indicado no se ha encontrado");
            return new ClienteNoContentException("Cliente no encontrado");
        }).get(0);

        ClienteDTO c = etd.getClienteDTO(cliente);

        List<StockDTO> stocks = new ArrayList<StockDTO>();

        for (Stock stock : cliente.getStocks()) {
            StockDTO s = etd.getStockDTO(stock);
            JuegoDTO j = etd.getJuegoDTO(stock.getJuego());
            TiendaDTO t = etd.getTiendaDTO(stock.getTienda());

            for (Company comp : stock.getJuego().getCompanies()) {
                CompanyDTO com = etd.getCompanyDTO(comp);
                j.getCompanies().add(com);
            }

            s.setJuegoDTO(j);
            s.setTiendaDTO(t);

            stocks.add(s);
        }

        c.setStockDTOs(stocks);

        return c;
    }

    @Override
    public void postCliente(ClienteDTO clienteDTO, Enums.rolUsuario rolUsuario) {

        Cliente c = dte.getCliente(clienteDTO);
        Rol r = rR.findByRol(rolUsuario).orElseThrow(() -> {
            log.error("El rol que se ha indicado no se encuentra en la base de datos");
            return new RolNoContentException("El rol indicado no se encuentra en la base de datos");
        }).get(0);

        c.getRoles().add(r);
        cR.save(c);
    }

    @Override
    public void deleteCliente(String documentacion) {
        cR.delete(cR.findByDocumentacion(documentacion).orElseThrow(() -> {
            log.error("El cliente indicado no se ha encontrado");
            return new ClienteNoContentException("Cliente no encontrado");
        }).get(0));
    }

    @Override
    public void putCliente(ClienteDTO clienteDTO, String documentacion) {
        Cliente cliente = cR.findByDocumentacion(documentacion).orElseThrow(() -> {
            log.error("El cliente indicado no se ha encontrado");
            return new ClienteNoContentException("Cliente no encontrado");
        }).get(0);
        cliente = dte.getCliente(clienteDTO);
        cR.save(cliente);
    }

}
