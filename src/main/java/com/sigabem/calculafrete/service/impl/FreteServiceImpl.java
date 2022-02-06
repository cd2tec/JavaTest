package com.sigabem.calculafrete.service.impl;

import java.time.LocalDate;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sigabem.calculafrete.controller.dto.ViaCepDTO;
import com.sigabem.calculafrete.controller.form.FreteForm;
import com.sigabem.calculafrete.model.Frete;
import com.sigabem.calculafrete.repository.FreteRepository;
import com.sigabem.calculafrete.service.FreteService;
import com.sigabem.calculafrete.service.ViaCepService;

@Service
public class FreteServiceImpl implements FreteService {

	@Autowired
	private FreteRepository repository;
	
	@Autowired
	private ModelMapper modelMapper;
	
	private ViaCepService service;
	
	private final Double precoKg = 1.0;
	
	@Override
	public Frete ConsultaValorFrete(FreteForm form) {
		Frete frete = toFrete(form);
		frete.setDataConsulta(LocalDate.now());
		ViaCepDTO cepOrigem = service.buscaPorCep(frete.getCepOrigem());
		ViaCepDTO cepDestino = service.buscaPorCep(frete.getCepDestino());
		frete = calculaFreteData(cepOrigem, cepDestino, frete);
		return repository.save(frete);
	}

	public Frete toFrete(FreteForm form) {
		return modelMapper.map(form, Frete.class);
	}
	
	private Frete calculaFreteData(ViaCepDTO cepOrigem, ViaCepDTO cepDestino, Frete frete) {
		frete.setVlTotalFrete(frete.getPeso() * precoKg);
		frete.setDataPrevistaEntrega(LocalDate.now().plusDays(10));
		
		if (cepOrigem.getDdd() == cepDestino.getDdd()) {
			frete.setVlTotalFrete((frete.getPeso() * precoKg)*0.5);
			frete.setDataPrevistaEntrega(LocalDate.now().plusDays(1));
			return frete;
		}
		
		if (cepOrigem.getDdd() != cepDestino.getDdd() && cepOrigem.getUf() == cepDestino.getUf()) {
			frete.setVlTotalFrete((frete.getPeso() * precoKg)*0.75);
			frete.setDataPrevistaEntrega(LocalDate.now().plusDays(3));
			return frete;
		}
		
		return frete;
	}
	
}
