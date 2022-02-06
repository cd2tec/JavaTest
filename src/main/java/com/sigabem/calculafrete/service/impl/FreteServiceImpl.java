package com.sigabem.calculafrete.service.impl;

import java.time.LocalDate;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sigabem.calculafrete.controller.form.FreteForm;
import com.sigabem.calculafrete.model.Frete;
import com.sigabem.calculafrete.repository.FreteRepository;
import com.sigabem.calculafrete.service.FreteService;

@Service
public class FreteServiceImpl implements FreteService {

	@Autowired
	private FreteRepository freteRepository;
	@Autowired
	private ModelMapper modelMapper;

	@Override
	public Frete ConsultaValorFrete(FreteForm form) {
		Frete frete = toFrete(form);
		frete.setDataConsulta(LocalDate.now());
		return freteRepository.save(frete);
	}

	public Frete toFrete(FreteForm form) {
		return modelMapper.map(form, Frete.class);
	}


}
