package Mod10.Examples;

import java.io.*;

class DecodeException extends Exception {

    public DecodeException(String message) {
        super(message);
    }
}

public class DecodeTWRRefactored {
    public static void main(String[] args) {
        try {
            copyFileUsingStream("src/Mod10/Examples/borodino-cp1251.txt",
                    "windows-1251",
                    "src/Mod10/Examples/borodino-utf8.txt",
                    "utf-8");
            System.out.println("File successfully decoded!");
        } catch (DecodeException e) {
//            e.printStackTrace();
            System.out.println(e.getMessage());
        }

    }

    private static void copyFileUsingStream(String source, String sourceEnc,
                                            String dest, String destEnc) throws DecodeException {

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
        } catch (FileNotFoundException ex) {
            throw new DecodeException("Не удалось открыть файл " + ex.getMessage());
        } catch (UnsupportedEncodingException ex) {
            throw new DecodeException("Указана неизвестная кодировка " + ex.getMessage());
        } catch (IOException ex) {
            throw new DecodeException("Возникла ошибка при копировании" + ex.getMessage());
        }
        return;
    }
}
