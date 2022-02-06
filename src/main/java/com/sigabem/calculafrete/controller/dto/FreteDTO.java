package com.sigabem.calculafrete.controller.dto;

import java.time.LocalDate;

import com.sigabem.calculafrete.model.Frete;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class FreteDTO {
	
	private Double vlTotalFrete;
    private LocalDate dataPrevistaEntrega;
	private String cepOrigem;
	private String cepDestino;

	public FreteDTO(Frete frete) {
		vlTotalFrete = frete.getVlTotalFrete();
		dataPrevistaEntrega = frete.getDataPrevistaEntrega();
		cepOrigem = frete.getCepOrigem();
		cepDestino = frete.getCepDestino();
	}
}
