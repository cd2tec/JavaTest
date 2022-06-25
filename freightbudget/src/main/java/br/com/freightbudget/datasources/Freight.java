package br.com.freightbudget.datasources;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

public class Freight {
	private int id;
	private double pound;
	private String postalCodeOrigin;
	private String postalCodeDestin;
	private String name;
	private double preco;
	private int prazo;
	private Date timestamp;

	public Freight(double pound, String postalCodeOrigin, String postalCodeDestin, String name) {
		super();
		this.pound = pound;
		this.postalCodeOrigin = postalCodeOrigin;
		this.postalCodeDestin = postalCodeDestin;
		this.name = name;
		this.preco = 0;
		this.prazo = 0;
		this.timestamp = new Date ();
	}	

	public long getId() {
		return id;
	}

	public double getPound() {
		return pound;
	}

	public void setPound(double pound) {
		this.pound = pound;
	}

	public String getPostalCodeOrigin() {
		return postalCodeOrigin;
	}

	public void setPostalCodeOrigin(String postalCodeOrigin) {
		this.postalCodeOrigin = postalCodeOrigin;
	}

	public String getPostalCodeDestin() {
		return postalCodeDestin;
	}

	public void setPostalCodeDestin(String postalCodeDestin) {
		this.postalCodeDestin = postalCodeDestin;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getPreco() {
		return preco;
	}
	
	public void setPreco(double preco) {
		this.preco = preco;
	}

	public int getPrazo() {
		return prazo;
	}

	public void setPrazo(int prazo) {
		this.prazo = prazo;
	}

	public Date getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(Date timestamp) {
		this.timestamp = timestamp;
	}

	public String getFormatedTimestamp() {
		SimpleDateFormat dateFormat = new SimpleDateFormat ("dd/MM/yyyy-HH:mm:ss");
		return dateFormat.format(this.timestamp);
	}
	
	public String getDelliveryEstimated () {
		SimpleDateFormat dateFormat = new SimpleDateFormat ("dd/MM/yyyy");
		Calendar cal = Calendar.getInstance(); 
		cal.setTime(this.timestamp);
		cal.add(Calendar.DAY_OF_MONTH, this.prazo);
		return dateFormat.format(cal.getTime());
	}

}
