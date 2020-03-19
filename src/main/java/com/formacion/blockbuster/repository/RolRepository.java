package com.formacion.blockbuster.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.formacion.blockbuster.entity.Rol;
import com.formacion.blockbuster.enums.Enums;

public interface RolRepository extends JpaRepository<Rol, Long>{
	
	public Optional<List<Rol>> findByRol(Enums.rolUsuario rol);

}
