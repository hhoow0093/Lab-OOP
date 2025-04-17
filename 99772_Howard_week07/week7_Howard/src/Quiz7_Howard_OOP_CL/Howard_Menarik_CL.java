package Quiz7_Howard_OOP_CL;

public class Howard_Menarik_CL extends Howard_Transaction_CL {
    public Howard_Menarik_CL(int jumlah, String nama, Howard_User_CL selected_user) {
        super(jumlah, nama, selected_user);
    }

    public void menarik() {
        long saldoBaru;
		saldoBaru = super.getUser().getSaldo() - super.getJumlah();
		super.getUser().setSaldo(saldoBaru);
		System.out.println("berhasil menarik");
		System.out.println(String.format("Saldo %s Sekarang : %d", super.getNama(),super.getUser().getSaldo()));
    }

}
