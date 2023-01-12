package com.usuario.service.usuarioservice.feignclients;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.usuario.service.usuarioservice.models.Carro;

@FeignClient(name = "carro-service", url = "http://localhost:8002", path = "/carro")
public interface CarroFeignClient {
	@PostMapping()
	public Carro save(@RequestBody Carro carro);

	@GetMapping("/usuario/{usuarioId}")
	public List<Carro> getCarros(@PathVariable("usuarioId") int usuarioId);
}
