package Tugas;

public class PersegiPanjang extends Shape{
	private double panjang;
	private double lebar;
	
	public PersegiPanjang() {}
	public PersegiPanjang(String warna, double panjang, double lebar) {
		super(warna);
		this.panjang = panjang;
		this.lebar = lebar;
	}
	
	public double getPanjang() {
		return this.panjang;
	}
	
	public double getLebar() {
		return this.lebar;
	}
	
	public double getKeliling() {
		return 2 * this.lebar + 2 * this.panjang;
	}
	
	public double getLuas() {
		return this.lebar * this.panjang;
	}

}
