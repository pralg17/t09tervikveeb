package karin;
public class Rakendus {
	
	public static void main(String[] args){
		Jook vein = new Jook ("Vein", 7.8);                 //nimetus, omahind
		vein.erikaal = 0.8;
		Jook segumahl = new Jook("Segumahl", 1.2);
		segumahl.erikaal = 0.9;
		
		Joogipudel pudel1 = new Joogipudel(0.7, 0.2, 0.1);   //mahutavus,mass,taaraHind
		pudel1.joogike = vein;
		pudel1.pudelityyp = "Klaas";
		
		Joogipudel pudel2 = new Joogipudel(1, 0.1, 0.1);   //mahutavus,mass,taaraHind
		pudel2.pudelityyp = "Plastik";
		
		Joogivaat vaat1 = new Joogivaat(500);    //vaadi mahutavus
		vaat1.j = vein;
		vaat1.jookiVaadis = 250;
		vaat1.t2idaPudel(pudel2);                    //tyhi pudel
		
		Kast kast1 = new Kast(15.50, 1.5, 10);   //hind, kaal, mahutab
		Joogipudel[] pMassiiv = new Joogipudel[10];
		for(int i = 0; i < pMassiiv.length; i++){
			pMassiiv[i] = new Joogipudel(0.5, 0.1, 0.1);
			vaat1.t2idaPudel(pMassiiv[i]);
		}
		
		kast1.pudelid = pMassiiv;
		System.out.println(pudel1.joogike.nimetus);  //Vein
		System.out.println(pudel1.pudeliMass());   //0.76..  pudel kaal + pudel maht* j erikaal
		System.out.println(pudel2.pudeliMass()); // 0.9
		System.out.println(pudel1.komplektiHind());  //5.56  0.1 + 5.46 (taara + 0.7 l vein)
		System.out.println("Pudelis: " + pudel2.joogike.nimetus + " komplekti hind:" 
		+ pudel2.komplektiHind());  
		System.out.println("kasti mass: " + kast1.kastiKoguMass());  //6.5
		System.out.println("kasti hind: " + kast1.kastit2ieOmahind()); //55.5
		
		
	}
	
	
	
}

//scl enable rh-maven33 bash
//mvn package
//java -jar target/joogid-1.0-SNAPSHOT.jar