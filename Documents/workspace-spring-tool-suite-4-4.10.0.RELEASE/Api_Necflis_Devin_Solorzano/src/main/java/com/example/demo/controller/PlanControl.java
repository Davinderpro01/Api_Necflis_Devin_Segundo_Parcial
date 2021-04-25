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

import com.example.demo.entities.Planes;
import com.example.demo.repositories.PlanRepository;

@RestController
@RequestMapping(value = "/planes")
public class PlanControl {
	
	@Autowired
	PlanRepository repository;
	
	@GetMapping
	@ResponseStatus(code = HttpStatus.OK)
	public Collection<Planes> getListaTarifas(){
		 Iterable<Planes> listaPlanes = repository.findAll();
		return (Collection<Planes>) listaPlanes;
	}
	
	@GetMapping(value = "/{id}")
	@ResponseStatus(code = HttpStatus.OK)
	public Planes getTarifa(@PathVariable(name = "id") Long id) {
		Optional<Planes> plan = repository.findById(id);
		Planes resultado = null;
		if(plan.isPresent()) {
			resultado = plan.get();
		}
		return resultado;
	}
	
	@PutMapping(value = "/{id}")
	@ResponseStatus(code = HttpStatus.ACCEPTED)
	public Planes updateTarifa(@PathVariable(name = "id")Long id, 
			@RequestBody Planes plan) {
		Optional<Planes> Plan = repository.findById(id);
		if(Plan.isPresent()) {
			Planes premium = Plan.get();
			premium.setId(id);
			premium.setNombre(plan.getNombre());
			premium.setDescripcion(plan.getDescripcion());
			premium.setPrecio(plan.getPrecio());
			premium.setFecha(plan.getFecha());
			Planes cargarPlan = repository.save(premium);
			return cargarPlan;
		}
		return null;
	}
	
	@PostMapping
	@ResponseStatus(code = HttpStatus.CREATED)
	public Planes createTarifa(@RequestBody Planes plan) {
		Planes planNuevo = repository.save(plan);
		return planNuevo;
	}
	
	@DeleteMapping(value = "/{id}")
	@ResponseStatus(code = HttpStatus.ACCEPTED)
	public void deleteTarifa(@PathVariable(name = "id") Long id) {
		repository.deleteById(id);
	}
	
}
