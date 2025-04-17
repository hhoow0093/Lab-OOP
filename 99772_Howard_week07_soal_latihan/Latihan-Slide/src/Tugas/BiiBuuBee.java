package Tugas;
import java.util.Scanner;

public class BiiBuuBee {
    public static void bibubi(int angka) {
        for (int i = 1; i < angka + 1; i++) {
            if (i % 2 == 0 && i % 3 == 0) {
                System.out.println(String.format("%d. Bii", i));
            }
            else if (i % 2 == 0) {
                System.out.println(String.format("%d. Buu", i ));
            }
            else if (i % 3 == 0) {
                System.out.println(String.format("%d. Bee", i));
            }
            else {
                System.out.println(String.format("%d", i));
            }
        }
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("masukkan angka: ");
        int angka = scanner.nextInt();
        bibubi(angka);
        scanner.close();
        
    }

}
