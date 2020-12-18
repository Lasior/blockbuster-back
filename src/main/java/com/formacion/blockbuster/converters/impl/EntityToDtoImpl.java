package com.formacion.blockbuster.converters.impl;

import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.formacion.blockbuster.converters.EntityToDto;
import com.formacion.blockbuster.dto.ClienteDTO;
import com.formacion.blockbuster.dto.CompanyDTO;
import com.formacion.blockbuster.dto.JuegoDTO;
import com.formacion.blockbuster.dto.RolDTO;
import com.formacion.blockbuster.dto.StockDTO;
import com.formacion.blockbuster.dto.TiendaDTO;
import com.formacion.blockbuster.entity.Cliente;
import com.formacion.blockbuster.entity.Company;
import com.formacion.blockbuster.entity.Juego;
import com.formacion.blockbuster.entity.Rol;
import com.formacion.blockbuster.entity.Stock;
import com.formacion.blockbuster.entity.Tienda;

@Service
public class EntityToDtoImpl implements EntityToDto {

    @Override
    public ClienteDTO getClienteDTO(Cliente cliente) {
        ClienteDTO c = new ClienteDTO();

        c.setCorreo(cliente.getCorreo());
        c.setDocumentacion(cliente.getDocumentacion());
        c.setFechaNacimiento(cliente.getFechaNacimiento());
        c.setNombre(cliente.getNombre());

        return c;
    }

    @Override
    public JuegoDTO getJuegoDTO(Juego juego) {
        return getJuegoDTO(juego, true);
    }

    private JuegoDTO getJuegoDTO(Juego juego, boolean companiesIncluded) {
        JuegoDTO j = new JuegoDTO();

        j.setIdJuego(juego.getIdJuego());
        j.setCategoria(juego.getCategoria());
        j.setFechaLanzamiento(juego.getFechaLanzamiento());
        j.setPegi(juego.getPegi());
        j.setPrecio(juego.getPrecio());
        j.setTitulo(juego.getTitulo());

        if (companiesIncluded) {
            j.setCompanies(juego.getCompanies().stream().map(company -> getCompanyDTO(company, false)).collect(Collectors.toList()));
        }

        return j;
    }

    @Override
    public TiendaDTO getTiendaDTO(Tienda tienda) {
        TiendaDTO t = new TiendaDTO();

        t.setDireccion(tienda.getDireccion());
        t.setNombre(tienda.getNombre());

        return t;
    }

    @Override
    public CompanyDTO getCompanyDTO(Company company) {
        return getCompanyDTO(company, true);
    }

    private CompanyDTO getCompanyDTO(Company company, boolean juegosIncluded) {
        CompanyDTO comp = new CompanyDTO();

        comp.setIdCompany(company.getIdCompany());
        comp.setCif(company.getCif());
        comp.setNombre(company.getNombre());

        if (juegosIncluded) {
            comp.setJuegos(company.getJuegos().stream().map(juego -> getJuegoDTO(juego, false)).collect(Collectors.toList()));
        }

        return comp;
    }

    @Override
    public StockDTO getStockDTO(Stock stock) {

        StockDTO s = new StockDTO();

        s.setEstado(stock.getEstado());
        s.setReferencia(stock.getReferencia());

        return s;
    }

    @Override
    public RolDTO getRolDTO(Rol rol) {

        RolDTO r = new RolDTO();

        r.setRolUsuario(rol.getRol());

        return r;
    }

}
