package Activity2;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectInputStream;

public class ObjectFromFile {
    public static void main(String[] args) {
        Person person = null;

        try (FileInputStream fileIn = new FileInputStream("../data/person.ser");
        ObjectInputStream in = new ObjectInputStream(fileIn)
        ) {
            person = (Person) in.readObject();
        }
        catch (IOException i) {
            i.printStackTrace();
        } 
        catch (ClassNotFoundException c) {
            System.out.println("person class not found");
            c.printStackTrace();
        }
        System.out.println("deserialized person");
        System.out.println("name: " + person.getName());
        System.out.println("age: " + person.getAge());
        System.out.println("campus: " + person.getCampus());
    }

}
