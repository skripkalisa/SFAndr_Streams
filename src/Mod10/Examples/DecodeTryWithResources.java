package Mod10.Examples;

import java.io.*;
import java.nio.charset.Charset;
import java.nio.charset.UnsupportedCharsetException;

public class DecodeTryWithResources {
    public static void main(String[] args) {
        if(copyFileUsingStream("src/Mod10/Examples/borodino-cp1251.txt",
                "windows-1251",
                "src/Mod10/Examples/borodino-utf8.txt",
                "utf-8")){
            System.out.println("File successfully decoded!");
        }
    }

    private static boolean copyFileUsingStream(String source, String sourceEnc,
                                               String  dest, String destEnc) {

        try (Reader fis = new InputStreamReader(new FileInputStream(new File(source)),
                sourceEnc);
             Writer fos = new OutputStreamWriter(new FileOutputStream(new File(dest)),
                     destEnc)) {
            /* все открылось, можно копировать */

            char[] buffer = new char[1024];
            int length;
            while ((length = fis.read(buffer)) > 0) {
                fos.write(buffer, 0, length);
            }
        }
        catch (FileNotFoundException ex){
            System.out.println("Не удалось открыть файл " + ex.getMessage());
            return false;
        }
        catch (UnsupportedEncodingException ex) {
            System.out.println("Указана неизвестная кодировка " + ex.getMessage());
            return false;
        }
        catch (IOException ex){
            System.out.println("Возникла ошибка при копировании");
            return false;
        }
        return true;
    }
}
