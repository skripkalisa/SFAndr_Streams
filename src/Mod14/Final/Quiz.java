package Mod14.Final;

import java.util.stream.Stream;

public class Quiz {
/*     Задание 2

    Каков результат выполнения данного кода?*/

    public static void main(String[] args) {
        Stream<String> stream = Stream.iterate("", (s) -> s + "1");
        System.out.println(stream.limit(2).map(x -> x + "2"));
    }
}
