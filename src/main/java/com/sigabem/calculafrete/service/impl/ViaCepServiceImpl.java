package com.sigabem.calculafrete.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sigabem.calculafrete.controller.dto.ViaCepDTO;
import com.sigabem.calculafrete.service.ViaCepService;
import com.sigabem.calculafrete.utils.ViaCepClient;

@Service
public class ViaCepServiceImpl implements ViaCepService{
	
	@Autowired
	private ViaCepClient viaCepClient;

	public ViaCepDTO buscaPorCep(String cep) {
		ViaCepDTO dto = viaCepClient.buscaCep(cep);
		return dto;
	}

}
