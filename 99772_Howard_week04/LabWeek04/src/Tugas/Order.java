package Tugas;
import java.util.Scanner;
import java.io.IOException;
import java.util.ArrayList;
public class Order {
	private static int pesanan_history = 0; 
	private static int id, jumlah;
	private static Barang[] barang = new Barang[5];
	public static int total;
	private static ArrayList<Integer> id_pesan = new ArrayList<>();
	private static ArrayList<Integer> jumlah_Pesan = new ArrayList<>();
	
	
	// id harus urut kalau program mau kerja
	public static void seedData() {
		barang[0] = new Barang(1, 100, 10, "pulpen");
		barang[1] = new Barang(2, 200, 5, "penghapus");
		barang[2] = new Barang(3, 50, 100, "dompet");
		barang[3] = new Barang(4, 75, 15, "penggaris");
		barang[4] = new Barang(5, 60, 20, "buku");
	}
	
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
	
	public static void mainmenu() {
		System.out.println("----------Menu Toko Multiguna----------");
		System.out.println("1. Pesan Barang");
		System.out.println("2. Lihat Pesanan");
	}
	
	public static boolean checkidexist(int id) {
		for(int i = 0; i < barang.length; i++) {
			if(barang[i].getid() == id) {
				return true;
			}
		}
		return false;
	}
	
	public static int showBarang(Scanner scanner) {
		System.out.println("Daftar barang toko Multiguna");
		System.out.println("------------------------------");
		for(int i = 0; i < barang.length; i++) {
			System.out.println(String.format("ID   : %d", barang[i].getid()));
			System.out.println(String.format("Nama : %s", barang[i].getnama()));
			System.out.println(String.format("Stock: %d", barang[i].getstock()));
			System.out.println(String.format("Harga: %d", barang[i].harga()));
			System.out.println("------------------------------");
		}
		System.out.print("masukkan nomor id atau 0 untuk keluar: ");
		int choosen_id = scanner.nextInt();
		if(choosen_id == 0) {
			System.out.println("berhasil keluar!");
			System.out.println("press any key to continue...");
			waitUserInput();
			clearScreen();
			return -1;
		}
		boolean checkid = checkidexist(choosen_id);
		if(!checkid) {
			System.out.println("id yang dimasukkan tidak terdaftar dalam sistem!");
			System.out.println("press any key to continue...");
			waitUserInput();
			clearScreen();
			return -1;
		}
		int currentStock = barang[choosen_id -1].getstock();
		if(currentStock == 0) {
			System.out.println("stock kosong!");
			System.out.println("press any key to continue...");
			waitUserInput();
			clearScreen();
			return -1;
		}
		System.out.println("id yang dimasukkan terdaftar dalam sistem!");
		System.out.println("press any key to continue...");
		waitUserInput();
		clearScreen();
		return choosen_id;
	}
	
	public static void pesanBarang(int id, Scanner scanner) {
		System.out.println(String.format("Pesan Barang (ID) : %d", barang[id -1].getid()));
		System.out.print("Masukkan jumlah: ");
		jumlah = scanner.nextInt();
		if(jumlah > barang[id -1 ].getstock()) {
			System.out.println("jumlah yang dimasukkan lebih dari stock tersedia!");
			System.out.println("press any key to continue...");
			waitUserInput();
			clearScreen();
			return;
			
		}
		int total_harga = jumlah * barang[id - 1].harga();
		System.out.println(String.format("%d %s dengan total harga %d", jumlah, barang[id -1].getnama(), total_harga));
		System.out.print("masukkan jumlah uang: ");
		int harga_bayar = scanner.nextInt();
		if(harga_bayar < total_harga) {
			System.out.println("masukkan jumlah uang yang tepat!");
			System.out.println("press any key to continue...");
			waitUserInput();
			clearScreen();
			return;
		}else {
			int stock_sekarang = barang[id -1].getstock();
			id_pesan.add(id);
			jumlah_Pesan.add(jumlah);
			//update size history
			pesanan_history = id_pesan.size();
			barang[id -1].minusStock(stock_sekarang, jumlah);
			System.out.println("berhasil pesan!");
			System.out.println("press any key to continue...");
			waitUserInput();
			clearScreen();
			return;
			
		}
		
	}
	
	public static void checkPesanan() {
		if(pesanan_history == 0) {
			System.out.println("pastikan memesan barang terlebih dahulu!");
			waitUserInput();
			clearScreen();
			return;
		}
		System.out.println("Daftar pesanan toko Multiguna");
		System.out.println("------------------------------");
		for(int i = 0; i < pesanan_history; i++) {
			int idhaha = id_pesan.get(i);
			int jumlahaha = jumlah_Pesan.get(i);
			int totalhaha = jumlahaha * barang[idhaha-1].harga();
			System.out.println(String.format("ID    : %d", idhaha));
			System.out.println(String.format("Nama  : %s", barang[idhaha-1].getnama()));
			System.out.println(String.format("Jumlah: %d", jumlahaha));
			System.out.println(String.format("Total : %d", totalhaha));
			System.out.println("------------------------------");

		}
		System.out.println("press any key to continue...");
		waitUserInput();
		clearScreen();
		return;
		
	}
	
	public static void main(String[] args) {
		boolean program_jalan  = true;
		Scanner scanner = new Scanner(System.in);
		int option;
		seedData();
		while(program_jalan) {
			mainmenu();
			System.out.print("masukkan pilihan: ");
			option = scanner.nextInt();
			switch(option){
				case 1:
					clearScreen(); 
					id = showBarang(scanner);
					if(id == -1) {
						break;
					}
					pesanBarang(id,scanner);
					break;
				case 2:
					clearScreen();
					checkPesanan();
					break;
					
				default:
					program_jalan = false;
			}
		}
		
	}
	
	

}
