import java.util.ArrayList;
import java.util.Scanner;

import exceptions.*;

public class Main {
    private static ArrayList<User> userlist = new ArrayList<>();
    public static void initialize() {
        String nama_depan = "John";
        String nama_belakang = "Doe";
        Character kelamin = 'L';
        String alamat = "Jl. Merpati No. 1 RT 1 RW 1, Banten.";
        String username = "admin";
        String password = "admin";
        userlist.add(new User(nama_depan, nama_belakang, kelamin, alamat, username, password));

    }

    public static boolean handleLogin(String username, String password) {
        boolean flag = false;
        for (int i = 0; i < userlist.size(); i++) {
            if (username.equals(userlist.get(i).getUsername())) {
                try {
                    flag = userlist.get(i).login(username, password);
                } catch (ExcessiveFailedLoginException e) {
                    System.out.println("Login failed excessively: " + e.getMessage());
                } catch (AuthenticationException e) {
                    System.out.println("Login failed authentication: " + e.getMessage());
                }
            }
        }
        return flag;
    }
    private static boolean check(String password) {
        boolean hasCapital = false;
        boolean hasNumber = false;
        for (char c : password.toCharArray()) {
            if (Character.isUpperCase(c)) {
                hasCapital = true;
            }

            if (Character.isDigit(c)) {
                hasNumber = true;
            }
        }
        return hasCapital && hasNumber;
    }
    
    public static boolean handleSignUp(String fname, String lname, Character gender, String addr, String uname,
            String passowrd) throws InvalidPropertyException {
        if (uname.length() <= 8) {
            throw new InvalidPropertyException("Username harus lebih dari 8 karakter");
        }
        if (passowrd.length() > 16) {
            throw new InvalidPropertyException("password harus mengandung hruf besar, angka, dan maksimum 16 karakter");
        }
        boolean checkHurufAngka = check(passowrd);
        if (!checkHurufAngka) {
            throw new InvalidPropertyException("password harus mengandung hruf besar, angka, dan maksimum 16 karakter");
        }
        if (checkHurufAngka && uname.length() > 8 && passowrd.length() <= 16) {
            userlist.add(new User(fname, lname, gender, addr, uname, passowrd));
            return true;
        }

        return false;
    }
    
    public static void viewMenu() {
        System.out.println("1. Login");
        System.out.println("2. sign up");
        System.out.print("Pilihan: ");
    }

    public static void mylogin(Scanner scanner) {
        scanner.nextLine();
        String username;
        String password;
        System.out.print("username: ");
        username = scanner.nextLine();
        System.out.print("password: ");
        password = scanner.nextLine();
        boolean flag = handleLogin(username, password);
        if (flag) {
            for (int i = 0; i < userlist.size(); i++) {
                if (username.equals(userlist.get(i).getUsername())) {
                    System.out.println(userlist.get(i).greeting());
                }
            }
        } else {
            System.out.println("login fail");
        }

    }
    
    public static void mySignUp(Scanner scanner) {
        scanner.nextLine();
        String username;
        String password;
        String address;
        Character gender;
        String fname;
        String lname;
        System.out.print("username: ");
        username = scanner.nextLine();
        System.out.print("password: ");
        password = scanner.nextLine();
        System.out.print("address: ");
        address = scanner.nextLine();
        System.out.print("first name: ");
        fname = scanner.nextLine();
        System.out.print("last name: ");
        lname = scanner.nextLine();
        System.out.print("gender (M / F): ");
        gender = scanner.nextLine().charAt(0);
        boolean flag = false;
        try {
            flag = handleSignUp(fname, lname, gender, address, username, password);
        } catch (InvalidPropertyException e) {
            System.out.println("Sign-up failed: " + e.getMessage());
        }

        if (flag) {
            System.out.println("sign up successs");
        } else {
            System.out.println("sign up failure");
        }


    }

    public static void main(String[] args) {
        initialize();
        boolean program_running = true;
        int pilihan;
        Scanner scanner = new Scanner(System.in);
        while (program_running) {
            viewMenu();
            pilihan = scanner.nextInt();
            switch(pilihan){
                case 1:
                    mylogin(scanner);
                    break;
                case 2:
                    mySignUp(scanner);
                    break;
                default:
                    program_running = false;
                    break;
            }
        }
        
    }
    
}
