package org.lessons.java.inheritance.shop;

import java.util.Scanner;

public class Carrello {
	
	public static void main(String[] args) {

		final int PRODUCT_COUNT = 5;
		boolean smartTV= false;
		boolean wireless = false;
		String strImei = null;
		int intMemory = 0;
		int intTvInch = 0;
		String strColor= null;	
		boolean fidelity = false;
		int i = 0;
		Prodotto[] products = new Prodotto[PRODUCT_COUNT];
		double sum = 0;
		
		Scanner in = new Scanner(System.in);
		System.out.print("possiedi la carta fedeltà? ");
		String strFidelity = in.nextLine();
		if(strFidelity.equals("si")) {
			fidelity = true;
		}
		
		while(true) {
			
			
			System.out.print("\n" + "vuoi aggiungere un prodotto? ");
			String strAddProduct= in.nextLine();
			 
			if(!strAddProduct.equals("si")) {
				in.close();
				break;
			}
			
			
			
			System.out.print("che tipologia di prodotto? (smartphone/televisore/cuffie): ");
			String strType = in.nextLine();
			
			System.out.print("quale e' il nome del prodotto? ");
			String strNameProduct = in.nextLine();
			
			System.out.print("descrizione prodotto: ");
			String strDescriptionProduct = in.nextLine();
			
			System.out.print("prezzo del prodotto? ");
			String strPriceProduct = in.nextLine();
			float intPriceProduct = Float.valueOf(strPriceProduct);
			
			
			
			if(strType.equals("smartphone")) {
				System.out.print("inserisci codice IMEI: ");
				strImei = in.nextLine();
				
				System.out.print("grandezza memoria smartphone: ");
				String strMemory = in.nextLine();		
				intMemory = Integer.valueOf(strMemory);
				
			}else if(strType.equals("televisore")) {
				System.out.print("e' una smartTV? si/no: ");
				String strSmartTV = in.nextLine();
				
				if(strSmartTV.equals("si")) {
					smartTV = true;
				}
				
				System.out.print("dimensioni in pollici dello schermo: ");
				String strTvInch = in.nextLine();
				intTvInch = Integer.valueOf(strTvInch);
				
			}else if(strType.equals("cuffie")) {
				System.out.print("colore: ");
				strColor = in.nextLine();
				
				System.out.print("sono wireless? si/no: ");
				String strWireless = in.nextLine();
				
				if(strWireless.equals("si")) {
					wireless = true;
				}
			}
			
			
			
			  String CapitalizedProductType = strType.substring(0, 1).toUpperCase() + strType.substring(1).toLowerCase();
			  
			  switch (CapitalizedProductType) {
				case "Smartphone": {
					
					products[i] = new Smartphone(strNameProduct, strDescriptionProduct, intPriceProduct,fidelity,  intMemory, strImei);
					i++;
					break;
				}
				case "Televisore": {
					products[i] = new Televisori(strNameProduct, strDescriptionProduct, intPriceProduct, fidelity,  smartTV, intTvInch);
					i++;
					break;
				}
				case "Cuffie":{
					products[i] = new Cuffie(strNameProduct, strDescriptionProduct, intPriceProduct, fidelity,  wireless, strColor);
					i++;
					break;
				}
				default:
					throw new IllegalArgumentException("Unexpected value: " + CapitalizedProductType);
					
				}
			
				
	  
			}
		
		  for (int j = 0; j<i; j++) {
	            System.out.println(products[j] + "\n");
	          if(fidelity==true) {
	        	  sum += products[j].getDiscountedPrice();
	        	  System.out.println("il totale del carrello e': " + String.format("%.2f", sum)+ "€");
	          }else {
	        	  sum += products[j].getFullPrice();
	        	  System.out.println("il totale del carrello e': " + String.format("%.2f", sum)+ "€");
	          }
	        }
		  
	}
		
}
