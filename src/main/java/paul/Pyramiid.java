package paul;

public class Pyramiid extends PyramiidiRuumala {
	double a;
	public Pyramiid(double alus, double k6rgus) {
		super(k6rgus);
		a=alus;


	}
	@Override
	public double pyramiidip6hjaPindala() /*Ruut on p6hjaks*/{
		return Math.pow(a, 2) ;
	}
}