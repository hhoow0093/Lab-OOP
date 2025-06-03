package Activity2;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

public class ObjectToFile {
    public static void main(String[] args) {
        Person person = new Person("John doe", 17, "Universitas Multimedia nusantara");

        try (FileOutputStream fileout = new FileOutputStream("../data/person.ser");
                ObjectOutputStream out = new ObjectOutputStream(fileout)) {
            out.writeObject(person);
            System.out.println("serialized data is saved in person.ser");

        } catch (IOException i) {
            i.printStackTrace();
        }
    }

}
