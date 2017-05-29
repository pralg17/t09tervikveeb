package sten;

public class Silinder extends SilindriRuumala {
	double r;
	public Silinder(double raadius, double k6rgus) {
		super(k6rgus);
		r=raadius;


	}
	
	@Override
 	public double Ringipindala(){
 		return Math.pow(r, 2) ;
 	}

}
