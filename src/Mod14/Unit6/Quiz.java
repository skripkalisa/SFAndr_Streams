package Mod14.Unit6;

import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;

public class Quiz {
    public static void main(String[] args) {


//        Задание 14.6 .3

//Представим, что у нас есть файл по пути
// /home/documents/doc.txt.
// Наша текущая директория
// /home/pictures/photos.
// Напишите, что выведет в консоль данный код:

        try {
            Path path = Paths.get("./../documents/./doc.txt").toRealPath();
            System.out.println(path);
        } catch (IOException e) {
            System.out.println("Ошибка");
        }
    }
}
