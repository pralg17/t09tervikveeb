package johan;

public class Koonus extends Ring{
	double k6rgus;
	
	public Koonus(double diameeter, double k6rgus){
		super(diameeter);
		this.k6rgus = k6rgus;
	}
	
	public double KujundiRuumala(){
		return (KujundiPindala() * k6rgus)/2;
	}

}