package Activity;
import java.util.Scanner;

public class Tutorial {
	public static void main(String[] args) {
		int input;
		Scanner scanner = new Scanner(System.in);
		String[] matkulIF = {
				"Matematika diskrit",
				"Dasar dasar pemrograman",
				"Pemrograman Beroriemtasi Objek",
				
		};
		String[] matkulICE = {
				"Riset Operasi",
				"Jaringan Komputer",
				"Aljabar Linear",
		};
		String[] matkulIS = {
				"Sistem Database",
				"Administrasi Database",
		};
		
		
		System.out.println("Pilih Kategori matakuliah: ");
		System.out.println("1. Informatika\n2. Computer Engineering\n3. Information system");
		System.out.print("pilih: ");
		input = scanner.nextInt();
		
		switch(input) {
			case 1: System.out.println("Daftar matakuliah IF : "); show(matkulIF); break;
			case 2: System.out.println("Daftar matakuliah CE : "); show(matkulICE); break;
			case 3: System.out.println("Daftar matakuliah IS : "); show(matkulIS); break;
			
		}	
	}
	public static void show(String[] matkul) {
		for(String eachMatkul: matkul) {
			System.out.println("- " + eachMatkul);
		}
	}

}
