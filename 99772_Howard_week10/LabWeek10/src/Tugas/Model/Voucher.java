package Tugas.Model;

public class Voucher extends Barang {

    private double pajak;
    public static int total;

    public Voucher(String id, String nama, double harga, int stock, double pajak) {
        super(id, harga, nama, stock);
        this.pajak = pajak;
    }

    public double getPajak() {
        return this.pajak;
    }

    public double getHargaJual() {
        return this.harga - this.pajak * this.harga;
    }

}
