package matu;

public class Kera extends Kerapind {
	double r;
	public Kera(double raadius, double konstant) {
		super(konstant);
		r=raadius;
	}
	@Override
	public double ringiPindala() {
		return 4*Math.PI*Math.pow(r, 2);
	}
}