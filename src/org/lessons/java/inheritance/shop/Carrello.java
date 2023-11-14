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
		int i = 0;	
		Prodotto[] products = new Prodotto[PRODUCT_COUNT];
		
		
		while(true) {
			
			Scanner in = new Scanner(System.in);
			System.out.print("\n" + "vuoi aggiungere un prodotto? ");
			String strAddProduct= in.nextLine();
			 
			if(strAddProduct.equals("no")) break;
			
			
			
			System.out.print("che tipologia di prodotto? (smartphone/televisore/cuffie)");
			String strType = in.nextLine();
			
			System.out.print("quale e' il nome del prodotto? ");
			String strNameProduct = in.nextLine();
			
			System.out.print("descrizione prodotto: ");
			String strDescriptionProduct = in.nextLine();
			
			System.out.print("prezzo del prodotto? ");
			String strPriceProduct = in.nextLine();
			int intPriceProduct = Integer.valueOf(strPriceProduct);
			
			if(strType.equals("smartphone")) {
				System.out.print("inserisci codice IMEI: ");
				strImei = in.nextLine();
				
				System.out.print("grandezza memoria smartphone: ");
				String strMemory = in.nextLine();		
				intMemory = Integer.valueOf(strMemory);
				
			}else if(strType.equals("televisore")) {
				System.out.print("e' una smartTV? si/no");
				String strSmartTV = in.nextLine();
				
				if(strSmartTV.equals("si")) {
					smartTV = true;
				}
				
				System.out.println("dimensioni in pollici dello schermo: ");
				String strTvInch = in.nextLine();
				intTvInch = Integer.valueOf(strTvInch);
				
			}else if(strType.equals("cuffie")) {
				System.out.print("colore: ");
				strColor = in.nextLine();
				
				System.out.print("sono wireless? si/no");
				String strWireless = in.nextLine();
				
				if(strWireless.equals("si")) {
					wireless = true;
				}
			}
			
			in.close();
			
			  String CapitalizedProductType = strType.substring(0, 1).toUpperCase() + strType.substring(1).toLowerCase();
			  
			  switch (CapitalizedProductType) {
				case "Smartphone": {
					
					products[i] = new Smartphone(strNameProduct, strDescriptionProduct, intPriceProduct, intMemory, strImei);
					break;
				}
				case "Televisore": {
					products[i] = new Televisori(strNameProduct, strDescriptionProduct, intPriceProduct, smartTV, intTvInch);
					break;
				}
				case "Cuffie":{
					products[i] = new Cuffie(strNameProduct, strDescriptionProduct, intPriceProduct, wireless, strColor);
					break;
				}
				default:
					throw new IllegalArgumentException("Unexpected value: " + CapitalizedProductType);
				}

			}
		 
		for (i = 0; i <PRODUCT_COUNT; i++) {
	            System.out.println(products[i] + "\n");
	        }
		  
		  
	}
}