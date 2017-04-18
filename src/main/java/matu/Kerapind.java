package matu;

public abstract class Kerapind {
	double k; //konstant = 4/3
	public Kerapind(double konstant) {
		k=konstant;
	}
	public abstract double ringiPindala();
	public double keraruumala() {
		return k*ringiPindala();
	}
}