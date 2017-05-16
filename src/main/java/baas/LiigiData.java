package baas;

import javax.transaction.Transactional;
import org.springframework.data.repository.CrudRepository;
import java.util.*;
@Transactional
public interface LiigiData extends CrudRepository<Isendid, String>{
  public List<Isendid> findAllByOrderByKaalAsc();
}
