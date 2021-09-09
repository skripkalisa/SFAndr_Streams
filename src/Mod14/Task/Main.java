package Mod14.Task;

import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.IntStream;


public class Main {

    public static void main(String[] args) throws IOException {

        Scanner input = new Scanner(System.in);
        final LocalDateTime now = LocalDateTime.now();

        final DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd.MM.yyyy-HH:mm:ss");
        String timeStamp = dtf.format(now);
        System.out.println("Йода говорит");
        System.out.println("Эта программа запрашивает имя файла, путь к нему и переставляет слова в обратном порядке.");
        System.out.print("Введите имя файла: ");
        String file = input.next();
        String fileName = getJustName(file);
        System.out.print("Введите путь/к/файлу: ");
        String path = input.next();


        Path userFile = Paths.get(path + "/" + file);
        if(Files.notExists(userFile)){
            System.out.println("Файл не найден. Программа завершила работу");
            return;
        }

        List<String> contents = Files.readAllLines(userFile);
        try (BufferedWriter writer = Files.newBufferedWriter(Paths.get(path + "/" + fileName + "_" + timeStamp + ".txt"))) { // пишем в новый файл
            writer.write("И молвил Йода человеческим голосом:\n\n");
            for (String content : contents) {
                writer.write(reverseWordsInString(content));
                writer.write("\n");
            }
        } catch (IOException exception) {
            exception.printStackTrace();
        }
    }

    private static String getJustName(String fileName) {
        if (fileName.indexOf(".") > 0) return fileName.substring(0, fileName.lastIndexOf("."));
        else return fileName;
    }

    private static String reverseWordsInString(String str) {
        String[] line = str.split(" ");
        return IntStream.iterate(line.length - 1, i -> i >= 0, i -> i - 1)
                .mapToObj(i -> line[i] + " ")
                .collect(Collectors.joining());
    }
}
