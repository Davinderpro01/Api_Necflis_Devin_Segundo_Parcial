package com.example.demo.repositories;

import org.springframework.data.repository.CrudRepository;

import com.example.demo.entities.Planes;

public interface PlanRepository extends CrudRepository<Planes, Long>{

}
