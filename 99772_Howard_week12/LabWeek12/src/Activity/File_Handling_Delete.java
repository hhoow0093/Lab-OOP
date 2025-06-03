package Activity;
import java.io.File;
public class File_Handling_Delete {
    public static void main(String[] args) {
        File obj = new File("../data/myfile.txt");
        if (obj.delete()) {
            System.out.println("the deleted file is : " + obj.getName());

        } else {
            System.out.println("Failed deleting file");
        }
    }

}
