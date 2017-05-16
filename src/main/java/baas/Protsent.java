package baas;

import javax.persistence.*;


@Entity
@Table(name="protsendid")
public class Protsent{
	@Id
  @GeneratedValue
  private Integer id;
	public String isend;
	public double protsent;


	public Protsent(String isend, double protsent){
		this.isend = isend;
  	this.protsent = protsent;
	}

	public Protsent(){}

	public String toString(){
		return "Protsent: liiginimi: " + isend + ", veeprotsent: " + protsent + "]";
	}
}
