package Mod9.Tests;

import java.io.FileOutputStream;
import java.util.Formatter;

public class Test {
    public static void main(String[] argv) throws Exception {
        Formatter fmtCon = new Formatter(System.out);
        Formatter fmtFile;
        fmtFile = new Formatter(new FileOutputStream("test.fmt"));
        fmtCon.format("a negative number: %(.2f\n\n", -123.34);
        fmtCon.format("%8s %8s\n", "Value", "Square");

        for (int i = 1; i < 20; i++)
            fmtCon.format("%8d %8d\n", i, i * i);

        // write to the file.
        fmtFile.format("This is a negative number: %(.2f\n\n", -123.34);

        fmtFile.format("%8s %8s\n", "Value", "Square");
        for (int i = 1; i < 20; i++)
            fmtFile.format("%8d %8d\n", i, i * i);

        fmtFile.close();

        if (fmtFile.ioException() != null) {
            System.out.println("File I/O Error Occurred");
        }
    }
}
