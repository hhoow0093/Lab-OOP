package Tugas;

public class Barang {
	private int id, stock, harga;
	private String nama;
	
	public Barang(int id, int stock, int harga, String nama) {
		this.id = id;
		this.stock = stock;
		this.harga = harga;
		this.nama = nama;
	}
	
	public int getid() {
		return this.id;
	}
	
	public int getstock() {
		return this.stock;
	}
	
	public int harga() {
		return this.harga;
	}
	
	public String getnama() {
		return this.nama;
	}
	
	public void minusStock(int stock, int jumlah) {
		this.stock = stock - jumlah;
		
	}
	

}
