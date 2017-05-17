package baas;

import javax.transaction.Transactional;
import org.springframework.data.repository.CrudRepository;
@Transactional
public interface ProtsentData extends CrudRepository<Protsent, String>{
}
