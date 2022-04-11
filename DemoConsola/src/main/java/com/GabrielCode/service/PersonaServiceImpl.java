package com.GabrielCode.service;

import com.GabrielCode.repository.IPersona;

public class PersonaServiceImpl implements IPersonaService {
	IPersona repo;
	
	
	@Override
	public void registrarHandler(String pNombre) {
		// TODO Auto-generated method stub

		repo.registrar(pNombre);
	}

}
