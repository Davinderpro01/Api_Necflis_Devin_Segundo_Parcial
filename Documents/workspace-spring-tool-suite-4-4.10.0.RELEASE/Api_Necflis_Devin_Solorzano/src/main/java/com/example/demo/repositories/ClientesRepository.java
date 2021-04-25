package com.example.demo.repositories;

import org.springframework.data.repository.CrudRepository;

import com.example.demo.entities.Clientes;

public interface ClientesRepository extends CrudRepository<Clientes, Long>{

}
