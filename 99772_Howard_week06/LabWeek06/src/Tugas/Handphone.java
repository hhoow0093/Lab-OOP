package Tugas;

public class Handphone extends Barang{
    private String warna;
    public static int total;

    public Handphone(int id, String nama, double harga, int stock, String Warna) {
        super(id, harga, nama, stock);
        this.warna = Warna;
    }
    
    public String getWarna() {
        return this.warna;
    }

}
