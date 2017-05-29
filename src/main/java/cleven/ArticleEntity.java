package cleven;

import javax.persistence.*;

@Table(name="article")
@Entity

public class ArticleEntity{
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	public Long id;
	public String title;
	public String category;

	public ArticleEntity(String title, String category){
		this.title=title;
		this.category=category;
	}
	
}