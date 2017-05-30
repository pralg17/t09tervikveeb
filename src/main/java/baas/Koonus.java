package baas;

public class Koonus extends Ring{

	double korgus;
	double radius;

	public Koonus(double korgus, double radius){

		super(radius);
		this.korgus = korgus;

	}

	public double kujundiRuumala(){

		return kujundiPindala()/3 * korgus;

	}

}
