package Mod10.Task;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        System.out.println("Эта программа ищет числа в указанном файле и использует их для решения задачи.");
        File file = new File("D:\\sample.txt");
      //Instantiating the PrintStream class
      PrintStream stream = new PrintStream(file);
        System.setOut(stream);
        String fileName = getFile();
        if (fileName != null)
            fileParser(fileName);
        System.out.println("Программа завершила работу");
    }

    private static String getFile() {
        Scanner input = new Scanner(System.in);
        System.out.print("Введите имя файла: ");
        String fileName = null;
        fileName = input.next();
        try {
            File f = new File(fileName);
            if (!f.exists() || f.isDirectory())
                throw new YouShallNotPass("Нет такого файла или путь указан неверно.");
//            if (!f.exists() || f.isDirectory())
        } catch (YouShallNotPass e) {
            System.out.println("YouShallNotPass сообщает: " + e.getMessage());
            fileName = null;
        }
        return fileName;
    }

    private static void fileParser(String fileName) {
        float[] args = new float[3];
        int i = 0;
        String word = null;
        Scanner s = null;
        try {
            s = new Scanner(new File(fileName));

            while (s.hasNext()) {
                word = s.next().replaceAll("[^a-zA-Zа-яА-Я0-9]", "").toLowerCase();
                try {
                    float temp = getNumber(word);
                    if (temp != 0) {
                        args[i] = temp;
                        i++;
                    } else if (wordParser(word)) {
                        args[i] = Float.parseFloat(word);
                        i++;
                    }
                } catch (ArrayIndexOutOfBoundsException e) {
                    e.getMessage();
                }
            }
        } catch (FileNotFoundException e) {
            System.out.println("Что-то пошло не так. " + e.getMessage());
        } finally {
            System.out.println("В файле " + fileName + " удалось найти такие числа: ");
            for (int j = 0; j < args.length; j++)
                System.out.print(args[j] + " ");
        }
        Equation eq = new Equation(args);
        eq.equation();
    }

    private static float getNumber(String word) {
        float x = 0;
        switch (word) {
            case "один", "одна", "одного", "одной", "одним", "одному", "однажды", "раз" -> x = 1;
            case "два", "две", "двое", "двумя", "двоим", "двоих", "двойной", "двойная", "двойные", "дважды" -> x = 2;
            case "три", "трое", "трем", "тремя", "троим", "третий", "третья", "третьи", "трижды" -> x = 3;
            case "четыре" -> x = 4;
            case "пять" -> x = 5;
            case "шесть" -> x = 6;
            case "семь" -> x = 7;
            case "восемь" -> x = 8;
            case "девять" -> x = 9;
            case "десять" -> x = 10;
            default -> x = 0;
        }
        return x;
    }

    private static boolean wordParser(String word) {
//        System.out.println("wordParser is called");
        try {
            Float.parseFloat(word);
//            System.out.println("f = " + word);
            return true;

        } catch (NumberFormatException e) {
            e.getMessage();
            return false;
        }
    }
}

//
//        try (Reader fis = new InputStreamReader(new FileInputStream(fileName))){
//
//            char[] buffer = new char[1024];
//            int length;
//            int i = 0;
//            while ((length = fis.read(buffer)) > 0) {
//                System.out.println(Integer.toString(i) + " " + buffer.toString());
//                i++;
////                fos.write(buffer, 0, length);
//            }
//        } catch (FileNotFoundException e) {
//            e.printStackTrace();
//        } catch (IOException e) {
//            e.printStackTrace();
//        }

//        Writer fos = new OutputStreamWriter(new FileOutputStream(new File(dest)));

//    }
//
//            }
