package Johan;

public abstract class ruumala {
	double h; 
	public ruumala(double korgus) {
		h=korgus;
	}	
	public abstract double Ringipindala();
	public double silindriRuumala() {
		return 3.14*h*Ringipindala();
	}
}