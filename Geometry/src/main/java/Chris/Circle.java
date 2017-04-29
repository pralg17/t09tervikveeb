package Chris;

public class Circle{
	
	double radius;
	
	public Circle(double radius){
		
		this.radius = radius;
		
	}
	
	
	public double shapeArea(){
		
		return Math.round(Math.PI * radius * radius);
		
	}
	
	public double shapePerimeter(){
		
		return Math.round(2 * Math.PI * radius);
		
	}
}