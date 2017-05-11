package karin;
public class Kast{
	String tyyp;
	double kastiHind;
	double mass;
	int mahutavus;  //palju pudeleid kasti mahub
	Joogipudel[] pudelid;
	
	public Kast(double hind, double mass, int mahutavus){
		kastiHind = hind;
		this.mass = mass;
		this.mahutavus = mahutavus;
	}
	
	public double kastiKoguMass(){    //pudelite kaal (tyhjad v t2is) + kasti kaal
		double m = mass;
		int loendur = 0;
		while (loendur <= mahutavus && loendur < pudelid.length){
			m += (pudelid[loendur].pudeliMass());
			loendur ++;
		}
		return m;
	}
	
	public double kastit2ieOmahind(){ //pudelite taarahind + kasti hind + jook pudelites
		double hind = kastiHind;
		int loendur = 0;
		while (loendur <= mahutavus && loendur < pudelid.length){
			hind+= pudelid[loendur].komplektiHind();
			loendur ++;
		}
		return hind;
	}
	
	public void t2idaKast(Joogivaat vaat){
		for(int i = 0; i < pudelid.length; i++){
			pudelid[i] = vaat.t2idaPudel(pudelid[i]);	
		}
	}
		
	
	
}

