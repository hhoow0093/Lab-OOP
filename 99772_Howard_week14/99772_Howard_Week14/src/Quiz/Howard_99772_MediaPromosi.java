package Quiz;

abstract class Howard_99772_MediaPromosi {
    protected String nama;
    protected int harga;

    public Howard_99772_MediaPromosi(String nama, int harga) {
        this.nama = nama;
        this.harga = harga;
    }

    public String getNama() {
        return nama;
    }

    public int getHarga() {
        return harga;
    }

    public abstract int hitungHarga(String bidangOrder, int hari);
}