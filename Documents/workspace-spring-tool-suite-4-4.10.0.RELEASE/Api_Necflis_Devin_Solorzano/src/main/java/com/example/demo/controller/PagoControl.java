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

import com.example.demo.entities.Pagos;
import com.example.demo.repositories.PagoRepository;


@RestController
@RequestMapping(value = "/pagos")
public class PagoControl {
	
	@Autowired
	PagoRepository repository;
	
	@GetMapping
	@ResponseStatus(code = HttpStatus.OK)
	public Collection<Pagos> getListaPagos(){
		 Iterable<Pagos> listaPagos = repository.findAll();
		return (Collection<Pagos>) listaPagos;
	}
	
	@GetMapping(value = "/{id}")
	@ResponseStatus(code = HttpStatus.OK)
	public Pagos getPago(@PathVariable(name = "id") Long id) {
		Optional<Pagos> pago = repository.findById(id);
		Pagos resultado = null;
		if(pago.isPresent()) {
			resultado = pago.get();
		}
		return resultado;
	}
	
	@PutMapping(value = "/{id}")
	@ResponseStatus(code = HttpStatus.ACCEPTED)
	public Pagos updatePago(@PathVariable(name = "id")Long id, 
			@RequestBody Pagos pago) {
		Optional<Pagos> Pago = repository.findById(id);
		if(Pago.isPresent()) {
			Pagos ultimo = Pago.get();
			ultimo.setId(id);
			ultimo.setFecha(pago.getFecha());
			ultimo.setMonto(pago.getMonto());
			ultimo.setNumTarjeta(pago.getNumTarjeta());
			ultimo.setEstado(pago.getEstado());
			Pagos cargarPagos = repository.save(ultimo);
			return cargarPagos;
		}
		return null;
	}
	
	@PostMapping
	@ResponseStatus(code = HttpStatus.CREATED)
	public Pagos createPago(@RequestBody Pagos pago) {
		Pagos Pagonuevo = repository.save(pago);
		return Pagonuevo;
	}
	
	@DeleteMapping(value = "/{id}")
	@ResponseStatus(code = HttpStatus.ACCEPTED)
	public void deletePago(@PathVariable(name = "id") Long id) {
		repository.deleteById(id);
	}
		
}
