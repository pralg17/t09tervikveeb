package cleven;

public class aine{
	
	ioon i1;
	ioon i2;
	String nimetus;
	double molekulmass;
	
	public aine(ioon uus_i1, ioon uus_i2){
		i1=uus_i1;
		i2=uus_i2;
		
		if(i1.laeng + i2.laeng == 0){
			if(i1.laeng > i2.laeng){
				nimetus = i1.nimetus + i2.nimetus;
			}else{
				nimetus = i2.nimetus + i1.nimetus;
			}
		}else{
			nimetus = "null";
		}
		molekulmass = i1.aatommasside_summa + i2.aatommasside_summa;
	}   
}