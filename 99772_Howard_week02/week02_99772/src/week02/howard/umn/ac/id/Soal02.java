package week02.howard.umn.ac.id;
import java.util.Scanner;

public class Soal02 {
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
    public static void main(String[] args) {
        int nomor;
        boolean answer;

        Scanner scanner = new Scanner(System.in);
        System.out.print("masukkan nomor:");
        nomor = scanner.nextInt();
        answer = prime(nomor);
        scanner.close();

        if (answer) {
            System.out.println(String.format("nomor %d adalah angka prima", nomor));
        } else {
            System.out.println(String.format("nomor %d bukanlah angka prima", nomor));
            
        }

    }

}
