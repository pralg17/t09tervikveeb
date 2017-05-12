package kuznetsovatatjana;

import javax.transaction.Transactional;
import org.springframework.data.repository.CrudRepository;
@Transactional
public interface VarviHaldur extends CrudRepository<Varvid, String>{
		
}