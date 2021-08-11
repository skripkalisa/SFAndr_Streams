package Mod14.Unit6;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class Examples2 {
    public static void main(String[] args) {

//        Проверка на существование файла

        boolean exists1 = Files.exists(Paths.get("/ostrich/feathers.png"));
        boolean exists2 = Files.exists(Paths.get("/ostrich"));
        System.out.println(exists1);
        System.out.println(exists2);


//Проверка на уникальность двух файлов (или папок)
// Представим, что в коде ниже все папки существуют и
// cobra — это символическая ссылка на snake.
        try {
            Files.isSameFile(Paths.get("/user/home/cobra"), Paths.get("/user/home/snake")); // true
            Files.isSameFile(Paths.get("/user/tree/../monkey"), Paths.get("user/monkey")); // true
        } catch (IOException e) {
            // Handle file I/O exception
        }

//        Создание директорий

        try {
            Files.createDirectory(Paths.get("bison/field"));
            Files.createDirectories(Paths.get("bison/field/pasture/green"));
        } catch (IOException e) {
            // Handle file I/O exception
        }


//        Копирование содержимого файла из одного в другой

        try {
            Files.copy(Paths.get("/panda"), Paths.get("/panda-save"));
            Files.copy(Paths.get("panda/bamboo.txt"), Paths.get("panda-save/bamboo.txt"));
        } catch (IOException e) {
            // Handle file I/O exception
        }


//        Перемещение/переименование файла или директории

        try {
            Files.move(Paths.get("c:\\zoo"), Paths.get("c:\\zoo-new"));
            Files.move(Paths.get("c:\\zoo\\addresses.txt"), Paths.get("c:\\zoo-new\\addresses.txt"));
        } catch (IOException e) {
            // Handle file I/O exception
        }


//        Удаление файлов и папок

        try {
            Files.delete(Paths.get("vulture/feathers.txt"));
            Files.deleteIfExists(Paths.get("pigeon"));
        } catch (IOException e) {
            // Handle file I/O exception
        }


//        Чтение и запись

        Path path = Paths.get("/animals/gopher.txt");
        try (BufferedReader reader = Files.newBufferedReader(path, StandardCharsets.US_ASCII)) { // Выбираем кодировку файла
            // читаем со стрима
            String currentLine = null;
            while ((currentLine = reader.readLine()) != null) {
                System.out.println(currentLine);
            }
        } catch (IOException e) {
            // Handle file I/O exception
        }

        Path path2 = Paths.get("/animals/gorilla");
        List<String> data = new ArrayList<>();
        try (BufferedWriter writer = Files.newBufferedWriter(path2, Charset.defaultCharset())) {
            writer.write("Hello World");
        } catch (IOException e) {
            // Handle file I/O exception
        }
        System.out.println(data);


//        Другой способ чтения файла

        Path path3 = Paths.get("fish/sharks.log");
        try {
            List<String> lines = Files.readAllLines(path3); // сохраняем строки из файла в лист
            for (String line : lines) {
                System.out.println(line); // выводим содержимое на консоль
            }
        } catch (IOException exception) {
            // Handle file I/O exception
        }


    }
}
