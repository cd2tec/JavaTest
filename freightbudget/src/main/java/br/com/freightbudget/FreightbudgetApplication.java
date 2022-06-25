package br.com.freightbudget;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import br.com.freightbudget.business.FreightCalculus;
import br.com.freightbudget.datasources.*;
import br.com.freightbudget.repository.IFreghtRepository;

@SpringBootApplication
@RestController
public class FreightbudgetApplication {
	
	@Autowired
    private IFreghtRepository freightRepository;
	
	@GetMapping("/freight")
	public FreightOut freight (
			@RequestParam(value = "peso") int peso, 
			@RequestParam(value = "cepOrigem") String cepOrigem, 
			@RequestParam(value = "cepDestino") String cepDestino,
			@RequestParam(value = "nomeDestinatario") String nomeDestinatario
			) {
		Freight freightResponse =  new Freight(peso, cepOrigem, cepDestino, nomeDestinatario);
		FreightCalculus fc = new FreightCalculus();
		fc.calculateDeliveryEstimated(freightResponse);
		freightRepository.save(new FreightDB(freightResponse));	
		return new FreightOut (freightResponse.getPreco(), freightResponse.getDelliveryEstimated(), freightResponse.getPostalCodeOrigin(), freightResponse.getPostalCodeDestin());			
	}

	public static void main(String[] args) {
		SpringApplication.run(FreightbudgetApplication.class, args);
	}	
	
}

