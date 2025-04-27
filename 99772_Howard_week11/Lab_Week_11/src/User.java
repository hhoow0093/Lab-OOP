import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;

import exceptions.*;

public class User {
    private String firstName;
    private String lastName;
    private Character gender;
    private String address;
    private String username;
    private String password;
    private MessageDigest digest;

    private static final int maxLogin = 3;
    private static int loginAttempts;

    private String hash(String strToHash) {
        try {
            digest = MessageDigest.getInstance("SHA-256");
            byte[] hash = digest.digest(strToHash.getBytes(StandardCharsets.UTF_8));
            StringBuilder sb = new StringBuilder();
            for (byte b : hash) {
                sb.append(String.format("%02x", b));
            }
            return sb.toString();
        } catch (Exception ex) {
            ex.printStackTrace();

        }
        return "";
    }

    public User(String fname, String lname, Character gender, String addr, String uname, String pword) {
        this.firstName = fname;
        this.lastName = lname;
        this.gender = gender;
        this.address = addr;
        this.username = uname;
        this.password = hash(pword);
    }

    public boolean login(String username, String password)
            throws ExcessiveFailedLoginException, AuthenticationException {
        if (loginAttempts > maxLogin) {
            throw new AuthenticationException();
        }
        if (this.username.equals(username)) {
            if (loginAttempts == maxLogin) {
                loginAttempts++;
                throw new ExcessiveFailedLoginException();
            } else if (loginAttempts > maxLogin) {
                throw new ExcessiveFailedLoginException("Anda telah mencapai batas login");
            }

            if (this.password.equals(hash(password))) {
                loginAttempts = 0;
                return true;
            } else {
                System.out.println("pasword yang anda masukkan salah");
                System.out.print("kesempatan anda login : " + (maxLogin - loginAttempts));
                System.out.println(" kali lagi");
                loginAttempts++;
            }
        }
        if (!this.username.equals(username)) {
            throw new AuthenticationException("username salah");
        }

        return false;
    }
    
    

    public String greeting() {
        String greet = "Selamat Datang! ";
        switch (gender) {
            case 'L':
                greet += "Tuan ";
                break;
            case 'P':
                greet += "Nona ";
                break;
            default:
                break;
        }
        greet += this.firstName + " " + this.lastName + " alamatmu adalah: " +  this.address;
        return greet;
    }

    public String getUsername() {
        return username;
    }



}
