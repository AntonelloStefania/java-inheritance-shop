package org.lessons.java.inheritance.shop;


public class Cuffie extends Prodotto{
	private boolean cable;
	private String color;



	public Cuffie(String name, String description, float price, boolean cable, String color) {
		super(name, description, price);
		
		setCable(cable);
		setColor(color);
	}

	public boolean isCable() {
		return cable;
	}

	public void setCable(boolean cable) {
		this.cable = cable;
	}
	
	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}
	
	@Override
	public String toString() {
		
		return super.toString() + "\n"
				+ "colore: " + getColor() + "\n"
				+ "wireless: " + isCable()+ "\n"
				+ "---------------------------\n";
	}
}
