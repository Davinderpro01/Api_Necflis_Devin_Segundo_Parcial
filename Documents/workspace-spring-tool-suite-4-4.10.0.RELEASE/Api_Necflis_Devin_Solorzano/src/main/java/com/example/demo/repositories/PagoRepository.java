package com.example.demo.repositories;

import org.springframework.data.repository.CrudRepository;

import com.example.demo.entities.Pagos;

public interface PagoRepository extends CrudRepository<Pagos, Long> {

}
