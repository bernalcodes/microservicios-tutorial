package com.usuario.service.usuarioservice.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.usuario.service.usuarioservice.entities.Usuario;
import com.usuario.service.usuarioservice.models.Carro;
import com.usuario.service.usuarioservice.models.Moto;
import com.usuario.service.usuarioservice.service.UsuarioServicio;

@RestController
@RequestMapping("/usuario")
public class UsuarioControlador {
	@Autowired
	private UsuarioServicio usuarioServicio;

	@GetMapping
	public ResponseEntity<List<Usuario>> listarUsuarios() {
		List<Usuario> usuarios = usuarioServicio.getAll();

		if (usuarios.isEmpty()) {
			return ResponseEntity.noContent().build();
		}

		return ResponseEntity.ok(usuarios);
	}

	@GetMapping("/{id}")
	public ResponseEntity<Usuario> obtenerUsuario(@PathVariable("id") int id) {
		Usuario usuario = usuarioServicio.getUsuarioById(id);

		if (usuario == null) {
			return ResponseEntity.notFound().build();
		}

		return ResponseEntity.ok(usuario);
	}

	@PostMapping
	public ResponseEntity<Usuario> guardarUsuario(@RequestBody Usuario usuario) {
		Usuario nuevoUsuario = usuarioServicio.save(usuario);
		return ResponseEntity.ok(nuevoUsuario);
	}

	@GetMapping("/carros/{usuarioId}")
	public ResponseEntity<List<Carro>> getCarros(@PathVariable("usuarioId") int usuarioId) {
		Usuario usuario = usuarioServicio.getUsuarioById(usuarioId);

		if (usuario == null) {
			return ResponseEntity.noContent().build();
		}

		List<Carro> carros = usuarioServicio.getCarros(usuarioId);

		return ResponseEntity.ok(carros);
	}

	@GetMapping("/motos/{usuarioId}")
	public ResponseEntity<List<Moto>> getMotos(@PathVariable("usuarioId") int usuarioId) {
		Usuario usuario = usuarioServicio.getUsuarioById(usuarioId);

		if (usuario == null) {
			return ResponseEntity.noContent().build();
		}

		List<Moto> motos = usuarioServicio.getMotos(usuarioId);

		return ResponseEntity.ok(motos);
	}

	@PostMapping("/carro/{usuarioId}")
	public ResponseEntity<Carro> guardarCarro(@PathVariable("usuarioId") int usuarioId, @RequestBody Carro carro) {
		Carro nuevoCarro = usuarioServicio.saveCarro(usuarioId, carro);
		return ResponseEntity.ok(nuevoCarro);
	}
	
	@PostMapping("/moto/{usuarioId}")
	public ResponseEntity<Moto> guardarMoto(@PathVariable("usuarioId") int usuarioId, @RequestBody Moto moto) {
		Moto nuevaMoto = usuarioServicio.saveMoto(usuarioId, moto);
		return ResponseEntity.ok(nuevaMoto);
	}

	@GetMapping("/todos/{usuarioId}")
	public ResponseEntity<Map<String, Object>> listarTodosLosVehiculos(@PathVariable("usuarioId") int usuuarioId) {
		Map<String, Object> resultado = usuarioServicio.getUsuarioAndVehiculos(usuuarioId);
		return ResponseEntity.ok(resultado);
	}
}
