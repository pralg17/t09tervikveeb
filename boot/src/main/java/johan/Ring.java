package johan;

public class Ring extends Kujundid{
	double diameeter;
	
	public Ring(double diameeter){
		this.diameeter = diameeter;
	}
	
	@Override
	public double KujundiPindala(){
		return Math.PI * ((diameeter/2)*(diameeter/2));
	}
	
	@Override
	public double KujundiYmberm66t(){
		return Math.PI * diameeter;
	}
}