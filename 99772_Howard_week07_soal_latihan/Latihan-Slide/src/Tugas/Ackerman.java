package Tugas;

import java.util.Scanner;

public class Ackerman {
    public static int AckermanFunction(int m, int n) {
        if (m == 0 && n != 0) {
            return n + 1;
        }
        if (m != 0 && n == 0) {
            return AckermanFunction(m - 1, 1);
        }
        return AckermanFunction(m - 1, AckermanFunction(m, n - 1));
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("m: ");
        int angka = scanner.nextInt();
        scanner.nextLine();
        System.out.print("n: ");
        int angka2 = scanner.nextInt();
        scanner.nextLine();
        int result = AckermanFunction(angka, angka2);
        System.out.println(result);
        scanner.close();
        
    }

}
