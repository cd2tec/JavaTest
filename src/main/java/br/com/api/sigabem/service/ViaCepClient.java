package br.com.api.sigabem.service;

import org.springframework.stereotype.Service;

import br.com.api.sigabem.model.Address;

@Service
public class ViaCepClient {

	public Address getOrigem() {

		return new Address();

	}

	public Address getDestino() {

		return new Address();

	}

}
