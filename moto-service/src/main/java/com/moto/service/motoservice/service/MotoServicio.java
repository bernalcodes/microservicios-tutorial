package com.moto.service.motoservice.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.moto.service.motoservice.entities.Moto;
import com.moto.service.motoservice.repository.MotoRepositorio;

@Service
public class MotoServicio {
	@Autowired
	private MotoRepositorio motoRepositorio;

	public List<Moto> getAll() {
		return motoRepositorio.findAll();
	}

	public Moto getMotoById(int id) {
		return motoRepositorio.findById(id).orElse(null);
	}

	public Moto save(Moto moto) {
		Moto nuevaMoto = motoRepositorio.save(moto);
		return nuevaMoto;
	}

	public List<Moto> getMotosByUsuarioId(int usuarioId) {
		return motoRepositorio.findByUsuarioId(usuarioId);
	}
}
