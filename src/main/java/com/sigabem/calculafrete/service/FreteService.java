package com.sigabem.calculafrete.service;

import com.sigabem.calculafrete.controller.form.FreteForm;
import com.sigabem.calculafrete.model.Frete;

public interface FreteService {

	Frete ConsultaValorFrete(FreteForm form);
	
	

}
