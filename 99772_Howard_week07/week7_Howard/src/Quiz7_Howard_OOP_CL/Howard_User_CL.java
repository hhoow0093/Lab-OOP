package Quiz7_Howard_OOP_CL;
import java.util.ArrayList;
public class Howard_User_CL {
	private String nama;
	private int NoRekening;
	private long Saldo;
	private ArrayList<Howard_History_CL> history_list = new ArrayList<>();
	public Howard_User_CL(String nama, int NoRekening) {
		this.nama = nama;
		this.NoRekening = NoRekening;
		this.Saldo = 50000;
	}
	public String getNama() {
		return this.nama;
	}
	
	public int getNoRekening() {
		return this.NoRekening;
	}
	
	public long getSaldo() {
		return this.Saldo;
	}
	
	public void setSaldo(long saldo) {
		this.Saldo = saldo;

	}
	
	public ArrayList<Howard_History_CL> getHistoryList() {
		return this.history_list;
	}

	public void addHistory(Howard_History_CL historyUser) {
		this.history_list.add(historyUser);
	}
}
