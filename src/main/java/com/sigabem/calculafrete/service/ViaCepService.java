package com.sigabem.calculafrete.service;

import com.sigabem.calculafrete.controller.dto.ViaCepDTO;

public interface ViaCepService {
	
	ViaCepDTO buscaPorCep(String cep);

}
