package br.com.freightbudget.basic;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class Freight {
	private int id;
	private double pound;
	private String postalCodeOrigin;
	private String postalCodeDestin;
	private String name;
	private double price;
	private int deadlineDays;
	private Date timestamp;

	public Freight(double pound, String postalCodeOrigin, String postalCodeDestin, String name) {
		super();
		this.pound = pound;
		this.postalCodeOrigin = postalCodeOrigin;
		this.postalCodeDestin = postalCodeDestin;
		this.name = name;
		this.price = 0;
		this.deadlineDays = 0;
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

	public double getPrice() {
		return price;
	}
	
	public void setPreco(double price) {
		this.price = price;
	}

	public int getDeadlineDays() {
		return deadlineDays;
	}

	public void setDeadlineDays(int deadlineDays) {
		this.deadlineDays = deadlineDays;
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
		cal.add(Calendar.DAY_OF_MONTH, this.deadlineDays);
		return dateFormat.format(cal.getTime());
	}

}
