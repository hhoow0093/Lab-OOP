package Activity;
import java.io.File;
import java.io.IOException;

public class File_Handling {
    public static void main(String[] args) {
        // System.out.println("Current working directory: " + System.getProperty("user.dir"));
        File obj = new File("../data/myfile.txt");
        try {
            if (obj.createNewFile()) {
                System.out.println("File created: " + obj.getName());
            } else {
                System.out.println("file already exist");
            }

        } catch (IOException e) {
            System.out.println("an error has occured");
            e.printStackTrace();
       }
    }

}
