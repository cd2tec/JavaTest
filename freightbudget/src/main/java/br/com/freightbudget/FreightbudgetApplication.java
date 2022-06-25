package br.com.freightbudget;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import br.com.freightbudget.basic.Freight;
import br.com.freightbudget.business.FreightBudgetCalculus;
import br.com.freightbudget.output.FreightOut;
import br.com.freightbudget.repository.FreightDB;
import br.com.freightbudget.repository.IFreghtRepository;

import io.swagger.annotations.*;

@SpringBootApplication
@RestController
public class FreightbudgetApplication {
	
	@Autowired
    private IFreghtRepository freightRepository;
	
	@RequestMapping(value = "/freight", method = RequestMethod.GET, produces="application/json")
	@ApiResponses(value = {
	        @io.swagger.annotations.ApiResponse(code = 400, message = "Bad request: error in input data"),
	        @io.swagger.annotations.ApiResponse(code = 500, message = "A error ocurred in this server. Contact the administrator."),
	}
	)
	public FreightOut freight (
			@RequestParam(value = "peso") int peso, 
			@RequestParam(value = "cepOrigem") String cepOrigem, 
			@RequestParam(value = "cepDestino") String cepDestino,
			@RequestParam(value = "nomeDestinatario") String nomeDestinatario
			) {
		Freight freightResponse =  new Freight(peso, cepOrigem, cepDestino, nomeDestinatario);
		FreightBudgetCalculus fc = new FreightBudgetCalculus();
		fc.calculateDeliveryEstimated(freightResponse);
		freightRepository.save(new FreightDB(freightResponse));	
		return new FreightOut (freightResponse);			
	}

	public static void main(String[] args) {
		SpringApplication.run(FreightbudgetApplication.class, args);
	}	
	
}

