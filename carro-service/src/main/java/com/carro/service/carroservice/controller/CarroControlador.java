package com.carro.service.carroservice.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.carro.service.carroservice.entities.Carro;
import com.carro.service.carroservice.service.CarroServicio;

@RestController
@RequestMapping("/carro")
public class CarroControlador {
	@Autowired
	private CarroServicio carroServicio;

	@GetMapping
	public ResponseEntity<List<Carro>> listarCarros() {
		List<Carro> carros = carroServicio.getAll();

		if (carros.isEmpty()) {
			return ResponseEntity.noContent().build();
		}

		return ResponseEntity.ok(carros);
	}

	@GetMapping("/{id}")
	public ResponseEntity<Carro> obtenerCarro(@PathVariable("id") int id) {
		Carro carro = carroServicio.getCarroById(id);

		if (carro == null) {
			return ResponseEntity.notFound().build();
		}

		return ResponseEntity.ok(carro);
	}

	@PostMapping
	public ResponseEntity<Carro> guardarCarro(@RequestBody Carro carro) {
		Carro nuevoCarro = carroServicio.save(carro);
		return ResponseEntity.ok(nuevoCarro);
	}

	@GetMapping("/usuario/{usuarioId}")
	public ResponseEntity<List<Carro>> listarCarrosPorUsuarioId(@PathVariable("usuarioId") int usuarioId) {
		List<Carro> carros = carroServicio.getCarrosByUsuarioId(usuarioId);

		if (carros.isEmpty()) {
			return ResponseEntity.noContent().build();
		}

		return ResponseEntity.ok(carros);
	}
}
