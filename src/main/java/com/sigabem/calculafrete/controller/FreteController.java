package com.sigabem.calculafrete.controller;

import java.net.URI;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import com.sigabem.calculafrete.controller.dto.FreteDTO;
import com.sigabem.calculafrete.controller.form.FreteForm;
import com.sigabem.calculafrete.model.Frete;
import com.sigabem.calculafrete.service.FreteService;

@RestController
@RequestMapping("/consultar")
public class FreteController {

	@Autowired
	private FreteService service;
	
	@PostMapping
	@Transactional
	public ResponseEntity<FreteDTO> recebeDados(@RequestBody @Valid FreteForm form, UriComponentsBuilder uriBuilder) {
		Frete frete = service.consultaValorFrete(form);		
		URI uri = uriBuilder.path("/frete/{id}").buildAndExpand(frete.getId()).toUri();
		return ResponseEntity.created(uri).body(new FreteDTO(frete));
	}
	
}
