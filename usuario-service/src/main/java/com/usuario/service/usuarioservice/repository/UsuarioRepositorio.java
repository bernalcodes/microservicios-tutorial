package com.usuario.service.usuarioservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.usuario.service.usuarioservice.entities.Usuario;

public interface UsuarioRepositorio extends JpaRepository<Usuario, Integer> {
	
}
