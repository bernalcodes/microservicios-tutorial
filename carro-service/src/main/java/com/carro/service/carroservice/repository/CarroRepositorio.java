package com.carro.service.carroservice.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.carro.service.carroservice.entities.Carro;

public interface CarroRepositorio extends JpaRepository<Carro, Integer> {
	List<Carro> findByUsuarioId(int usuarioId);
}
