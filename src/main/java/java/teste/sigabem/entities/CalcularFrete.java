package java.teste.sigabem.entities;

import java.math.BigDecimal;
import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class CalcularFrete {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private Double peso;
	
	private String cepOrigem;
	
	private String cepDestino;
	
	private String nomeDestinatario;
	
	private BigDecimal valorTotalFrete;
	
	private LocalDate dataPrevistaEntrega;
	
	private LocalDate dataConsulta;
	
	
	public CalcularFrete() {
		
	}

	

	public CalcularFrete(Long id, Double peso, String cepOrigem, String cepDestino, String nomeDestinatario,
			BigDecimal valorTotalFrete, LocalDate dataPrevistaEntrega, LocalDate dataConsulta) {
		super();
		this.id = id;
		this.peso = peso;
		this.cepOrigem = cepOrigem;
		this.cepDestino = cepDestino;
		this.nomeDestinatario = nomeDestinatario;
		this.valorTotalFrete = valorTotalFrete;
		this.dataPrevistaEntrega = dataPrevistaEntrega;
		this.dataConsulta = dataConsulta;
	}



	public Long getId() {
		return id;
	}



	public void setId(Long id) {
		this.id = id;
	}



	public Double getPeso() {
		return peso;
	}



	public void setPeso(Double peso) {
		this.peso = peso;
	}



	public String getCepOrigem() {
		return cepOrigem;
	}



	public void setCepOrigem(String cepOrigem) {
		this.cepOrigem = cepOrigem;
	}



	public String getCepDestino() {
		return cepDestino;
	}



	public void setCepDestino(String cepDestino) {
		this.cepDestino = cepDestino;
	}



	public String getNomeDestinatario() {
		return nomeDestinatario;
	}



	public void setNomeDestinatario(String nomeDestinatario) {
		this.nomeDestinatario = nomeDestinatario;
	}



	public BigDecimal getValorTotalFrete() {
		return valorTotalFrete;
	}



	public void setValorTotalFrete(BigDecimal valorTotalFrete) {
		this.valorTotalFrete = valorTotalFrete;
	}



	public LocalDate getDataPrevistaEntrega() {
		return dataPrevistaEntrega;
	}



	public void setDataPrevistaEntrega(LocalDate dataPrevistaEntrega) {
		this.dataPrevistaEntrega = dataPrevistaEntrega;
	}



	public LocalDate getDataConsulta() {
		return dataConsulta;
	}



	public void setDataConsulta(LocalDate dataConsulta) {
		this.dataConsulta = dataConsulta;
	}



	

	
	

}
