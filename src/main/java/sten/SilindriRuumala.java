package sten;

public abstract class SilindriRuumala {
	double h; 
	public SilindriRuumala(double k6rgus) {
		h=k6rgus;
	}
	
	public abstract double Ringipindala();
	public double silindriRuumala() {
		return 3.14*h*Ringipindala();
	}
}