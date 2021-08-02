package Mod8.Files;

import java.io.File;
import java.io.IOException;

public class FileMethods {
    public static void main(String[] args) {
        File file = new File( "src/Mod8/Test.txt");
        try {
            file.createNewFile();
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println(file.getAbsolutePath());

        System.out.println(file.exists());//true

    }
}
