package week02.howard.umn.ac.id;

import java.util.Scanner;

public class ArmStrong {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("masukkan angka armstrong: ");
        String input = scanner.nextLine();
        int my_input_number = Integer.parseInt(input);
        int total = 0;
        for (int i = 0; i < input.length(); i++) {
            total += Math.pow((input.charAt(i) - '0'), input.length());
        }
        if (total == my_input_number) {
            System.out.println("bilangan merupakan armstrong");
        } else {
            System.out.println("bilangan bukan armstrong");
        }
    }

}
