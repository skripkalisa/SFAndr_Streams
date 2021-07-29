package Mod11.Examples.Maps;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.TreeMap;

public class Quiz {
    public static void main(String[] args) {

//        Задание 11.6.1
        Map<Person, Integer> people = new LinkedHashMap<>();

        people.put(new Person(17, "John"), 4);
        people.put(new Person(17, "John"), 28);

        System.out.println(people.keySet());

//        Задание 11.6.2
//        Map<Main, Integer> map = new TreeMap<>();
//        map.put(new Main(), 2);
//        map.put(new Main(), 4);
//        System.out.println(map.size()); // Бросает ошибку при запуске

//        Задание 11.6.3
        Map<String, Integer> map = new HashMap<>();

        map.put("One", 1);
        map.put("Two", 2);
        map.put("Three", 3);

        map.remove(new String("One"));

        System.out.println(map.containsKey("One"));

//        Задание 11.6.4
        Map<Integer, String> winners = new TreeMap<>(); // ваш код тут

        winners.put(3, "Вася");
        winners.put(1, "Федя");
        winners.put(2, "Антон");

        printWinners(winners);
    }

    private static void printWinners(Map<Integer, String> winners) {
        for (Map.Entry<Integer, String> entry : winners.entrySet()) {
            System.out.println(entry.getKey() + " место занял " + entry.getValue());
        }
    }
}
