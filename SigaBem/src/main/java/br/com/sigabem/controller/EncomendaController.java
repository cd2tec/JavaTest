package br.com.sigabem.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import br.com.sigabem.model.EncomendaModel;
import br.com.sigabem.repository.EncomendaRepository;
import br.com.sigabem.service.EncomendaService;

@RestController
@RequestMapping(value = "/encomenda")
public class EncomendaController {
	
	@Autowired
	private EncomendaRepository encomendaRepository;
	
	@Autowired
	private EncomendaService encomendaService;

	/**
	 * Adciona uma nova encomenda
	 * @param encomenda
	 * @return
	 */
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public EncomendaModel encomendaModel(@Valid @RequestBody EncomendaModel encomenda) {
		return encomendaService.salvarEncomenda(encomenda);
	}
	
	/**
	 * Listar todas as ecomendas existentes
	 * @return
	 */
	@GetMapping
	public List<EncomendaModel> listarEncomenda(){
		return encomendaRepository.findAll();
	}
	
	/**
	 * Pesquisa pelo id da encomenda
	 * @param idEncomenda
	 * @return
	 */
	@GetMapping("{idEncomenda}")
	public ResponseEntity<EncomendaModel> buscarPorId(@PathVariable Long idEncomenda){
		return encomendaRepository.findById(idEncomenda)
				.map(encomenda -> ResponseEntity.ok(encomenda))
				.orElse(ResponseEntity.notFound().build());
	}
	
	/**
	 * Metodo para Atualizar encomenda
	 * @param idEncomenda
	 * @param encomendaModel
	 * @return
	 */
	@PutMapping("/{idEncomenda}")
	public ResponseEntity<EncomendaModel> atualizarEncomenda(@Valid @PathVariable Long idEncomenda, 
			@RequestBody EncomendaModel encomendaModel){
		
		if (!encomendaRepository.existsById(idEncomenda)) {
			return ResponseEntity.notFound().build();
		}
		
		encomendaModel.setId(idEncomenda);
		encomendaModel = encomendaService.salvarEncomenda(encomendaModel);
		return ResponseEntity.ok(encomendaModel);
	}
	
	/**
	 * Excluir Encomenda
	 * @param idEncomenda
	 * @return
	 */
	@DeleteMapping("/{idEncomenda}")
	public ResponseEntity<Void> excluirEncomenda(@PathVariable Long idEncomenda){
		if (!encomendaRepository.existsById(idEncomenda)) {
			return ResponseEntity.notFound().build();
		}
		encomendaService.excluirEncomenda(idEncomenda);
		return ResponseEntity.noContent().build();
	}
}
