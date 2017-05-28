package heino;

import javax.persistence.*;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "menyy")

public class Toidud {
	@Id
	@GeneratedValue
	public Integer id;
	public String toidu_nimetus;
	public String toidu_tyyp;
	public Double hind;
	public Toidud(){

	}


	public Toidud(Integer id, String toidu_nimetus, String toidu_tyyp, double hind) {
			this.id = id;
			this.toidu_nimetus = toidu_nimetus;
			this.toidu_tyyp = toidu_tyyp;
			this.hind = hind;


	}

	@Override
    public String toString() {
        return "<tr><td>" + id + "</td><td>" + toidu_nimetus + "</td><td>" + toidu_tyyp + "</td><td>" + hind +
		"</td><td>";
    }


}
