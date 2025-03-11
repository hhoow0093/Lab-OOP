package Tugas;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    private static ArrayList<Handphone> ListHandphone = new ArrayList<>();
    private static ArrayList<Voucher> vouchers = new ArrayList<>();

    private static ArrayList<Handphone> HandphoneUser = new ArrayList<>();
    private static ArrayList<Voucher> VoucherUser = new ArrayList<>();
    private static ArrayList<Integer> JumlahHPuser = new ArrayList<>();
    private static ArrayList<Integer> JumlahVoucherUser = new ArrayList<>();

    private static int idVoucher = 1;
    private static int idHandphone = 1;

    public static void waitUserInput() {
    try {
        System.in.read();
    } catch (IOException e) {
        e.printStackTrace();
    }
    System.out.println("Continuing...");
    }
    
    public static void clearScreen() {
        try {
            if (System.getProperty("os.name").contains("Windows")) {
                new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
            } else {
                System.out.print("\033[H\033[2J");
                System.out.flush();
            }
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }

    }

    public static void viewMenu() {
        System.out.println("----------Menu toko Voucher dan HP----------");
        System.out.println("1. Pesan Barang");
        System.out.println("2. Lihat Pesanan");
        System.out.println("3. tambahkan barang baru");
        System.out.print("Pilihan: ");
    }

    public static void addVoucher(Scanner scanner) {
        String nama;
        double Harga;
        int stock;
        double pajak;
        System.out.print("Nama:");
        nama = scanner.nextLine();
        System.out.print("Harga:");
        Harga = scanner.nextDouble();
        System.out.print("Stock:");
        stock = scanner.nextInt();
        System.out.print("PPN (0 - 1):");
        pajak = scanner.nextDouble();
        while (pajak > 1 || pajak < 0) {
            System.out.println("masukkan pajak yang benar! (0 - 1)");
            System.out.print("PPN (0 - 1):");
            pajak = scanner.nextDouble();
        }
        Voucher new_Voucher = new Voucher(idVoucher, nama, Harga, stock, pajak);
        idVoucher++;
        vouchers.add(new_Voucher);
        System.out.println("new voucher has been added!");
        System.out.println("press any key to continue...");
        waitUserInput();
        clearScreen();

    }
    
    public static void addPhone(Scanner scanner) {
        String nama;
        double Harga;
        int stock;
        String warna;
        System.out.print("Nama: ");
        nama = scanner.nextLine();
        System.out.print("Harga: ");
        Harga = scanner.nextDouble();
        scanner.nextLine();
        System.out.print("Stock: ");
        stock = scanner.nextInt();
        scanner.nextLine();
        System.out.print("Warna: ");
        warna = scanner.nextLine();
        Handphone newPhone = new Handphone(idHandphone, nama, Harga, stock, warna);
        idHandphone++;
        ListHandphone.add(newPhone);
        System.out.println("new Phone has been added!");
        System.out.println("press any key to continue...");
        waitUserInput();
        clearScreen();


    }

    public static void addProducts(Scanner scanner) {
        scanner.nextLine();
        char VorH;
        System.out.print("Voucher / Handphone (V / H): ");
        VorH = scanner.nextLine().charAt(0);
        VorH = Character.toUpperCase(VorH);

        switch (VorH) {
            case 'V':
                addVoucher(scanner);
                return;
            case 'H':
                addPhone(scanner);
                return;
            default:
                System.out.println("masukkan input yang benar!");
                return;
        }
    }

    public static boolean checkPhoneExist(int id) {
        for (int i = 0; i < ListHandphone.size(); i++) {
            if (id == ListHandphone.get(i).getId()) {
                return true;
            }
            
        }
        return false;
        
    }

    public static void pesanHP(Scanner scanner) {
        int ID;
        if (ListHandphone.size() == 0) {
            System.out.println("tidak ada barang HP tersedia");
            System.out.println("press any key to continue...");
            waitUserInput();
            clearScreen();
            return;
        }
        System.out.println("----------------------");
        for (int i = 0; i < ListHandphone.size(); i++) {
            System.out.println(String.format("ID    : %d", ListHandphone.get(i).getId()));
            System.out.println(String.format("Nama  : %s", ListHandphone.get(i).getNama()));
            System.out.println(String.format("Stock : %d", ListHandphone.get(i).getStock()));
            System.out.println(String.format("Harga : %.2f", ListHandphone.get(i).getHarga()));
            System.out.println(String.format("Warna : %s", ListHandphone.get(i).getWarna()));
            System.out.println("----------------------");
        }
        System.out.print("masukkan id yang tersedia (0 untuk batal) : ");
        ID = scanner.nextInt();
        if (ID == 0) {
            System.out.println("Oke balik ke halaman utama...");
            System.out.println("press any key to continue....");
            waitUserInput();
            clearScreen();
            return;

        }
        boolean exist = checkPhoneExist(ID);
        if (exist) {
            int jumlah;
            double total;
            double bayar;
            System.out.print("Masukkan Jumlah: ");
            jumlah = scanner.nextInt();
            if (jumlah > ListHandphone.get(ID - 1).getStock()) {
                System.out.println("pastikan jumlah yang dipesan lebih kecil dari stock!");
                System.out.println("press any key to continue....");
                waitUserInput();
                clearScreen();
                return;

            }

            total = jumlah * ListHandphone.get(ID - 1).getHarga();
            System.out.println(String.format("%d @ %s dengan total harga %.2f", jumlah,
                    ListHandphone.get(ID - 1).getNama(), total));
            System.out.print("masukkan jumlah uang:");
            bayar = scanner.nextDouble();

            if (bayar < total) {
                System.out.println("pastikan uang yang dimasukkan cukup!");
                System.out.println("press any key to continue....");
                waitUserInput();
                clearScreen();
                return;
            }
            HandphoneUser.add(ListHandphone.get(ID - 1));
            JumlahHPuser.add(jumlah);
            System.out.println("berhasil dipesan!");
            ListHandphone.get(ID - 1).minusStock(jumlah);
            System.out.println("press any key to continue....");
            waitUserInput();
            clearScreen();
            return;

        } else {
            System.out.println("Pastikan Item berada dalam sistem");
            System.out.println("press any key to continue....");
            waitUserInput();
            clearScreen();
            return;
        }

    }

    public static boolean checkVoucherExist(int id) {
        for (int i = 0; i < vouchers.size(); i++) {
            if (id == vouchers.get(i).getId()) {
                return true;
            }          
        }
        
        return false;
    }
    
    public static void pesanVoucher(Scanner scanner) {
        int ID;
        if (vouchers.size() == 0) {
            System.out.println("tidak ada barang voucher tersedia");
            System.out.println("press any key to continue...");
            waitUserInput();
            clearScreen();
            return;
        }
        System.out.println("----------------------");
        for (int i = 0; i < vouchers.size(); i++) {
            System.out.println(String.format("ID    : %d", vouchers.get(i).getId()));
            System.out.println(String.format("Nama  : %s", vouchers.get(i).getNama()));
            System.out.println(String.format("Stock : %d", vouchers.get(i).getStock()));
            System.out.println(String.format("Harga : %.2f", vouchers.get(i).getHarga()));
            System.out.println(String.format("Nominal : %.2f", vouchers.get(i).getHargaJual()));
            System.out.println("----------------------");
        }
        System.out.print("masukkan id yang tersedia (0 untuk batal) : ");
        ID = scanner.nextInt();
        if (ID == 0) {
            System.out.println("Oke balik ke halaman utama...");
            System.out.println("press any key to continue....");
            waitUserInput();
            clearScreen();
            return;

        }
        boolean voucherExist = checkVoucherExist(ID);
        if (voucherExist) {
            int jumlah;
            double total;
            double bayar;
            System.out.print("Masukkan Jumlah: ");
            jumlah = scanner.nextInt();
            if (jumlah > vouchers.get(ID - 1).getStock()) {
                System.out.println("pastikan jumlah yang dipesan lebih kecil dari stock!");
                System.out.println("press any key to continue....");
                waitUserInput();
                clearScreen();
                return;
            }
            total = jumlah * vouchers.get(ID - 1).getHarga();
            System.out.println(String.format("%d @ %s dengan total harga %.2f", jumlah, vouchers.get(ID - 1).getNama(), total));
            System.out.print("masukkan jumlah uang:");
            bayar = scanner.nextDouble();

            if (bayar < total) {
                System.out.println("pastikan uang yang dimasukkan cukup!");
                System.out.println("press any key to continue....");
                waitUserInput();
                clearScreen();
                return;
            }
            VoucherUser.add(vouchers.get(ID - 1));
            JumlahVoucherUser.add(jumlah);
            System.out.println("berhasil dipesan!");
            vouchers.get(ID - 1).minusStock(jumlah);
            System.out.println("press any key to continue....");
            waitUserInput();
            clearScreen();
            return;

            
        } else {
            System.out.println("Pastikan Item berada dalam sistem");
            System.out.println("press any key to continue....");
            waitUserInput();
            clearScreen();
            return;
            
        }

    }

    public static void pesanBarang(Scanner scanner) {
        scanner.nextLine();
        int choice;
        System.out.println("Daftar Toko Voucher & HP");
        System.out.println("1. Handphone");
        System.out.println("2. Voucher");
        System.out.print("pilihan: ");
        choice = scanner.nextInt();
        switch (choice) {
            case 1:
                pesanHP(scanner);
                return;
            case 2:
                pesanVoucher(scanner);
                return;
            case 3:
                System.out.println("masukkan nomor yang benar");
                System.out.println("press any key to continue...");
                waitUserInput();
                clearScreen();
                return;
        }
    }

    public static void lihatpesanHP() {
        System.out.println("Daftar Pesanan toko Mulltiguna");
        for (int i = 0; i < HandphoneUser.size(); i++) {
            System.out.println(String.format("ID     : %d", HandphoneUser.get(i).getId()));
            System.out.println(String.format("Nama   : %s", HandphoneUser.get(i).getNama()));
            System.out.println(String.format("Jumlah : %d", JumlahHPuser.get(i)));
            System.out.println("------------------------------");
        }
    }

    public static void lihatpesanVoucher() {
        for (int i = 0; i < VoucherUser.size(); i++) {
            System.out.println(String.format("ID     : %d", VoucherUser.get(i).getId()));
            System.out.println(String.format("Nama   : %s ", VoucherUser.get(i).getNama()));
            System.out.println(String.format("Jumlah : %d", JumlahVoucherUser.get(i)));
            System.out.println("------------------------------");
        }
    }

    public static void lihatPemesanan(Scanner scanner) {
        lihatpesanHP();
        lihatpesanVoucher();
        System.out.println("press any key to continue...");
        waitUserInput();
        clearScreen();
        return;
    }

    public static void main(String[] args) {
        boolean isProgramRunning = true;
        Scanner scanner = new Scanner(System.in);
        int pilihan;
        while (isProgramRunning) {
            viewMenu();
            pilihan = scanner.nextInt();
            switch (pilihan) {
                case 3:
                    addProducts(scanner);
                    break;
                case 1:
                    pesanBarang(scanner);
                    break;
                case 2:
                    lihatPemesanan(scanner);
                    break;
                default:
                    isProgramRunning = false;
                    break;
            }

        }
        scanner.close();
        
    }

}
