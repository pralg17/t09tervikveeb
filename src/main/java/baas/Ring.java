package baas;

public class Ring extends Kujundid{

	double radius;

	public Ring(double radius){

		this.radius = radius;

	}


	@Override
	public double kujundiPindala(){

		return Math.PI * radius * radius;

	}

	@Override
	public double kujundiUmbermoot(){

		return 2 * Math.PI * radius;

	}
}