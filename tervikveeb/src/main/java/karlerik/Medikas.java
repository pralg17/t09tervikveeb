package karlerik;

import java.text.DecimalFormat;

public class Medikas {
	
	int currentProductAmount;
	
	public Medikas(String currentProductAmount) {
		this.currentProductAmount = Integer.parseInt(currentProductAmount);
	}
	
	String pickName = "dAndrea - Formula Delrex 1.0mm 12xPick Set";
	double price = 5;
	double weight = 0.05;
	
	double totalPrice = 0;
	double totalWeight = 0;
	
	
	public double calculatePrice() {
		
		if(currentProductAmount <= 5) {
			double basePrice = price * currentProductAmount;
			totalPrice = basePrice;
			return basePrice;
			
		}
		
		if(currentProductAmount > 5) {
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
		return "<tr><td>" + pickName + "</td><td>" + String.valueOf(currentProductAmount) + 
			   "</td><td>" + format.format(calculatePrice()) + "</td><td>" + format.format(calculateWeight()) + "</td></tr>";
	}
	
}