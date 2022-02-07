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
import com.sigabem.calculafrete.utils.ViaCepClient;

@Service
public class FreteServiceImpl implements FreteService {

	@Autowired
	private FreteRepository repository;
	
	@Autowired
	private ModelMapper modelMapper;
	
	@Autowired
	private ViaCepClient service;
	
	private final Double precoKg = 1.0;
	
	@Override
	public Frete consultaValorFrete(FreteForm form) {
		Frete frete = toFrete(form);
		frete.setDataConsulta(LocalDate.now());
		ViaCepDTO cepOrigem = service.buscaCep(frete.getCepOrigem());
		ViaCepDTO cepDestino = service.buscaCep(frete.getCepDestino());
		frete = calculaFreteData(cepOrigem, cepDestino, frete);
		return repository.save(frete);
	}

	public Frete toFrete(FreteForm form) {
		return modelMapper.map(form, Frete.class);
	}
	
	public Frete calculaFreteData(ViaCepDTO cepOrigem, ViaCepDTO cepDestino, Frete frete) {
		frete.setVlTotalFrete(frete.getPeso() * precoKg);
		frete.setDataPrevistaEntrega(LocalDate.now().plusDays(10));
		
		if (cepOrigem.getDdd().equals(cepDestino.getDdd())) {
			frete.setVlTotalFrete((frete.getPeso() * precoKg)*0.5);
			frete.setDataPrevistaEntrega(LocalDate.now().plusDays(1));
			return frete;
		}
		
		if (!cepOrigem.getDdd().equals(cepDestino.getDdd()) && cepOrigem.getUf().equals(cepDestino.getUf())) {
			frete.setVlTotalFrete((frete.getPeso() * precoKg)*0.25);
			frete.setDataPrevistaEntrega(LocalDate.now().plusDays(3));
			return frete;
		}
		
		return frete;
	}
	
}
