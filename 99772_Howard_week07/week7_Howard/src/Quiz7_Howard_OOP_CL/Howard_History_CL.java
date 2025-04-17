package Quiz7_Howard_OOP_CL;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
public class Howard_History_CL {
    private String jenis;
    private long nominal;
    private String tanggal;

    public Howard_History_CL(String jenis, long nominal) {
        this.jenis = jenis;
        this.nominal = nominal;
        LocalDate today = LocalDate.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd MMMM yyyy");
        String formattedDate = today.format(formatter);
        this.tanggal = formattedDate;
    }

    public String getDate() {
        return this.tanggal;
    }

    public long getNominalHistory() {
        return this.nominal;
    }

    public String getJenis() {
        return this.jenis;
    }

}
