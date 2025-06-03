package Activity;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class File_Handling_Read {
    public static void main(String[] args) {
        try {
            // System.out.println("Current working directory: " + System.getProperty("user.dir"));
            File obj = new File("../data/myfile.txt");
            Scanner reader = new Scanner(obj);
            while (reader.hasNextLine()) {
                String data = reader.nextLine();
                System.out.println(data);
            }
            reader.close();
        } catch (FileNotFoundException e) {
            System.out.println("an error has occured");
            e.printStackTrace();
       }
    }

}
