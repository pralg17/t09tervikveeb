package karin;
public class Joogivaat{
	double ruumala;    //kokku mahub
	double jookiVaadis; //palju vaadis
	Jook j;
	
	public Joogivaat(double ruumala){
		this.ruumala = ruumala;
	}
	
	public Joogipudel t2idaPudel(Joogipudel pudel){
		if(pudel.joogike != null){
			return null;
		}
		if(jookiVaadis >= pudel.mahutavus){
			jookiVaadis = jookiVaadis - pudel.mahutavus;
			pudel.joogike = j;
			return pudel;
		}
		return null;	
	}
	
	public int villiK6ik(double pudelimaht, double pudelimass, double taaraHind){
		int loendaPudeleid = 0;
		if(j != null){
			while (jookiVaadis >= pudelimaht){
				Joogipudel uuspudel = new Joogipudel(pudelimaht, pudelimass, taaraHind);    //(maht, mass, taaraHind)
				t2idaPudel(uuspudel);
				loendaPudeleid ++;
			}
		} 
		return loendaPudeleid;
	}
	
}

