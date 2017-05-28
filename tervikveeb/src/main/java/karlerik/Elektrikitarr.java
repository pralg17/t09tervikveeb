package karlerik;

import java.text.DecimalFormat;

public class Elektrikitarr {
	
	int currentProductAmount;
	
	public Elektrikitarr(String currentProductAmount) {
		this.currentProductAmount = Integer.parseInt(currentProductAmount);
	}
	
	String guitarName = "Vintage - V100WR";
	double price = 500;
	double weight = 4;
	
	double totalPrice = 0;
	double totalWeight = 0;
	
	
	public double calculatePrice() {
		
		if(currentProductAmount <= 2) {
			double basePrice = price * currentProductAmount;
			totalPrice = basePrice;
			return basePrice;
			
		}
		
		if(currentProductAmount > 2) {
			double basePrice = (price * currentProductAmount) - ((price * currentProductAmount) / 10);
			totalPrice = basePrice;
			return basePrice;
		}
		
		return 0;
	}
	
	public double calculateWeight() {
		double baseWeight = weight * currentProductAmount;
		totalWeight = baseWeight;
		return baseWeight;
	}
	
	String pricetoString() {
		
		DecimalFormat format = new DecimalFormat("0.00");
		return "<tr><td>" + guitarName + "</td><td>" + String.valueOf(currentProductAmount) + 
			   "</td><td>" + format.format(calculatePrice()) + "</td><td>" + format.format(calculateWeight()) + "</td></tr>";
	}
	
}