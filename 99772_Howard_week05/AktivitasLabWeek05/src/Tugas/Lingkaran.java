package Tugas;

public class Lingkaran extends Shape {
	private double Radius;
	public Lingkaran() {}
	
	public Lingkaran(String color, double radius) {
		super(color);
		this.Radius = radius;
	}
	
	public double getArea() {
		return 2 * Math.PI * this.Radius;
	}
	
	public double getPerimeter() {
		return Math.PI * this.Radius * this.Radius; 
	}
	
	public double getRadius() {
		return this.Radius;
	}

}
