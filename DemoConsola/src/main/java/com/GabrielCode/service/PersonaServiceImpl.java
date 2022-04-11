package com.GabrielCode.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.GabrielCode.repository.IPersona;

@Service

public class PersonaServiceImpl implements IPersonaService {
	
	@Autowired
	@Qualifier("persona2")
	IPersona repo;
	
	public PersonaServiceImpl() {}
	
	@Override
	public void registrarHandler(String pNombre) {
		repo.registrar(pNombre);
	}

}
