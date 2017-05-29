package app;

class Painting extends Artist{
	String painting, genre;
	
	public Painting(){
		
	}
	
	public Painting(String lastName, String painting, String genre){
		super(lastName);
		this.painting = painting;
		this.genre = genre;
	}
	
	public String getLastName(){
		return this.lastName;
	}
	public String getPainting(){
		return this.painting;
	}
	public String getGenre(){
		return this.genre;
	}
	
	public void changePainting(String newPainting){
		this.painting = newPainting;
	}
}