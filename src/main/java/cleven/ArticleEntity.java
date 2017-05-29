package cleven;

import javax.persistence.*;

@Entity
@Table(name="article")

public class ArticleEntity{
	@Id
	public String title;
	public String category;
	
	public ArticleEntity(){
		
	}

	public ArticleEntity(String title, String category){
		this.title=title;
		this.category=category;
	}
	
}