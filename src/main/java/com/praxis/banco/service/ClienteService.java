package com.praxis.banco.service;

import java.util.List;

import com.praxis.banco.domain.Cliente;

public interface ClienteService {
	Cliente crearCliente(Cliente cliente);

	List<Cliente> obtenerTodo();

	Cliente actualizarCliente(Cliente cliente, Long idCliente);

	Long eliminarCliente(Long idCliente);

	Cliente obtenerCliente(Long idCliente);

}
