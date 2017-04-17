package kent;

public class Kera extends Ring{

	double korgus;

	public Kera(double raadius){

		super(raadius);

	}

  public double KujundiRuumala(){

		return 4/3 * Math.PI * raadius * raadius * raadius;

	}

}
