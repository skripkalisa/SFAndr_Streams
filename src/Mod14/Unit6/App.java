package Mod14.Unit6;

import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

public class App {
  /*
    Задание 14.6.4

    Создайте текстовый файл с таким содержимым:

    1
    12
    123
    1234
    12345
    123456
    1234567
    12345678
    123456789

    Теперь запишите содержимое этого файла в другой файл со строками,
    записанными в обратном порядке.
   */


    public static void main(String[] args) throws IOException {
        Path path = Paths.get("src/Mod14/Unit6/task.txt"); // берем существующий файл
        List<String> contents = Files.readAllLines(path); // читаем в лист в память программы

        try (BufferedWriter writer = Files.newBufferedWriter(Paths.get("src/Mod14/Unit6/task-reversed"))) { // пишем в новый файл
            for (int index = contents.size() - 1; index >= 0; index--) { // создаем цикл с обратным порядком
                writer.write(contents.get(index));
                writer.write("\n"); // не забываем про перенос строки
            }
        } catch (IOException exception) {
            exception.printStackTrace();
        }
    }

}
