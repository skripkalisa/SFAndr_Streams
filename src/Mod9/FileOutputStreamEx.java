package Mod9;

import java.io.*;

public class FileOutputStreamEx {
    public static void main(String[] args) throws IOException {
//        FileOutputStream fos = new FileOutputStream("test.txt");
//        fos.write("Hello FileOutputStream world".getBytes("UTF-8"));
//        fos.close();
        copyFileUsingStream("src/Mod9/OZMain.java", "java.txt");
    }
    protected static void copyFileUsingStream(String source, String dest) throws IOException {
        System.out.println("I'm runnig!");
    InputStream fis = new FileInputStream(source);
    OutputStream fos = new FileOutputStream(dest);
    byte[] buffer = new byte[1024];
    int length;
    while ((length = fis.read(buffer)) > 0) {
            fos.write(buffer, 0, length);
    }
    fis.close();
    fos.close();
}
}
//BKmLgZfk4TXc2Bu
