package Tugas;
import java.util.*;

public class NameGenerator {
    private static List<String> firstNames = new ArrayList<>();
    private static List<String> middleNames = new ArrayList<>();
    private static List<String> lastNames = new ArrayList<>();

    public static void addFirstName(String fn) {
        firstNames.add(fn);
    }

    public static void addMiddleName(String Mn) {
        middleNames.add(Mn);
    }

    public static void addLastName(String Ln) {
        lastNames.add(Ln);
    }

    public static String getRandomName() {
        Random random = new Random();
        int random_number_Fn = random.nextInt(firstNames.size());
        int random_number_Mn = random.nextInt(middleNames.size());
        int random_number_Ln = random.nextInt(lastNames.size());

        return String.format("%s %s %s", firstNames.get(random_number_Fn), middleNames.get(random_number_Mn),
                lastNames.get(random_number_Ln));
    }
    
    public static void SeedName() {
        addFirstName("Howard");
        addFirstName("Howar");
        addFirstName("Howa");
        addFirstName("How");
        addFirstName("Ho");
        addFirstName("H");
        addFirstName("A");
        addFirstName("Ab");
        addFirstName("Abe");
        addFirstName("Abel");
        addMiddleName("Christopher");
        addMiddleName("Christophe");
        addMiddleName("Christoph");
        addMiddleName("Christop");
        addMiddleName("Christo");
        addMiddleName("Christ");
        addMiddleName("Chris");
        addMiddleName("Chri");
        addMiddleName("Chr");
        addMiddleName("Ch");
        addLastName("Harsono");
        addLastName("Harson");
        addLastName("Harso");
        addLastName("Hars");
        addLastName("Har");
        addLastName("Ha");
        addLastName("H");
        addLastName("O");
        addLastName("Oj");
        addLastName("Oje");
    }

    public static void main(String[] args) {
        SeedName();
        for (int i = 0; i < 10; i ++){
            System.out.println(getRandomName());
        }
    }
    

}
