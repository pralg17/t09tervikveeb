package cleven;

import javax.transaction.Transactional;
import org.springframework.data.repository.CrudRepository;
@Transactional
public interface ArticleTable extends CrudRepository<ArticleEntity, String>{
		
}