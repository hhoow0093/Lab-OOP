package Quiz7_Howard_OOP_CL;

public class Howard_Transfer_CL extends Howard_Transaction_CL {
    private Howard_User_CL rekening_to;

    public Howard_Transfer_CL(int jumlah, String nama, Howard_User_CL selected_user, Howard_User_CL rekening_to) {
        super(jumlah, nama, selected_user);
        this.rekening_to = rekening_to;
    }

    public void transfer() {
        long saldoPenerima;
        long saldoTransfer;
        saldoPenerima = this.rekening_to.getSaldo() + super.getJumlah();
        saldoTransfer = super.getUser().getSaldo() - super.getJumlah();
        if (saldoTransfer < 0) {
            System.out.println("gagal karena uang tidak cukup");
            return;
        }
        this.rekening_to.setSaldo(saldoPenerima);
        super.getUser().setSaldo(saldoTransfer);
        System.out.println(String.format("sisa uang penerima %s: %d", this.rekening_to.getNama(), this.rekening_to.getSaldo()));
        System.out.println(String.format("sisa uang penyumbang %s: %d", super.getNama(), super.getUser().getSaldo()));
    }

}
