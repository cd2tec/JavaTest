package br.com.freightbudget.output;

import br.com.freightbudget.basic.Freight;

public class FreightOut {
	
	public final String vlTotalFrete;
	public final String dataPrevistaEntrega;
	public final String CEPOrigem;
	public final String CEPDestino;
	
	public FreightOut(Freight freight) {
		this.vlTotalFrete = "R$" + String.format("%.2f", freight.getPrice());
		this.dataPrevistaEntrega = freight.getDelliveryEstimated();
		this.CEPOrigem = freight.getPostalCodeOrigin();
		this.CEPDestino = freight.getPostalCodeDestin();
	}
	
}
