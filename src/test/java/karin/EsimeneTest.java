package karin;

import org.junit.*;
import static org.junit.Assert.*;

public class EsimeneTest{

    @Test
    public void test1(){
        assertEquals(3, 2+1);
    }
     
   @Test                            
    public void test2(){
		Jook segumahl = new Jook("Segumahl", 1.1);
		segumahl.erikaal = 0.9;
		Joogipudel pudel1 = new Joogipudel(0.7, 0.2, 0.1);
		pudel1.joogike = segumahl;
		assertEquals("Segumahl", segumahl.nimetus);
		assertEquals(0.7, pudel1.mahutavus, 0.01);   //delta double puhul l6ppu
		assertEquals( 0.87,pudel1.komplektiHind(), 0.01);
		
	}

	@Test                            
    public void test3(){
		Jook õlu = new Jook("6lu", 0.8);
		Joogivaat vaat = new Joogivaat(500);
		vaat.j = õlu;
		vaat.jookiVaadis = 250;
		assertEquals(250,vaat.villiK6ik(1, 0.1, 0.1));	
	}
	
	@Test                            
    public void test4(){
		Kast kast = new Kast(5, 1.5, 10);   //hind, kaal, mahutab
		Jook kali = new Jook("Kali", 0.4);  //nimi, hind
		Joogivaat vaat = new Joogivaat(300);
		vaat.j = kali;
		vaat.jookiVaadis = 300;
		Joogipudel[] pMassiiv = new Joogipudel[10];
		for(int i = 0; i < pMassiiv.length; i++){
			pMassiiv[i] = new Joogipudel(1.5, 0.1, 0.2); //mahutavus, kaal, taaraHind
		}
		kast.pudelid = pMassiiv;
		assertEquals(2.50,kast.kastiKoguMass(),0.01);	//kasti kaal tyhjade pudelitega
		assertEquals(7.0,kast.kastit2ieOmahind(), 0.01); //kasti hind tyhjade pudelitega
		kast.t2idaKast(vaat);
		assertEquals(17.50,kast.kastiKoguMass(),0.01);	//kasti kaal t2idetud pudelitega
		assertEquals(13.0,kast.kastit2ieOmahind(), 0.01); //kasti hind t2idetud pudelitega
	}
	

}