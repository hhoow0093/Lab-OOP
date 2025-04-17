package Tugas;

import java.util.Stack;
import java.util.Scanner;
public class Kurungan {
    public static void main(String[] args) {
        Stack<Character> s = new Stack<>();
        Scanner scanner = new Scanner(System.in);
        System.out.print("masukkan kurung '{' atau '}': ");
        String kurung = scanner.nextLine();
        for (int i = 0; i < kurung.length(); i++) {
            if (kurung.charAt(i) == '{') {
                s.push('{');
            } else if (kurung.charAt(i) == '}') {
                s.pop();
            }
        }

        if (s.empty()) {
            System.out.println("True, maka valid pada kurung checker");
        } else {
            System.out.println("False, tidak valid pada kurung checker");
        }
        
    }

}
