package baas;

import javax.persistence.*;


@Entity
@Table(name="isendid")
public class Isendid{
	@Id
  @GeneratedValue
  public Integer id;
	public String isend;
	@ManyToOne
  @JoinColumn(name = "liik")
	public Protsent liik;
	public double kaal;
  public double korgus;

	public Isendid(Protsent liik, double kaal, double korgus){
		this.liik = liik;
		this.kaal = kaal;
		this.korgus = korgus;
	}

	public Isendid(){}


	public double Kehamassiindeks(){
		return this.kaal / (this.korgus*this.korgus);
	}

	public String toString(){
		return "Isend: nimi: " + isend + ", liik: " + liik + ", kaal: " + kaal + ", korgus: " + korgus + "]";
	}
	

}
