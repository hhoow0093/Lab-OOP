package Tugas;

public class Persegi extends Shape{
	private double length;
	
	public Persegi() {}
	public Persegi(String color, double panjang) {
		super(color);
		this.length = panjang;
	}
	
	public double getPanjangSisi() {
		return this.length;
	}
	
	public double getKelilingPersegi() {
		return 4 * this.length;
	}
	
	public double getLuas() {
		return this.length * this.length;
	}

}
