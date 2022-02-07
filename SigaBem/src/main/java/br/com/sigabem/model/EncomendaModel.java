package br.com.sigabem.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Size;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "encomenda")
public class EncomendaModel {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@EqualsAndHashCode.Include
	@Column(name = "id_encomenda")
	private Long id;
	
	@Column(name = "peso")
	private Double peso;
	
	@Size(max = 8)
	@Column(name = "cep_origem")
	private String cepOrigem;
	
	@Size(max = 8)
	@Column(name = "cep_destino")
	private String cepDestino;
	
	@Column(name = "nome_destinatario")	
	private String nomeDestinatario;
	
	@Column(name = "vl_total_frete")
	private Double vlTotalFrete; 
	
	@Column(name = "data_prevista_entrega")
	private Date dataPrevistaEntrega; 
	
	@Column(name = "data_consulta")
	private String dataConsulta;
	
	@Size(max = 2)
	@Column(name = "uf")
	private String uf;
	
	@Size(max = 2)
	@Column(name = "ddd")
	private String ddd;
}
