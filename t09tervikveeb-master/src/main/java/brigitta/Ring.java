package brigitta;

public class Ring extends Kujundid{

	double raadius;

	public Ring(double raadius){

		this.raadius = raadius;

	}


	@Override
	public double kujundiPindala(){

		return Math.PI * raadius * raadius;

	}

	@Override
	public double kujundiYmberm66t(){

		return 2 * Math.PI * raadius;

	}
}
