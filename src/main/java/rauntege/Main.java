package rauntege;

public class Main{
	public static void main(String[] args){
		
		//Tekitan uue joogi
		Jook jo1 = new Jook("Vesi", 500, 0.5);
		
		//Tekitan uue pudeli, mis sisaldab jooki
		Joogipudel pu1 = new Joogipudel("Purk", 500, 10, 0.10, null);
		
		//Käsklus joogipudeli täitmiseks
		pu1.sisu=jo1;

		//Trüki välja joogipudeli massi koos joogiga ja omahinna koos pandiga
		System.out.println("Jooipudeli mass koos joogiga oleks " + (jo1.erikaal+pu1.mass) + "g ja omahinnaks oleks " + (((jo1.omahind/1000)*jo1.erikaal) + pu1.pant));		
	}
}

/**
* scl enable rh-maven33 bash
* mvn package
* java -jar target/turva-1.jar
* localhost:2171/algus
*/

