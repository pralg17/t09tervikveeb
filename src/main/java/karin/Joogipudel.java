package karin;
public class Joogipudel{
	double mahutavus;     // 0.5 l
	String pudelityyp;    
	double mass;
	double taaraHind;
	Jook joogike;
	
	public Joogipudel(){}
	
	public Joogipudel(double mahutavus, double mass, double taaraHind){
		this.mahutavus = mahutavus;
		this.mass = mass;
		this.taaraHind = taaraHind;
	}
	
	public double pudeliMass(){
		double m = mass;
		if(joogike != null){
			m = mass + mahutavus * joogike.erikaal;
		}
		return m;		
		
	}
	
	public double komplektiHind(){
		double komplektiHind = taaraHind;
		if(joogike != null){
			komplektiHind += mahutavus * joogike.omahind;
		}
		return komplektiHind;
	}
}


