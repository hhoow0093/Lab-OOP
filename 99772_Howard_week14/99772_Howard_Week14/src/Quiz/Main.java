package Quiz;

import java.util.*;
import java.time.LocalDate;

public class Main {
    static Scanner sc = new Scanner(System.in);
    static ArrayList<Howard_99772_MediaPromosi> mediaList = new ArrayList<>();
    static ArrayList<Howard_99772_Order> orders = new ArrayList<>();
    static final LocalDate TANGGAL_UJIAN = LocalDate.of(2025, 5, 27);
    static final String[] kategoriList = { "Furnitur", "Makanan", "Tanaman", "Otomotif", "Musik" };
    
    public static void viewMenu() {
        System.out.println("===========================");
        System.out.println("   Wemen Marketing Agent ");
        System.out.println("===========================");
        System.out.println("1. Penambahan Media");
        System.out.println("2. Penyewaan Media");
        System.out.println("3. Check Employment / Rental");
        System.out.println("4. Credits");
        System.out.println("5. Exit");
        System.out.println("===========================");
    }

    public static void main(String[] args) {
        seedData();
        int pilih = 0;
        do {
            try {
                viewMenu();
                System.out.print("Pilih Menu (1-5): ");
                pilih = sc.nextInt();
                sc.nextLine();
                System.out.println("===========================");

                switch (pilih) {
                    case 1: tambahMedia(); break;
                    case 2: sewaMedia(); break;
                    case 3: aturOrder(); break;
                    case 4: tampilkanCredits(); break;
                    case 5: break;
                    default: System.out.println("Pilihan tidak valid.");
                }
            } catch (Exception e) {
                System.out.println("Input tidak valid. Harap masukkan angka.");
            }
        } while (pilih != 5);
    }

    static void seedData() {
        mediaList.add(new Howard_99772_Aktor("Chris Evans", 30, 170, 60, 100_000, "Captain America Lovers"));
        mediaList.add(new Howard_99772_Aktor("Robert Downey Jr", 31, 171, 61, 120_000, "Ironman Lovers"));
        mediaList.add(new Howard_99772_Aktor("Chris Hemsworth", 32, 172, 62, 140_000, "Thor Lovers"));

        mediaList.add(new Howard_99772_Celebgram("Awkarin", 25, 165, 45, 100_000, "Instagram", "Furnitur"));
        mediaList.add(new Howard_99772_Celebgram("Anya Geraldine", 26, 166, 46, 120_000, "Twitter", "Makanan"));
        mediaList.add(new Howard_99772_Celebgram("Devina Aurel", 27, 167, 47, 140_000, "Youtube", "Tanaman"));

        mediaList.add(new Howard_99772_Baliho("Baliho Jakarta Pusat", 6, "Jakarta Pusat"));
        mediaList.add(new Howard_99772_Baliho("Baliho Jakarta Barat", 8, "Jakarta Barat"));
        mediaList.add(new Howard_99772_Baliho("Baliho Jakarta Utara", 9, "Jakarta Utara"));

        mediaList.add(new Howard_99772_Majalah("Home Decor", 15, "Halaman 2", "Furnitur"));
        mediaList.add(new Howard_99772_Majalah("Sedap", 18, "Halaman 3", "Makanan"));
        mediaList.add(new Howard_99772_Majalah("Otomotif", 21, "Halaman 4", "Tanaman"));
    }

    static void tambahMedia() {
        try {
            System.out.println("1. Celebgram\n2. Majalah");
            System.out.println("===========================");
            System.out.print("Pilih Media (1-2): ");
            int jenis = Integer.parseInt(sc.nextLine());
            System.out.println("===========================");
            System.out.println("Pilih Kategori:");
            for (int i = 0; i < kategoriList.length; i++) {
                System.out.println((i + 1) + ". " + kategoriList[i]);
            }
            System.out.print("Masukkan nomor kategori (1-5): ");
            int kategoriIdx = Integer.parseInt(sc.nextLine());
            String kategori = kategoriList[kategoriIdx - 1];

            if (jenis == 1) {
                System.out.print("Nama: "); String nama = sc.nextLine();
                System.out.print("Umur: "); int umur = Integer.parseInt(sc.nextLine());
                System.out.print("Tinggi: "); int tinggi = Integer.parseInt(sc.nextLine());
                System.out.print("Berat: "); int berat = Integer.parseInt(sc.nextLine());
                System.out.print("Followers: "); int followers = Integer.parseInt(sc.nextLine());
                System.out.print("Akun Media: "); String akun = sc.nextLine();
                mediaList.add(new Howard_99772_Celebgram(nama, umur, tinggi, berat, followers, akun, kategori));
            } else {
                System.out.print("Nama Majalah: "); String nama = sc.nextLine();
                System.out.print("Luas: "); int luas = Integer.parseInt(sc.nextLine());
                System.out.print("Letak: "); String letak = sc.nextLine();
                mediaList.add(new Howard_99772_Majalah(nama, luas, letak, kategori));
            }
            System.out.println("Media telah ditambahkan.");
        } catch (Exception e) {
            System.out.println("Input tidak valid. Silakan ulangi.");
        }
    }

    static void sewaMedia() {
        try {
            System.out.println("Pilih Kategori:");
            for (int i = 0; i < kategoriList.length; i++) {
                System.out.println((i + 1) + ". " + kategoriList[i]);
            }
            System.out.print("Masukkan nomor kategori (1-5): ");
            int kategoriIdx = Integer.parseInt(sc.nextLine());
            String kategori = kategoriList[kategoriIdx - 1];

            System.out.print("Tanggal mulai (YYYY-MM-DD): ");
            LocalDate tanggal = LocalDate.parse(sc.nextLine());
            System.out.print("Jumlah hari: ");
            int hari = Integer.parseInt(sc.nextLine());

            for (int i = 0; i < mediaList.size(); i++) {
                Howard_99772_MediaPromosi m = mediaList.get(i);
                int harga = m.hitungHarga(kategori, hari);

                System.out.println("No.            : " + (i + 1));
                System.out.println("Media          : " + m.getClass().getSimpleName());
                System.out.println("Nama           : " + m.getNama());

                if (m instanceof Howard_99772_Aktor) {
                    Howard_99772_Aktor a = (Howard_99772_Aktor) m;
                    System.out.println("Umur           : " + a.getUmur() + " tahun");
                    System.out.println("Tinggi Badan   : " + a.getTinggiBadan() + " cm");
                    System.out.println("Berat Badan    : " + a.getBeratBadan() + " kg");
                    System.out.println("Jumlah Fans    : " + a.getFans());
                    System.out.println("Fans Club      : " + a.getFansClub());

                } else if (m instanceof Howard_99772_Celebgram) {
                    Howard_99772_Celebgram c = (Howard_99772_Celebgram) m;
                    System.out.println("Umur           : " + c.getUmur() + " tahun");
                    System.out.println("Tinggi Badan   : " + c.getTinggiBadan() + " cm");
                    System.out.println("Berat Badan    : " + c.getBeratBadan() + " kg");
                    System.out.println("Followers      : " + c.getFollowers());
                    System.out.println("Akun Media     : " + c.getAkunMedia());
                    System.out.println("Bidang         : " + c.getBidang());

                } else if (m instanceof Howard_99772_Baliho) {
                    Howard_99772_Baliho b = (Howard_99772_Baliho) m;
                    System.out.println("Luas           : " + b.getLuas() + " m2");
                    System.out.println("Letak          : " + b.getLetak());

                } else if (m instanceof Howard_99772_Majalah) {
                    Howard_99772_Majalah mj = (Howard_99772_Majalah) m;
                    System.out.println("Luas           : " + mj.getLuas() + " cm2");
                    System.out.println("Letak          : " + mj.getLetak());
                    System.out.println("Bidang         : " + mj.getBidang());
                }

                System.out.println("Harga          : Rp" + harga);
                System.out.println("----------------------------------------");
            }


            System.out.print("Pilih media (nomor): ");
            int pilih = Integer.parseInt(sc.nextLine());
            Howard_99772_MediaPromosi media = mediaList.get(pilih - 1);
            int total = media.hitungHarga(kategori, hari);

            System.out.print("Masukkan uang: Rp");
            int uang = Integer.parseInt(sc.nextLine());

            if (uang >= total) {
                orders.add(new Howard_99772_Order(media, kategori, tanggal, hari, total));
                System.out.println("Pemesanan berhasil.");
            } else {
                System.out.println("Uang tidak mencukupi.");
            }
        } catch (Exception e) {
            System.out.println("Kesalahan input. Ulangi dari awal.");
        }
    }

    static void aturOrder() {
        try {
            if (orders.isEmpty()) {
                System.out.println("Belum ada order.");
                return;
            }

            for (int i = 0; i < orders.size(); i++) {
                System.out.println((i+1) + ". " + orders.get(i));
            }

            System.out.println("1. Batalkan Order\n2. Kembali");
            int pilihan = Integer.parseInt(sc.nextLine());
            if (pilihan == 1) {
                System.out.print("Nomor order: ");
                int no = Integer.parseInt(sc.nextLine());
                if (orders.get(no - 1).bisaDibatalkan(TANGGAL_UJIAN)) {
                    orders.remove(no - 1);
                    System.out.println("Order berhasil dibatalkan.");
                } else {
                    System.out.println("Tidak dapat membatalkan order pada tanggal ujian.");
                }
            }
        } catch (Exception e) {
            System.out.println("Input salah. Silakan coba lagi.");
        }
    }

    static void tampilkanCredits() {
        System.out.println("============================");
        System.out.println("Name : Howard");
        System.out.println("NIM  : 00000099772");

    }
}

