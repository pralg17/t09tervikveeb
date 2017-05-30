package Johan;

public class silinder extends ruumala {
	double r;
	public silinder(double raadius, double korgus) {
		super(korgus);
		r=raadius;
	}
	
	@Override
 	public double Ringipindala(){
 		return Math.pow(r, 2) ;
 	}
}