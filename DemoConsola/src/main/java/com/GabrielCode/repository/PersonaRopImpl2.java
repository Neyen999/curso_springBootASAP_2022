package com.GabrielCode.repository;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import com.GabrielCode.DemoConsolaApplication;

@Repository
@Qualifier("persona2")
public class PersonaRopImpl2 implements IPersona {
	
	public static Logger log = LoggerFactory.getLogger(DemoConsolaApplication.class);

	@Override
	public void registrar(String pNombre) {
		// TODO Auto-generated method stub
		log.info("Se registro el nombre de persona2 " + pNombre);
	}

}
