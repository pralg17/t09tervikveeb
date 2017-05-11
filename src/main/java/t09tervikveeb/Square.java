package t09tervikveeb;


public class Square{

	private double side; //külg
	private double surface_area; //pindala
	private double perimeter; //ümbermõõt

	public Square(double side, double surface_area, double perimeter) {
		this.side = side;
		this.surface_area = side*side;
		this.perimeter = side * 4.0;
	}

	public double getSide() {
		return side;
	}

	public double getSurface_area() {
		return surface_area;
	}

	public double getPerimeter() {
		return perimeter;
	}
}
