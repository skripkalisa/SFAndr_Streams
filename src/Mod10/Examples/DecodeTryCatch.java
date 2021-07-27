package Mod10.Examples;

import java.io.*;
import java.nio.charset.Charset;
import java.nio.charset.UnsupportedCharsetException;

public class DecodeTryCatch {
    public static void main(String[] args) {
        if(copyFileUsingStream(new File("src/Mod10/Examples/borodino-cp1251.txt"),
                Charset.forName("windows-1251"),
                new File("src/Mod10/Examples/borodino-utf8.txt"),
                Charset.forName("utf-8"))){
            System.out.println("File successfully decoded!");
        }
    }

    private static boolean copyFileUsingStream(File source, Charset sourceEnc, File dest, Charset destEnc) {
        Charset sEnc = null;
        try {
            sEnc = Charset.forName(String.valueOf(sourceEnc));
        } catch (UnsupportedCharsetException e) {
            System.out.println("Wrong input file charset!");
            return false;
        }
        Charset dEnc = null;
        try {
            dEnc = Charset.forName(String.valueOf(destEnc));
        } catch (UnsupportedCharsetException e) {
            System.out.println("Wrong output file charset!");
            return false;
        }

        Reader fis = null;
        try {
            fis = new InputStreamReader(new FileInputStream(source), sourceEnc);
        } catch (FileNotFoundException e) {
            System.out.println("Input file not found.");
            return false;
        }

        Writer fos = null;
        try {
            fos = new OutputStreamWriter(new FileOutputStream(dest), destEnc);
        } catch (FileNotFoundException e) {
            System.out.println("Output file not found.");
            return false;
        }


        char[] buffer = new char[1024];
        int length;

        try {
            while ((length = fis.read(buffer)) > 0) {
                fos.write(buffer, 0, length);
            }
        } catch (IOException e) {
            System.out.println("Can't write to file");
            return false;
        }

//        while ((length = fis.read(buffer)) > 0) {
//            fos.write(buffer, 0, length);
//        }
        finally {
            try {
                fis.close();
                fos.close();
            } catch (IOException e) {
                System.out.println("Can't close files.");
                return false;
            }
        }
        return true;
    }
}
