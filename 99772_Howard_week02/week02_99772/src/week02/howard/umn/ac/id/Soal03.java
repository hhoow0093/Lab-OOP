package week02.howard.umn.ac.id;
import java.util.Scanner;

public class Soal03 {

    public static boolean prime(int number) {
        boolean flag = true;
        int counter = 2;
        if (counter == number) {
            return flag;
        }
        while (counter < number) {
            if (number % counter == 0) {
                flag = false;
            }
            counter++;
        }
        return flag;
    }

    public static int totalprime(int angka_kecil, int angka_besar) {
        int total = 0;
        while (angka_kecil <= angka_besar) {
            if (prime(angka_kecil)) {
                total += angka_kecil;
            }
            angka_kecil++;
        }
        return total;
        
    }
    public static void main(String[] args) {
        int nomor_kecil;
        int nomor_besar;
        int answer;
        Scanner scanner = new Scanner(System.in);
        System.out.print("masukkan angka kecil:");
        nomor_kecil = scanner.nextInt();
        System.out.print("masukkan angka besar:");
        nomor_besar = scanner.nextInt();
        scanner.close();
        if (nomor_kecil > nomor_besar) {
            System.out.println("pastikan nomor kecil lebih kecil dari nomor besar");
        } else {
            answer = totalprime(nomor_kecil, nomor_besar);
            System.out.println(String.format("total angka prima antara %d sampai %d adalah %d", nomor_kecil, nomor_besar, answer));
        }

    }

}
