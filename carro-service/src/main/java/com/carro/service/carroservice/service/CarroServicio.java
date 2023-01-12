package com.carro.service.carroservice.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.carro.service.carroservice.entities.Carro;
import com.carro.service.carroservice.repository.CarroRepositorio;

@Service
public class CarroServicio {
	@Autowired
	private CarroRepositorio carroRepositorio;

	public List<Carro> getAll() {
		return carroRepositorio.findAll();
	}

	public Carro getCarroById(int id) {
		return carroRepositorio.findById(id).orElse(null);
	}

	public Carro save(Carro carro) {
		Carro nuevoCarro = carroRepositorio.save(carro);
		return nuevoCarro;
	}

	public List<Carro> getCarrosByUsuarioId(int usuarioId) {
		return carroRepositorio.findByUsuarioId(usuarioId);
	}
}
