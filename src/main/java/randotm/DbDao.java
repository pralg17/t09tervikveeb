package randotm;
import javax.transaction.Transactional;
import org.springframework.data.repository.CrudRepository;
@Transactional
public interface DbDao extends CrudRepository<Db, String> {
   public Db findByMoment(String moment);
}
