package karlerik;

import java.text.DecimalFormat;

public class Tooted {
	
	
	String products;
	String productList = "";
	String currentProduct = "";
	String currentProductList = "";
	String currentProductAmount = "";
	double finalPrice = 0;
	double finalWeight = 0;
	int finalProductAmount = 0;
	
	DecimalFormat format = new DecimalFormat("0.00");
	
	public Tooted(String products) {
		this.products = products;
	}
	
	
	public String toString() {
		
		for(int i = 0; i < products.length(); i++) {
			
			currentProduct = products.substring(i, i+1);
			
			if(currentProduct.equals("a")) {
				currentProductAmount = products.substring(i+1, i+2);
				Elektrikitarr elektrikitarr = new Elektrikitarr(currentProductAmount);
				productList += elektrikitarr.pricetoString();
				finalPrice += elektrikitarr.totalPrice;
				finalWeight += elektrikitarr.totalWeight;
				finalProductAmount += elektrikitarr.currentProductAmount;
			}
			
			if(currentProduct.equals("b")) {
				currentProductAmount = products.substring(i+1, i+2);
				Kitarrikeeled kitarrikeeled = new Kitarrikeeled(currentProductAmount);
				productList += kitarrikeeled.pricetoString();
				finalPrice += kitarrikeeled.totalPrice;
				finalWeight += kitarrikeeled.totalWeight;
				finalProductAmount += kitarrikeeled.currentProductAmount;
			}
			
			if(currentProduct.equals("c")) {
				currentProductAmount = products.substring(i+1, i+2);
				Medikas medikad = new Medikas(currentProductAmount);
				productList += medikad.pricetoString();
				finalPrice += medikad.totalPrice;
				finalWeight += medikad.totalWeight;
				finalProductAmount += medikad.currentProductAmount;
			}
			
		}
		
		String tableHead = "<tr><th>Toode</th><th>Kogus</th><th>Hind</th><th>Kaal</th></tr>";
		String tableTail = "<tr><th>Kokku</th><th>" + String.valueOf(finalProductAmount) +
						   "</th><th>" + format.format(finalPrice) + "</th><th>" + format.format(finalWeight) + "</th></tr>";
		return tableHead + productList + tableTail;
	}
	
	
}