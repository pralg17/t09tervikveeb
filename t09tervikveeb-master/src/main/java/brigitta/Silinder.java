package brigitta;

public class Silinder extends Ring{

	double k6rgus;
	double raadius;

	public Silinder(double k6rgus, double raadius){

		super(raadius);
		this.k6rgus = k6rgus;

	}

	public double kujundiRuumala(){

		return kujundiPindala()/3 * k6rgus;

	}

}

/*
java -jar target/app-1.jar
*/
