package t09tervikveeb;


public class Puramiid{
	private Ruut pohi;
	private Kolmnurk kulg;
	private double korgus;

	private double pohjapindala;
	private double kulgpindala;
	private double puramiid_pindala;
	private double puramiid_ruumala;

	// Konstruktor paneb paika kõik muutujad.
	public Puramiid(Ruut pohi, Kolmnurk kulg) {
			this.pohi = pohi;
			this.kulg = kulg;
			this.pohjapindala = pohi.getPindala();
			this.kulgpindala = 4.0 * kulg.getPindala();
			this.korgus = Math.sqrt(Math.pow(kulg.getAlus(), 2) + Math.pow(kulg.getKulg(), 2));
			this.puramiid_pindala = Math.round(pohjapindala + kulgpindala);
			this.puramiid_ruumala = Math.round(pohjapindala * (1.0 / 3) * korgus);
		}


	public double getPohjapindala() {
		return pohjapindala;
	}

	public double getKulgpindala() {
		return kulgpindala;
	}

	public double getPuramiid_pindala() {
		return puramiid_pindala;
	}

	public double getPuramiid_ruumala() {
		return puramiid_ruumala;
	}
}
