package br.com.sigabem.service;

import java.util.Calendar;
import java.util.Date;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import br.com.sigabem.ViaCep.ViaCep;
import br.com.sigabem.model.EncomendaModel;
import br.com.sigabem.repository.EncomendaRepository;
import br.com.sigabem.util.dateUtil;

@Service
public class EncomendaService {

	@Autowired
	private EncomendaRepository encomendaRepository;
	
	/**
	 * Metodo de adicionar uma encomenda
	 * @param encomendaModel
	 * @return
	 */
	@Transactional
	public EncomendaModel salvarEncomenda(EncomendaModel encomendaModel) {
		this.pesquisaCep(encomendaModel);
		return encomendaRepository.save(encomendaModel);
	}
	
	/**
	 * Metodo para calcular o frete e prazo
	 * @param encomendaModel
	 */
	private void pesquisaCep(EncomendaModel encomendaModel) {
		
		String url = "https://viacep.com.br/ws/"+encomendaModel.getCepDestino()+"/json/";
		RestTemplate restTemplate = new RestTemplate();
		ViaCep viaCep = restTemplate.getForObject(url, ViaCep.class);
		
		dateUtil data =  new dateUtil();
		
		if (encomendaModel.getDdd().equals(viaCep.getDdd())) 
		{
			encomendaModel.setVlTotalFrete(encomendaModel.getPeso() * 0.5);
			encomendaModel.setDataPrevistaEntrega(data.doAddSubData(Calendar.DAY_OF_MONTH, 1,new Date()));
		} 
		else 
		{
			if (encomendaModel.getUf().equals(viaCep.getUf())) 
			{
				encomendaModel.setVlTotalFrete(encomendaModel.getPeso()*0.75);
				encomendaModel.setDataPrevistaEntrega(data.doAddSubData(Calendar.DAY_OF_MONTH, 3,new Date()));
			}
		} 
		if (!encomendaModel.getUf().equals(viaCep.getUf())) 
		{
			encomendaModel.setVlTotalFrete(encomendaModel.getPeso());
			encomendaModel.setDataPrevistaEntrega(data.doAddSubData(Calendar.DAY_OF_MONTH, 10,new Date()));
		}		
	}
	
	/**
	 * Metodo para excluir uma encomenda
	 * @param Idencomenda
	 */
	@Transactional
	public void excluirEncomenda(Long Idencomenda) {
		encomendaRepository.deleteById(Idencomenda);
	}
}
