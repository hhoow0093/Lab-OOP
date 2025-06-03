package Quiz;

import java.time.LocalDate;

class Howard_99772_Order {
    private Howard_99772_MediaPromosi media;
    private String bidang;
    private LocalDate tanggal;
    private int jangkaWaktu;
    private int totalBayar;

    public Howard_99772_Order(Howard_99772_MediaPromosi media, String bidang, LocalDate tanggal, int jangkaWaktu, int totalBayar) {
        this.media = media;
        this.bidang = bidang;
        this.tanggal = tanggal;
        this.jangkaWaktu = jangkaWaktu;
        this.totalBayar = totalBayar;
    }

    public boolean bisaDibatalkan(LocalDate tanggalUjian) {
        return !tanggal.equals(tanggalUjian);
    }

    public String toString() {
        return "Media: " + media.getNama() + ", Bidang: " + bidang + ", Tanggal: " + tanggal +
               ", Hari: " + jangkaWaktu + ", Total: Rp " + totalBayar;
    }
}