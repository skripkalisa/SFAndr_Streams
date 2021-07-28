package Mod10.Task;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintStream;
import java.io.PrintWriter;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        System.out.println("Эта программа ищет числа в указанном файле и использует их для решения задачи.");
        PrintWriter outputFile = null;
        try {
            outputFile = new PrintWriter("src/Mod10/Task/output.txt");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        //Этим способом вывод в консоль перехватывается и перенаправляется в файл.
        // Сообщения в консоль не выводятся.
        // Зато способ менее громоздкий.
//        PrintStream stream = null;
//        try {
//            stream = new PrintStream(String.valueOf(outputFile));
//        } catch (FileNotFoundException e) {
//            e.getMessage();
//        }
        String fileName = getFile(outputFile);
        if (fileName != null) {
//            System.setOut(stream); // для перехвата консольных сообщений
            fileParser(fileName, outputFile);
        }

        output("Программа завершила работу", System.out, outputFile);
        outputFile.close();
    }

    private static String getFile(PrintWriter outputFile) {
        Scanner input = new Scanner(System.in);
        output("Введите имя файла: ", System.out, outputFile);
        String fileName = null;
        fileName = input.next();
        try {
            File f = new File(fileName);
            if (!f.exists() || f.isDirectory())
                throw new YouShallNotPass("Нет такого файла или путь указан неверно.");
        } catch (YouShallNotPass e) {
            output("YouShallNotPass сообщает: " + e.getMessage(), System.out, outputFile);
            fileName = null;
        }
        return fileName;
    }

    private static void fileParser(String fileName, PrintWriter outputFile) {
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
            output("Что-то пошло не так. " + e.getMessage(), System.out, outputFile);
        } finally {
            output("В файле " + fileName + " удалось найти такие числа: ", System.out, outputFile);
            for (int j = 0; j < args.length; j++)
                output(args[j] + " ", System.out, outputFile);
        }
        Equation eq = new Equation(args, outputFile);
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

    protected static void output(final String msg, PrintStream out1, PrintWriter out2) {
        out1.println(msg);
        out2.println(msg);
    }
}
