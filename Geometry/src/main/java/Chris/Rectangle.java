package Chris;
import java.util.*;

public class Rectangle{
	
	double width;
	double length;
	
	public Rectangle(double width, double length){
		
		this.width = width;
		this.length = length;
		
	}
	
	public double shapeArea(){
		
		double area = width * length;
		return area;
		
	}

	public double shapePerimeter(){
		
		double perimeter = 2 * (width + length);
		return perimeter;
		
	}
	
	
	
}