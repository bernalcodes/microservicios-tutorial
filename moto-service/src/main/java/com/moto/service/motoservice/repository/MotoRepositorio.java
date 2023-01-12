package com.moto.service.motoservice.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.moto.service.motoservice.entities.Moto;

public interface MotoRepositorio extends JpaRepository<Moto, Integer> {
	List<Moto> findByUsuarioId(int usuarioId);
}
