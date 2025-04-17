package Aktivitas;

public class Circle extends Shape {
	private double radius;
	
	public Circle() {}
	public Circle(double radius, String color) {
		super(color);
		this.radius = radius;
	}
	
	public double getRadius() {
		return this.radius;
	}
	
	public double getArea() {
		return Math.PI * this.radius * this.radius;
	}
	
	public double getPerimeter() {
		return Math.PI * 2 * this.radius;
	}
	

}
