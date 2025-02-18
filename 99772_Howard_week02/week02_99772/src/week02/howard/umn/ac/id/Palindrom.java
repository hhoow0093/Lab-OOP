package week02.howard.umn.ac.id;
import java.util.Scanner;

public class Palindrom {
    public static boolean palindrom(String input, int lengthString) {
        boolean flag = true;
        if (lengthString % 2 != 0) {
            int middle = (lengthString / 2) + 1;
            int left = 0;
            int right = lengthString - 1;
            while (input.charAt(left) == input.charAt(right)) {
                if (right == middle || left == middle) {
                    return flag;
                } else {
                    right--;
                    left++;
                }
            }
            flag = false;
            return flag;
            
        } else {
            int left = 0;
            int right = lengthString - 1;
            while (input.charAt(left) == input.charAt(right)) {
                if (left + 1 == right) {
                    return flag;
                } else {
                    right--;
                    left++;
                }
            }
            flag = false;
            return flag;
            
        }

    }
    public static void main(String[] args) {
        String input;
        Scanner scanner = new Scanner(System.in);
        
        System.out.print("masukkan string: ");
        input = scanner.nextLine();
        int LengthString = input.length();
        boolean Answer = palindrom(input, LengthString);
        if (Answer) {
            System.out.println(String.format("input %s marupakan palindrom", input));
        } else {
            System.out.println(String.format("input %s bukan palindrom", input));
        }
    }

}
