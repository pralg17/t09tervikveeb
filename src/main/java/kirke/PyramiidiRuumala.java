package kirke;

public abstract class PyramiidiRuumala {
	double h; //k6rgus
	public PyramiidiRuumala(double k6rgus) {
		h=k6rgus;
	}
	public abstract double pyramiidip6hjaPindala();
	public double pyramiidiRuumala() {
		return 0.33333*h*pyramiidip6hjaPindala();
	}
}
