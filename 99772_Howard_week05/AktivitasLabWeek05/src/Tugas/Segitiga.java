package Tugas;

public class Segitiga extends Shape {
	private double alas;
	private double tinggi;
	
	public Segitiga() {}
	
	public Segitiga(String warna, double alas, double tinggi) {
		super(warna);
		this.alas = alas;
		this.tinggi = tinggi;
	}
	
	public double getAlas() {
		return this.alas;
	}
	
	public double getTinggi() {
		return this.tinggi;
	}
	
	public double getKelilingSegitigas() {
		double hypotenuse = Math.sqrt(Math.pow(this.alas, 2) + Math.pow(this.tinggi, 2));
		return hypotenuse + this.alas + this.tinggi;
	}
	public double getLuasSegitiga() {
		return 0.5 * this.alas * this.tinggi;
	}

}
