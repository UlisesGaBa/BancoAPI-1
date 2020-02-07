package com.praxis.banco.repository;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.praxis.banco.domain.Cliente;
//Reposytory lo conviete en Beean.
//Spring Framework.
@Repository
public class ClienteRepositoryImpl implements ClienteRepository {
	//Lista statica clientes simular base de dato.
	private static List<Cliente> clientes = new ArrayList<>();

	//Estudiar bloque statico.
	static {
		Cliente ulises = new Cliente();
		ulises.setId(1L);
		ulises.setNombre("Ulises");
		ulises.setApellido("Gaspar Bautista");
		ulises.setEdad(24);
		ulises.setSexo("M");

		clientes.add(ulises);
	}

	@Override
	public Cliente crearCliente(Cliente cliente) {
		cliente.setId(clientes.size() + 1L);
		clientes.add(cliente);
		return cliente;
	}

	@Override
	public List<Cliente> obtenerTodo() {
		return clientes;
	}

	@Override
	public Cliente actualizarCliente(Cliente cliente, Long idCliente) {
		clientes.stream().filter(it -> it.getId().equals(idCliente)).findFirst().get().setApellido(cliente.getApellido());
		clientes.stream().filter(it -> it.getId().equals(idCliente)).findFirst().get().setEdad(cliente.getEdad());
		clientes.stream().filter(it -> it.getId().equals(idCliente)).findFirst().get().setNombre(cliente.getNombre());
		clientes.stream().filter(it -> it.getId().equals(idCliente)).findFirst().get().setSexo(cliente.getSexo());
		return cliente;
	}

	@Override
	public Long eliminarCliente(Long idCliente) {
		//Estudiar Stream, Predicate Lamba java 8 
		clientes.remove(clientes.stream().
				filter(it -> it.getId().equals(idCliente)).findFirst().get());
		return idCliente;
	}

	@Override
	public Cliente obtenerCliente(Long idCliente) {
		return clientes.stream().filter(it -> it.getId().equals(idCliente)).findFirst().get();
	}

}
