package randotm;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="data")
public class Db{
  @Id
  public int id;
  public float temper;
  public String moment;
}
