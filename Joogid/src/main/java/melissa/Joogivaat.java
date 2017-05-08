package melissa;

public class Joogivaat{
	double vaadimaht;
	double taidetudmaht;
	Jook j;
	Joogipudel villi(Joogipudel pudel){
		if(pudel.j!=null){return null;} 
		if(pudel.maht<=taidetudmaht){
			taidetudmaht-=pudel.maht;
			pudel.j=j; 
			return pudel;
		}
		return null; 
	}
}