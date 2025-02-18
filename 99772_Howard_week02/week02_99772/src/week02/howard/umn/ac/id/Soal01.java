package week02.howard.umn.ac.id;
import java.util.Scanner;

public class Soal01 {
    public static String getBulanName(int number_in_bulan) {
        String bulanName = "";
        int Hari = 0;
        switch (number_in_bulan) {
            case 1:
                bulanName = "January";
                Hari = 31;
                break;
            case 2:
                bulanName = "February";
                Hari = 28;
                break;
            case 3:
                bulanName = "March";
                Hari = 31;
                break;
            case 4:
                bulanName = "April";
                Hari = 30;
                break;
            case 5:
                bulanName = "May";
                Hari = 31;
                break;
            case 6:
                bulanName = "June";
                Hari = 30;
                break;
            case 7:
                bulanName = "July";
                Hari = 31;
                break;
            case 8:
                bulanName = "August";
                Hari = 31;
                break;
            case 9:
                bulanName = "September";
                Hari = 30;
                break;
            case 10:
                bulanName = "October";
                Hari = 31;
                break;
            case 11:
                bulanName = "November";
                Hari = 30;
                break;
            case 12:
                bulanName = "December";
                Hari = 31;
                break;
            default:
                bulanName = "";
                Hari = 0;

        }
        String Kalimat;
        if(Hari != 0 && bulanName != ""){
             Kalimat = String.format("Bulan %s memiliki %d hari", bulanName, Hari);
        }else{
            Kalimat = String.format("Salah input nomor bulan");

        }
        return Kalimat;
    }

    public static void main(String[] args) {
        int bulan;
        Scanner scanner = new Scanner(System.in);
        System.out.print("Masukkan bulan (1-12):");
        bulan = scanner.nextInt();
        System.out.println(getBulanName(bulan));
        scanner.close();
    }
}
