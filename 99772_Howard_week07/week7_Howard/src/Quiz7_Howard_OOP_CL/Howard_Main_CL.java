package Quiz7_Howard_OOP_CL;
import java.util.ArrayList;
import java.util.Scanner;
public class Howard_Main_CL {
	public static ArrayList<Howard_User_CL> user_list = new ArrayList<>();
	
	public static void viewMenu() {
		System.out.println("Selamat datang ke Bank UMN : ");
		System.out.println("1. Add User");
		System.out.println("2. List user");
		System.out.println("3. Transaction");
		System.out.print("Pilihan: ");
	}
	
	public static void TambahUser(Scanner scanner) {
		Howard_User_CL new_user;
		scanner.nextLine();
		String nama;
		int nomorRek;
		System.out.print("Masukkan nama: ");
		nama = scanner.nextLine();
		System.out.print("Masukkan nomor rekening: ");
		nomorRek = scanner.nextInt();
		for (int i = 0; i < user_list.size(); i++) {
			if (user_list.get(i).getNoRekening() == nomorRek) {
				System.out.println("masukkan nomor rekening unik");
				return;
			}
		}
		scanner.nextLine();
		new_user = new Howard_User_CL(nama, nomorRek);
		user_list.add(new_user);
		System.out.println("berhasil manambahkab user baru");
		
	}
	
	public static void viewJenisTransaksi() {
		System.out.println("Pilih Jenis Transaksi : ");
		System.out.println("1. Menabung Uang");
		System.out.println("2. Menarik Uang");
		System.out.println("3. Transfer uang");
		System.out.println("4. Tampilkan histori Transaksi");
		System.out.print("Select jenis transaksi: ");
		
	}
	
	public static void prosesMenabung(Scanner scanner, Howard_User_CL selected_user) {
		int nominal;
		long nominalHistory;
		System.out.print("masukkan nominal: ");
		nominal = scanner.nextInt();
		scanner.nextLine();
		nominalHistory = (long) nominal;
		Howard_Menabung_CL menabung = new Howard_Menabung_CL(nominal, selected_user.getNama(), selected_user);
		Howard_History_CL history_menabung = new Howard_History_CL("Menabung", nominalHistory);
		selected_user.addHistory(history_menabung);
		menabung.menabung();
		System.out.println();

	}
	
	public static void prosesMenarik(Scanner scanner, Howard_User_CL selected_user) {
		int nominal;
		long nominalHistory;
		System.out.print("masukkan nominal: ");
		nominal = scanner.nextInt();
		scanner.nextLine();
		nominalHistory = (long) nominal;
		Howard_Menarik_CL menarik = new Howard_Menarik_CL(nominal, selected_user.getNama(), selected_user);
		Howard_History_CL history_menarik = new Howard_History_CL("Menarik", nominalHistory);
		selected_user.addHistory(history_menarik);
		menarik.menarik();
		System.out.println();
	}

	public static void prosesTransfer(Scanner scanner, Howard_User_CL selected_user) {
		int pilihanUser;
		viewUser();
		System.out.print("masukkan user yang mau di transfer: ");
		pilihanUser = scanner.nextInt();
		if ((pilihanUser - 1) >= user_list.size() || (pilihanUser - 1) < 0) {
			System.out.println("user tidak ada ada sistem");
			return;
		}
		if (user_list.get(pilihanUser - 1) == selected_user) {
			System.out.println("user tidak boleh sama!");
			return;
		}
		Howard_User_CL user_di_transfer = user_list.get(pilihanUser - 1);
		int nominal;
		long nominalHistory;
		System.out.print("masukkan jumlah nominal: ");
		nominal = scanner.nextInt();
		scanner.nextLine();
		nominalHistory = (long) nominal;
		Howard_History_CL history_transfer = new Howard_History_CL("Transfer", nominalHistory);
		selected_user.addHistory(history_transfer);
		Howard_Transfer_CL transfer = new Howard_Transfer_CL(nominal, selected_user.getNama(), selected_user, user_di_transfer);
		transfer.transfer();

	}
	
	public static void prosesGetHistory(Howard_User_CL selected_user) {
		ArrayList<Howard_History_CL> history_user = new ArrayList<>();
		history_user = selected_user.getHistoryList();
		System.out.println("History transaksi: ");
		for (int i = 0; i < history_user.size(); i++) {
			System.out.println(String.format("%s - %s - Rp.%d", history_user.get(i).getDate(), history_user.get(i).getJenis(), history_user.get(i).getNominalHistory()));
		}
	}
	
	public static void TransactionProccess(Scanner scanner) {
		int SelectUser;
		System.out.print("Select user: ");
		SelectUser = scanner.nextInt();
		scanner.nextLine();
		if((SelectUser - 1) >= user_list.size() || (SelectUser - 1) < 0) {
			System.out.println("user tidak ada ada sistem");
			return;
		}
		
		Howard_User_CL selectedUser = user_list.get(SelectUser - 1);
		viewJenisTransaksi();
		int selectedJenisTransaksi;
		selectedJenisTransaksi = scanner.nextInt();
		scanner.nextLine();
		switch(selectedJenisTransaksi) {
			case 1:
				prosesMenabung(scanner, selectedUser);
				break;
			case 2:
				prosesMenarik(scanner, selectedUser);
				break;
			case 3:
				prosesTransfer(scanner, selectedUser);
				break;
			default:
				prosesGetHistory(selectedUser);
				return;
		}
		
		
	}
	
	public static void viewUser() {
		System.out.println();
		System.out.println("List user: ");
		for(int i = 0; i < user_list.size(); i++) {
			System.out.println(String.format("%d. %s, %d", i+1 ,user_list.get(i).getNama(), user_list.get(i).getNoRekening()));
		}
		System.out.println();
	}
	
	public static void main(String args[]) {
		boolean is_programRunning = true;
		int pilihan;
		Scanner scanner = new Scanner(System.in);
		while (is_programRunning) {
			viewMenu();
			pilihan = scanner.nextInt();
			switch (pilihan) {
				case 1:
					TambahUser(scanner);
					break;
				case 2:
					viewUser();
					break;
				case 3:
					viewUser();
					TransactionProccess(scanner);
					break;
				default:
					is_programRunning = false;
					break;
			}

		}
		System.out.println("program selesai");
		
	}

}
