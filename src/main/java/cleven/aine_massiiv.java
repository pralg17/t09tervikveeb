package cleven;

public class aine_massiiv{
	ioon[] massiiv = new ioon[5];
	String nimetus = "";
	int laeng = 0;
	boolean loodav = true;
	double molekulmass;
	
	public aine_massiiv(ioon[] massiiv){
		this.massiiv = massiiv;
		
		for (int i=0;i<massiiv.length;i++) {
			for (int j=i+1;j<massiiv.length;j++) {
				if (massiiv[i].nimetus == massiiv[j].nimetus){
					massiiv[i].kogus+=1;
					massiiv[j].dub=true;
				}
			}
		}
		
		for (int i=0;i<massiiv.length;i++) {
			if(massiiv[i].kogus>1 && massiiv[i].dub == false){
				massiiv[i].nimetus+=Integer.toString(massiiv[i].kogus);
			}
		}
		
		for (int i=0;i<massiiv.length;i++) {
			if(massiiv[i].dub == false){
				nimetus+=massiiv[i].nimetus;
			}
		}
		
		for (int i=0;i<massiiv.length;i++) {
			laeng += massiiv[i].laeng;
			molekulmass+=massiiv[i].aatommasside_summa;
		}
		
		if (laeng != 0){loodav = false;}
	}	
}