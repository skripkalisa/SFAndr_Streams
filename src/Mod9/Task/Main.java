package Mod9.Task;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Formatter;
import java.util.Scanner;


public class Main {
    public static void main(String[] args) throws IOException {
        System.out.println("Эта программа генерирует два списка с номерами телефонов и выводит их в файлы");
        String fileMask = "mask.txt";
        String fileUser = "user_mask_list.txt";
        String fileNormal = "normal_phones_list.txt";
        String fileGolden = "golden_phones_list.txt";
        try {
            File f = new File(fileMask);
            if (!f.exists() || f.isDirectory()) f.createNewFile();
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }

        FileInputStream fisMask = new FileInputStream(fileMask);
        FileOutputStream fosMask = new FileOutputStream(fileUser);
        FileOutputStream fosNormal = new FileOutputStream(fileNormal);
        FileOutputStream fosGolden = new FileOutputStream(fileGolden);
        makeLists(fosNormal, fosGolden, fisMask, fosMask);
    }


    protected static void makeLists(FileOutputStream fosNormal, FileOutputStream fosGolden, FileInputStream fisMask, FileOutputStream fosMask) throws IOException {
        Formatter fmtNormal = new Formatter(fosNormal);
        Formatter fmtGolden = new Formatter(fosGolden);
        Formatter fmtUserMask = new Formatter(fosMask);
        char[] n = new char[7];
        char[] m = new char[4];
        String userMask = "";

        Scanner input = new Scanner(System.in);
        String choice = chooseMask(input);

        do {
            System.out.println("Choice is " + choice);

            switch (choice) {
                case "1" ->
                        userMask = getUserMask(input);
                case "2" ->
                        userMask = readFromFile(fisMask, userMask);
                default -> choice = chooseMask(input);
            }
        } while (!choice.equals("1") && !choice.equals("2"));


        for (int i = 0; i < 4; i++) {
            m[i] = userMask.charAt(i);
        }

        for (int i = 0; i < 10000; i++) {
            Formatter buffer = new Formatter();
            buffer.format("%07d", i);
            System.out.println(buffer);

            for (int j = 0; j < 7; j++) {
                n[j] = buffer.toString().charAt(j);
            }

            var format = "+7(9xx)" + n[0] + n[1] + n[2] + "-" + n[3] + n[4] + "-" + n[5] + n[6] + "\n";
            fmtNormal.format(format);
            if (n[0] == n[1] && n[1] == n[2] && n[3] == n[4] && n[5] == n[6]) {
                fmtGolden.format(format);
            }
            if (n[3] == m[0] && n[4] == m[1] && n[5] == m[2] && n[6] == m[3]) {
                fmtUserMask.format(format);
            }
        }

        fmtNormal.close();
        fmtGolden.close();
        fmtUserMask.close();
    }

    private static String getUserMask(Scanner input) {

        System.out.print("Укажите последние 4 цифры номера: ");
        String kb = input.next();
        while (!isValid(kb, 4)) {
            System.out.print("Нужно ввести 4 цифры: ");
            kb = input.next();
        }
        System.out.println("Out of while");
        return kb;
    }

    private static String readFromFile(FileInputStream fisMask, String mask) throws IOException {
        int c, d = 0;

        while ((c = fisMask.read()) != -1) {

            if (c >= '0' && c <= '9') {
                mask += (char) c;
                System.out.print("m[d] = " + mask + " ");

            }
            if (mask.length() > 4) {
                fisMask.close();
                break;
            }
        }
        return mask;
    }

    private static String chooseMask(Scanner input) {
        System.out.print("Ввести маску номера вручную(1) или загрузить из файла(2)? : ");
        String kb = input.next();
        while (!isValid(kb, 1)) {
            System.out.print("1 - ввести вручную, 2 - загрузить из файла: ");
            kb = input.next();
        }
        return kb;
    }

    private static boolean isValid(String input, int length) {
        if (input.length() != length)
            return false;
        try {
            Integer i = Integer.parseInt(input);
        } catch (NumberFormatException e) {
            return false;
        }
        return true;
    }
}
