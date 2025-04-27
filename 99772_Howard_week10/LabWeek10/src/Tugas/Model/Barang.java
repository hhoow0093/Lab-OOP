package Tugas.Model;

import java.util.ArrayList;

public class Barang {
    protected String id;
    protected double harga;
    protected String nama;
    protected int stock;
    private ArrayList<Handphone> ListHandphone = new ArrayList<>();
    private ArrayList<Voucher> vouchers = new ArrayList<>();

    public Barang(String id, double harga, String nama, int stock) {
        this.id = id;
        this.harga = harga;
        this.nama = nama;
        this.stock = stock;
    }

    public Barang(ArrayList<Voucher> voucher_list, ArrayList<Handphone> phone_list) {
        this.ListHandphone = phone_list;
        this.vouchers = voucher_list;
    }

    public String getId() {
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

    public int minusStock(int jumlah) {
        this.stock = this.stock - jumlah;
        return this.stock;
    }
    
    public void addVoucher(Voucher newVoucher) {
        vouchers.add(newVoucher);
    }

    public ArrayList<Handphone> get_all_handphone() {
        return this.ListHandphone;
    }

    public ArrayList<Voucher> get_all_voucher() {
        return this.vouchers;
    }

    public void addHandphone(Handphone newHandphone) {
        ListHandphone.add(newHandphone);
    }

}
