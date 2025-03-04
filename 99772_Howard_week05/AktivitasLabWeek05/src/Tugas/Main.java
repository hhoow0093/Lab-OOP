package Tugas;
import java.util.Scanner;
import java.io.IOException;

public class Main {
	
    public static void waitUserInput() {
        try {
            System.in.read();
        } catch (IOException e) {
            e.printStackTrace();
        }
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
    
	public static void viewMainMenu() {
		System.out.println("---------- Program menghitung Bangun Ruang ----------");
		System.out.println("1. Lingkaran");
		System.out.println("2. Persegi");
		System.out.println("3. Persegi Panjang");
		System.out.println("4. segitiga");
		System.out.println("5. keluar");
		
	}
	
	public static void handleLingkaran(Scanner s) {
		double Radius;
		String warna;
		System.out.println("---------- Lingkaran ----------");
		System.out.print("masukkan jari jari: ");
		Radius = s.nextDouble();
		s.nextLine();
		System.out.print("masukkan warna: ");
		warna = s.nextLine();
		Lingkaran newCircle = new Lingkaran(warna, Radius);
		System.out.println(String.format("Jari jari          : %f", newCircle.getRadius()));
		System.out.println(String.format("Keliling Lingkaran : %f", newCircle.getPerimeter()));
		System.out.println(String.format("Luas Lingkaran     : %f", newCircle.getArea()));
		System.out.println("press any key to continue...");
		waitUserInput();
		clearScreen();
	}
	
	public static void handlePersegi(Scanner s) {
		double panjangsisi;
		String warna;
		System.out.println("---------- Persegi ----------");
		System.out.print("masukkan panjang sisi: ");
		panjangsisi = s.nextDouble();
		s.nextLine();
		
		System.out.print("masukkan warna: ");
		warna = s.nextLine();
		
		Persegi newPersegi = new Persegi(warna, panjangsisi); 
		System.out.println(String.format("Panjang sisi     : %f", newPersegi.getPanjangSisi()));
		System.out.println(String.format("Keliling persegi : %f", newPersegi.getKelilingPersegi()));
		System.out.println(String.format("Luas Persegi     : %f", newPersegi.getLuas()));
		System.out.println("press any key to continue...");
		waitUserInput();
		clearScreen();
	}
	
	public static void handlePersegiPanjang(Scanner s) {
		double panjang;
		double lebar;
		String warna;
		System.out.println("---------- Persegi Panjang ----------");
		System.out.print("masukkan panjang persegi panjang: ");
		panjang = s.nextDouble();
		s.nextLine();
		
		System.out.print("masukkan lebar persegi panjang: ");
		lebar = s.nextDouble();
		s.nextLine();
		
		System.out.print("masukkan warna persegi panjang: ");
		warna = s.nextLine();
		
		PersegiPanjang newPersegiPanjang = new PersegiPanjang(warna, panjang, lebar);
		System.out.println(String.format("Panjang & Lebar          : %f & %f", newPersegiPanjang.getPanjang(), newPersegiPanjang.getLebar()));
		System.out.println(String.format("Keliling persegi panjang : %f", newPersegiPanjang.getKeliling()));
		System.out.println(String.format("Luas Persegi panjang     : %f", newPersegiPanjang.getLuas()));
		System.out.println("press any key to continue...");
		waitUserInput();
		clearScreen();

		
	}
	
	public static void handleSegitiga(Scanner s) {
		double alas;
		double tinggi;
		String warna;
		System.out.println("---------- Segitiga siku siku ----------");
		System.out.print("masukkan alas segitiga siku siku: ");
		alas = s.nextDouble();
		s.nextLine();
		
		System.out.print("masukkan tinggi segitiga siku siku: ");
		tinggi = s.nextDouble();
		s.nextLine();
		
		System.out.print("masukkan warna segitigas siku siku: ");
		warna = s.nextLine();
		
		Segitiga newSegitigaSikuSiku = new Segitiga(warna, alas, tinggi);
		System.out.println(String.format("Alas & tinggi               : %f & %f", newSegitigaSikuSiku.getAlas(), newSegitigaSikuSiku.getTinggi()));
		System.out.println(String.format("Keliling segitiga siku siku : %f", newSegitigaSikuSiku.getKelilingSegitigas()));
		System.out.println(String.format("Luas segitiga siku siku     : %f", newSegitigaSikuSiku.getLuasSegitiga()));
		System.out.println("press any key to continue...");
		waitUserInput();
		clearScreen();
		
	}
	
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		boolean programJalan = true;
		for(;;) {
			viewMainMenu();
			System.out.print("pilihan: ");
			int pilihan = s.nextInt();
			clearScreen();
			switch(pilihan){
				case 1:handleLingkaran(s); break;
				case 2:handlePersegi(s); break;
				case 3: handlePersegiPanjang(s); break;
				case 4:handleSegitiga(s);  break;
				case 5:programJalan = false; break;
			}
			if(!programJalan) {
				break;
			}
		}
		s.close();
		
	}

}
