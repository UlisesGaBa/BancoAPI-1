package com.praxis.banco.controler;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.praxis.banco.domain.Cliente;
import com.praxis.banco.service.ClienteService;

@RestController
@RequestMapping("/api/v1/cliente")
public class ClienteController {
	
	@Autowired
	private ClienteService clienteService;
	
	@GetMapping
	public List<Cliente> getAll(){
		return clienteService.obtenerTodo();
	}
	
	@PostMapping
	public Cliente addCliente (@RequestBody Cliente cliente) {
		return clienteService.crearCliente(cliente);
	}
	
	@DeleteMapping("/{idCliente}")
	public Long removeCliente (@PathVariable(name = "idCliente") Long idCliente) {
		return clienteService.eliminarCliente(idCliente);
	}
	
	@PutMapping("/{idCliente}")
	public Cliente updateCliente (@RequestBody Cliente cliente , @PathVariable(name = "idCliente" )Long idCliente) {
		return clienteService.actualizarCliente(cliente, idCliente);
	}
	
	@GetMapping("/{idCliente}")
	public Cliente obtenerCliente (@PathVariable (name = "idCliente") Long idCliente) {
		return clienteService.obtenerCliente(idCliente);
	}
	
}
