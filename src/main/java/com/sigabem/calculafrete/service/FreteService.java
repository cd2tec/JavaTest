package com.sigabem.calculafrete.service;

import com.sigabem.calculafrete.controller.dto.ViaCepDTO;
import com.sigabem.calculafrete.controller.form.FreteForm;
import com.sigabem.calculafrete.model.Frete;

public interface FreteService {

	Frete consultaValorFrete(FreteForm form);
	
	Frete toFrete(FreteForm form);
	
	Frete calculaFreteData(ViaCepDTO cepOrigem, ViaCepDTO cepDestino, Frete frete);
	

}
