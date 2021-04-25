package com.example.demo.controller;

import java.util.Collection;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entities.Clientes;
import com.example.demo.repositories.ClientesRepository;

@RestController
@RequestMapping(value = "/clientes")
public class ClientesControl {
	
	@Autowired
	ClientesRepository repository;
	
	@GetMapping
	@ResponseStatus(code = HttpStatus.OK)
	public Collection<Clientes> getListaClientes(){
		 Iterable<Clientes> listaClientes = repository.findAll();
		return (Collection<Clientes>) listaClientes;
	}
	
	@GetMapping(value = "/{id}")
	@ResponseStatus(code = HttpStatus.OK)
	public Clientes getCliente(@PathVariable(name = "id") Long id) {
		Optional<Clientes> cliente = repository.findById(id);
		Clientes resultados = null;
		if(cliente.isPresent()) {
			resultados = cliente.get();
		}
		return resultados;
	}
	
	@PutMapping(value = "/{id}")
	@ResponseStatus(code = HttpStatus.ACCEPTED)
	public Clientes updateCliente(@PathVariable(name = "id")Long id, 
			@RequestBody Clientes cliente) {
		Optional<Clientes> Cliente = repository.findById(id);
		if(Cliente.isPresent()) {
			Clientes moderno = Cliente.get();
			moderno.setId(id);
			moderno.setNombre(cliente.getNombre());
			moderno.setEdad(cliente.getEdad());
			moderno.setGenero(cliente.getGenero());
			moderno.setPais(cliente.getPais());	
			moderno.setFecha(cliente.getFecha());
			Clientes cargarClientes = repository.save(moderno);
			return cargarClientes;
		}
		return null;
	}
	
	@PostMapping
	@ResponseStatus(code = HttpStatus.CREATED)
	public Clientes createCliente(@RequestBody Clientes cliente) {
		Clientes Clientenuevo = repository.save(cliente);
		return Clientenuevo;
	}
	
	@DeleteMapping(value = "/{id}")
	@ResponseStatus(code = HttpStatus.ACCEPTED)
	public void deleteCliente(@PathVariable(name = "id") Long id) {
		repository.deleteById(id);
	}
	
}
