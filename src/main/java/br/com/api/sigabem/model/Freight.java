package br.com.api.sigabem.model;

import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Freight {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column
	private String nomeDestinatario;
	@Column
	private Double peso;
	@Column(length = 8)
	private String cepOrigem;
	@Column(length = 8)
	private String cepDestino;
	private Double vlrTotalFrete;
	private String dataPrevistaEntrega;
	private String dataConsulta;

	public Freight() {

	}

	public Freight(Long id, String nomeDestinatario, Double peso, String cepOrigem, String cepDestino,
			Double vlrTotalFrete, String dataPrevistaEntrega, String dataConsulta) {
		this.id = id;
		this.nomeDestinatario = nomeDestinatario;
		this.peso = peso;
		this.cepOrigem = cepOrigem;
		this.cepDestino = cepDestino;
		this.vlrTotalFrete = vlrTotalFrete;
		this.dataPrevistaEntrega = dataPrevistaEntrega;
		this.dataConsulta = dataConsulta;
	}

	@Override
	public int hashCode() {
		return Objects.hash(cepDestino, cepOrigem, dataConsulta, dataPrevistaEntrega, id, nomeDestinatario, peso,
				vlrTotalFrete);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Freight other = (Freight) obj;
		return Objects.equals(cepDestino, other.cepDestino) && Objects.equals(cepOrigem, other.cepOrigem)
				&& Objects.equals(dataConsulta, other.dataConsulta)
				&& Objects.equals(dataPrevistaEntrega, other.dataPrevistaEntrega) && Objects.equals(id, other.id)
				&& Objects.equals(nomeDestinatario, other.nomeDestinatario) && Objects.equals(peso, other.peso)
				&& Objects.equals(vlrTotalFrete, other.vlrTotalFrete);
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNomeDestinatario() {
		return nomeDestinatario;
	}

	public void setNomeDestinatario(String nomeDestinatario) {
		this.nomeDestinatario = nomeDestinatario;
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

	public Double getVlrTotalFrete() {
		return vlrTotalFrete;
	}

	public void setVlrTotalFrete(Double vlrTotalFrete) {
		this.vlrTotalFrete = vlrTotalFrete;
	}

	public String getDataPrevistaEntrega() {
		return dataPrevistaEntrega;
	}

	public void setDataPrevistaEntrega(String dataPrevistaEntrega) {
		this.dataPrevistaEntrega = dataPrevistaEntrega;
	}

	public String getDataConsulta() {
		return dataConsulta;
	}

	public void setDataConsulta(String dataConsulta) {
		this.dataConsulta = dataConsulta;
	}

}
