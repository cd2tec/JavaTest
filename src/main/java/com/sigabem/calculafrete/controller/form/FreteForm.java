package com.sigabem.calculafrete.controller.form;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import lombok.Getter;

@Getter
public class FreteForm {

	@NotNull 
	private Double peso;
	@NotNull @NotEmpty @Size(min = 8)
	private String cepOrigem;
	@NotNull @NotEmpty @Size(min = 8)
	private String cepDestino;
	@NotNull @NotEmpty
    private String nomeDestinatario;
    
}
