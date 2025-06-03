package Activity;

import java.io.FileWriter;
import java.io.IOException;

public class File_Handling_Write {
    public static void main(String[] args) {
        try {
            FileWriter Writer = new FileWriter("../data/myfile.txt");
            Writer.write("nama saya john doe\n");
            Writer.write("saya dari universitas multimedia nusantara");
            Writer.close();
            System.out.println("succesfully written");
        } catch (IOException e) {
            System.out.println("an error has occured");
            e.printStackTrace();
        }        
    }

}
