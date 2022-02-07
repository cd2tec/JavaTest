package teste.sigabem.entities;

import java.math.BigDecimal;
import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@RequiredArgsConstructor
@Getter
@Setter
@Entity
public class CalculoFrete {
	
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
	
	
	public CalculoFrete( Double peso, String cepOrigem, String cepDestino, String nomeDestinatario,
			BigDecimal valorTotalFrete, LocalDate dataPrevistaEntrega, LocalDate dataConsulta) {
		super();
		this.peso = peso;
		this.cepOrigem = cepOrigem;
		this.cepDestino = cepDestino;
		this.nomeDestinatario = nomeDestinatario;
		this.valorTotalFrete = valorTotalFrete;
		this.dataPrevistaEntrega = dataPrevistaEntrega;
		this.dataConsulta = dataConsulta;
	}



}