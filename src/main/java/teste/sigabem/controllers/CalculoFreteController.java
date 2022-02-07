package teste.sigabem.controllers;

import java.net.URI;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import teste.sigabem.dto.CalculoFreteDTO;
import teste.sigabem.dto.FreteDTO;
import teste.sigabem.entities.CalculoFrete;
import teste.sigabem.services.FreteService;


@RestController
public class CalculoFreteController {
    
    private static final Logger log = LoggerFactory.getLogger(CalculoFreteController.class);

    private FreteService freteService;

    public CalculoFreteController(FreteService freteService) {
        this.freteService = freteService;
    }

    @PostMapping("response/output")
    public ResponseEntity<CalculoFreteDTO> calcularFrete(@Valid @RequestBody FreteDTO frete) {
        CalculoFrete resultado = freteService.calcularFrete(frete);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(resultado.getId())
                .toUri();
        return ResponseEntity.created(uri).body(new CalculoFreteDTO(resultado));
    }

}
