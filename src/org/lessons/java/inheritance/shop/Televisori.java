package org.lessons.java.inheritance.shop;

public class Televisori extends Prodotto{
	private boolean smart;
	private int size;
	
	public Televisori(String name, String description, float price,boolean fidelity, boolean smart, int size) {
		super(name, description, price, fidelity);
		
		setSmart(smart);
		setSize(size);
	}
	
	public boolean isSmart() {
		return smart;
	}
	
	public void setSmart(boolean smart) {
		this.smart = smart;
	}

	public int getSize() {
		return size;
	}

	public void setSize(int size) {
		this.size = size;
	}
	
	@Override
	public String toString() {
		
		return super.toString() + "\n"
				+ "smart TV: " + (isSmart() ? "si" : "no") + "\n"
				+ "dimensioni schermo: " + getSize() + " pollici\n"
				+ "---------------------------\n";
	}
	
}
