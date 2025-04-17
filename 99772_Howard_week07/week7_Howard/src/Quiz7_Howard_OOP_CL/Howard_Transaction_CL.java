package Quiz7_Howard_OOP_CL;

public class Howard_Transaction_CL {
	private int jumlah;
	private String nama;
	private Howard_User_CL selected_user;
	public Howard_Transaction_CL(int jumlah, String nama, Howard_User_CL selected_user) {
		this.selected_user = selected_user;
		this.jumlah = jumlah;
		this.nama = nama;
	}
	public int getJumlah() {
		return this.jumlah;
	}
	public Howard_User_CL getUser() {
		return this.selected_user;
	}
	public String getNama() {
		return this.nama;
	}
}
