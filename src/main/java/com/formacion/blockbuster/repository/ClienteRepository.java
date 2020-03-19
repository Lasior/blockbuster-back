package com.formacion.blockbuster.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.formacion.blockbuster.entity.Cliente;

@Repository
public interface ClienteRepository extends JpaRepository<Cliente, Long>{
	
	public Optional<List<Cliente>> findByDocumentacion(String documentacion);
	public List<Cliente> findByUsername(String username);
	
}
