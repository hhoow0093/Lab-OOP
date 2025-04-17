package Tugas;

public class Barang {
    protected int id;
    protected double harga;
    protected String nama;
    protected int stock;

    public Barang(int id, double harga, String nama, int stock) {
        this.id = id;
        this.harga = harga;
        this.nama = nama;
        this.stock = stock;
    }

    public int getId() {
        return this.id;
    }

    public String getNama() {
        return this.nama;
    }

    public double getHarga() {
        return this.harga;
    }

    public int getStock() {
        return this.stock;
    }

    public int minusStock(int jumlah){
        this.stock = this.stock - jumlah;
        return this.stock;   
    }

}
