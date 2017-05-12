package kuznetsovatatjana;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="varvid")
public class Varvid {

		@Id
		public String nimi;
		public String hexkood;
}

