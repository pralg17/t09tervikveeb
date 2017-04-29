package Chris;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.beans.factory.annotation.Autowired;

@RestController
@SpringBootApplication
public class GeometryApplication {
	
	@RequestMapping("/Rectangle")
	public String RectangleCalculations(double height, double width){
		
		Rectangle rectangle = new Rectangle(height, width);
		return "Area: " + rectangle.shapeArea() + "<br>" + "Perimeter: " + rectangle.shapePerimeter();
		
	}
	
	@RequestMapping("/Triangle")
	public String TriangleCalculations(double side1, double side2, double side3){
		
		Triangle triangle = new Triangle(side1, side2, side3);
		return "Area: " + triangle.shapeArea() + "<br>" + "Perimeter: " + triangle.shapePerimeter();
		
	}
	
	@RequestMapping("/Circle")
	public String CircleCalculations(double radius){
		
		Circle circle = new Circle(radius);
		return "Area: " + circle.shapeArea() + "<br>" + "Perimeter: " + circle.shapePerimeter();
		
	}
	
	

	public static void main(String[] args) {
		System.getProperties().put("server.port", 4215);
		SpringApplication.run(GeometryApplication.class, args);
	}
}
