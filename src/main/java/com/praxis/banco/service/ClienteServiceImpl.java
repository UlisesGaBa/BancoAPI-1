package com.praxis.banco.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.praxis.banco.domain.Cliente;
import com.praxis.banco.repository.ClienteRepository;

@Service
public class ClienteServiceImpl implements ClienteService {

	@Autowired
	private ClienteRepository clienteReporsitory;

	@Override
	public Cliente crearCliente(Cliente cliente) {
		return clienteReporsitory.crearCliente(cliente);
	}

	@Override
	public List<Cliente> obtenerTodo() {
		return clienteReporsitory.obtenerTodo();
	}

	@Override
	public Cliente actualizarCliente(Cliente cliente, Long idCliente) {
		return clienteReporsitory.actualizarCliente(cliente, idCliente);
	}

	@Override
	public Long eliminarCliente(Long idCliente) {

		return clienteReporsitory.eliminarCliente(idCliente);
	}

	@Override
	public Cliente obtenerCliente(Long idCliente) {
		return clienteReporsitory.obtenerCliente(idCliente);
	}

}
