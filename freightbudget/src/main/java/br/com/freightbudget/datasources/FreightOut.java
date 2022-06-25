package br.com.freightbudget.datasources;


public class FreightOut {
	
	public final String vlTotalFrete;
	public final String dataPrevistaEntrega;
	public final String CEPOrigem;
	public final String CEPDestino;
	
	public FreightOut(double vlTotalFrete, String dataPrevistaEntrega, String cepOrigem, String cepDestino) {
		this.vlTotalFrete = "R$" + String.format("%.2f", vlTotalFrete);
		this.dataPrevistaEntrega = dataPrevistaEntrega;
		this.CEPOrigem = cepOrigem;
		this.CEPDestino = cepDestino;
	}
	
}
