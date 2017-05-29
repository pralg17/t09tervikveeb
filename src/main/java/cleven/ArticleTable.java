package cleven;

import java.util.*;
import javax.transaction.Transactional;
import org.springframework.data.repository.CrudRepository;

@Transactional
public interface ArticleTable extends CrudRepository<ArticleEntity, Long> {
	List<ArticleEntity> findByCategory(String category);
}