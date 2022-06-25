package br.com.freightbudget.business;

import org.json.JSONObject;
import org.springframework.stereotype.Service;

import br.com.freightbudget.datasources.Freight;
import br.com.freightbudget.datasources.PostalCodeSearch;

@Service
public class FreightCalculus {
		
	public FreightCalculus() {
	}
	
	public void calculateDeliveryEstimated (Freight freightInput) {
		
		PostalCodeSearch postalCodeSearch = new PostalCodeSearch() ;
		
		JSONObject postalInfoOrigin = new JSONObject (postalCodeSearch.getPostalCodeInfo(freightInput.getPostalCodeOrigin()));
		JSONObject postalInfoDestin = new JSONObject (postalCodeSearch.getPostalCodeInfo(freightInput.getPostalCodeDestin()));
		
		int areaCodeOrigin = Integer.parseInt(postalInfoOrigin.getString("ddd"));
		int areaCodeDestin = Integer.parseInt(postalInfoDestin.getString("ddd"));
		String stateOrigin = postalInfoOrigin.getString("uf");
		String stateDestin = postalInfoDestin.getString("uf");
		
		double discount = 0;
		int deadlineDays = 0;
		double orderPrice = 0;
		
		if (areaCodeOrigin == areaCodeDestin) {
			discount = 0.5;
			deadlineDays = 1;
		}
		else if (stateOrigin.equals(stateDestin)) {
			discount = 0.75;
			deadlineDays = 3;
		}
		else {
			deadlineDays = 10;
		}
		
		orderPrice = (freightInput.getPound())*(1 - discount);
		
		freightInput.setPreco(orderPrice);
		freightInput.setPrazo(deadlineDays);
	}
}
