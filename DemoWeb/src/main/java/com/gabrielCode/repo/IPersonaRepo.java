package com.gabrielCode.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.gabrielCode.model.Persona;

@Repository
public interface IPersonaRepo extends JpaRepository<Persona, Integer> {

}
