package org.lessons.java.inheritance.shop;

import java.util.Random;

public class Prodotto {
	private int code;
	private String name;
	private String description;
	private float price;
	private int iva;
	
	Random rnd = new Random();
	
	public Prodotto(String name, String description, float price) {
		code=rnd.nextInt(1000000000);
		setName(name);
		setDescription(description);
		setPrice(price);
		iva=22;
		
	}
	
	public int getCode() {
		return code;
	}
	private void setCode(int code) {
		this.code = code;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public float getPrice() {
		return price;
	}
	public void setPrice(float price) {
		this.price = price;
	}
	public int getIva() {
		return iva;
	}
	public void setIva(int iva) {
		this.iva = iva;
	}
	
	public float getFullPrice() {
		return getPrice() * (100 + iva) / 100;
	}
	public String getFormattedCode() {
		return  String.format("%09d", getCode());
	}
	
	private String getFullName() {
		return getName() + "-" + getFormattedCode();
	}
	@Override
	public String toString() {
		
		return "\nProdotto :\n"
				
				+ "nome: " + getName() + "\n"			
				+ "prezzo: " + String.format("%.02f", getPrice()) + "€\n"
				+ "iva: " + getIva() + "%\n"
				+ "il prezzo comprensivo di iva e': " + String.format("%.02f", getFullPrice()) +"€\n"
				+ "il nome completo di codice e': " + getFullName() + "\n";
	}
	
}
