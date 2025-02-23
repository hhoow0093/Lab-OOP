package Tutorial;
import java.util.Scanner;

public class MainTutor {
	static MataKuliah[] matkuls = new MataKuliah[9];
	public static void seedData() {
		matkuls[0] = new MataKuliah("IF402", "Pemograman Berorientasi Objek", 3);
		matkuls[1] = new MataKuliah("IF100", "Dasar Dasar Pemograman", 3);
		matkuls[2] = new MataKuliah("IF534", "Kecerdasan Buatan", 3);
		matkuls[3] = new MataKuliah("IF121", "Aljabar linear", 3);
		matkuls[4] = new MataKuliah("CE441", "Jaringan komputer", 3);
		matkuls[5] = new MataKuliah("CE232", "Sistem Digital", 3);
		matkuls[6] = new MataKuliah("UM162", "Pancasila", 2);
		matkuls[7] = new MataKuliah("UM152", "Agama", 2);
		matkuls[8] = new MataKuliah("UM142", "Civics", 2);
	}
	public static void mainMenu() {
		System.out.println("------ Daftar Matakuliah ------");
		System.out.println("1. Lihat semua matakuliah");
		System.out.println("2. Lihat semua kode IF");
		System.out.println("3. Lihat semua kode CE");
		System.out.println("4. Lihat semua kode UM");
	}
	public static void showData() {
		System.out.println("Daftar matakuliah");
		for(MataKuliah matkul: matkuls) {
			System.out.println(String.format("kode             : %-2s %s", "", matkul.getKode()));
			System.out.println(String.format("nama mata kuliah : %-2s %s", "", matkul.getNama()));
			System.out.println(String.format("jumlah sks       : %-2s %d", "", matkul.getSks()));
			
		}
	}
	public static void filterData(String kode) {
		System.out.println(String.format("daftar matakuliah dengan kode kelas %s", kode));
		for(MataKuliah matkul: matkuls) {
			if(matkul.getKode().contains(kode)) {
				System.out.println(String.format("kode             : %-2s %s", "", matkul.getKode()));
				System.out.println(String.format("nama mata kuliah : %-2s %s", "", matkul.getNama()));
				System.out.println(String.format("jumlah sks       : %-2s %d", "", matkul.getSks()));
			}
			
		}
	}
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		seedData();
		int menu;
		for(;;) {
			mainMenu();
			System.out.print("pilihan");
			menu = scanner.nextInt();
			scanner.nextLine();
			switch(menu){
				case 1: showData(); break;
				case 2: filterData("IF"); break;
				case 3: filterData("CE"); break;
				case 4: filterData("UM"); break;
			}
		}
		
	}

}
