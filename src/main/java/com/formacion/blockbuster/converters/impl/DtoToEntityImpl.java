package com.formacion.blockbuster.converters.impl;

import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.formacion.blockbuster.converters.DtoToEntity;
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
public class DtoToEntityImpl implements DtoToEntity {

    @Autowired
    private BCryptPasswordEncoder encode;

    @Override
    public Cliente getCliente(ClienteDTO clienteDTO) {
        Cliente c = new Cliente();

        c.setCorreo(clienteDTO.getCorreo());
        c.setDocumentacion(clienteDTO.getDocumentacion());
        c.setFechaNacimiento(clienteDTO.getFechaNacimiento());
        c.setNombre(clienteDTO.getNombre());
        c.setUsername(clienteDTO.getUsername());
        c.setPassword(encode.encode(clienteDTO.getPassword()));

        return c;
    }

    @Override
    public Juego getJuego(JuegoDTO juegoDTO) {
        Juego j = new Juego();

        j.setCategoria(juegoDTO.getCategoria());
        j.setFechaLanzamiento(juegoDTO.getFechaLanzamiento());
        j.setPegi(juegoDTO.getPegi());
        j.setPrecio(juegoDTO.getPrecio());
        j.setTitulo(juegoDTO.getTitulo());

        if (juegoDTO.getCompanies() != null && !juegoDTO.getCompanies().isEmpty()
                && juegoDTO.getCompanies().stream().allMatch(companyDto -> companyDto.getIdCompany() != null)) {
            j.setCompanies(juegoDTO.getCompanies().stream().map(companyDto -> new Company() {
                {
                    setIdCompany(companyDto.getIdCompany());
                }
            }).collect(Collectors.toList()));
        }

        return j;
    }

    @Override
    public Stock getStock(StockDTO stockDTO) {
        Stock s = new Stock();

        s.setEstado(stockDTO.getEstado());
        s.setReferencia(stockDTO.getReferencia());

        return s;
    }

    @Override
    public Tienda getTienda(TiendaDTO tiendaDTO) {
        Tienda t = new Tienda();

        t.setDireccion(tiendaDTO.getDireccion());
        t.setNombre(tiendaDTO.getNombre());

        return t;
    }

    @Override
    public Company getCompany(CompanyDTO companyDTO) {
        Company c = new Company();

        c.setCif(companyDTO.getCif());
        c.setNombre(companyDTO.getNombre());

        return c;
    }

    @Override
    public Rol getRol(RolDTO rolDTO) {
        Rol r = new Rol();

        r.setRol(rolDTO.getRolUsuario());

        return r;
    }

}
