package edgar;

public class Tetraedr extends Kolmnurk{
	
	double a;
	
	public Tetraedr(double a){
		super(a);
		this.a = a;
		
	}
	
	public double TetraedriRuumala(){
		double ruumala = (Math.pow(pikkus,3) / 12) * Math.sqrt(2);
		return ruumala;
	}
}