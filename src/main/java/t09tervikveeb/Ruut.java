package t09tervikveeb;


public class Ruut{

	private double kulg;
	private double pindala;
	private double umbermoot;

	public Ruut(double kulg, double pindala, double umbermoot) {
		this.kulg = kulg;
		this.pindala = kulg*kulg;
		this.umbermoot = kulg * 4.0;
	}

	public double getKulg() {
		return kulg;
	}

	public double getPindala() {
		return pindala;
	}

	public double getUmbermoot() {
		return umbermoot;
	}
}
