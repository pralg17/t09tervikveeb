package t09tervikveeb;

// Kolmnurgad on võrdhaarsed kolmnurgad.

public class Kolmnurk{
	private double alus; 
	private double kulg; 
	private double korgus; 
	private double pindala; 
	private double umbermoot; 

	public Kolmnurk(double alus, double kulg, double korgus, double pindala, double umbermoot) {
		this.alus = alus;
		this.kulg = kulg;
		this.korgus = Math.sqrt((Math.pow(kulg, 2) - Math.pow((2 / alus), 2)));
		this.pindala = (alus*korgus)/2;
		this.umbermoot = (2*kulg)+alus;
	}


	public double getAlus() {
		return alus;
	}

	public double getKulg() {
		return kulg;
	}

	public double getKorgus() {
		return korgus;
	}

	public double getPindala() {
		return pindala;
	}

	public double getUmbermoot() {
		return umbermoot;
	}
}
