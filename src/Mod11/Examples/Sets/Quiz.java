package Mod11.Examples.Sets;

import java.util.*;

public class Quiz {
    public static void main(String[] args) {

//      Задание 11.5.5
        Deque<Integer> queue = new ArrayDeque<>();
        queue.push(1);
        queue.push(2);
        queue.push(3);

        Set<Integer> set = new LinkedHashSet<>(queue); // 1

        System.out.println(set);

//        Задание 11.5 .6
        Set<String> set1 = new HashSet<>();

        set1.add("Hello");
        set1.add("Hello again");
        set1.add("Hello");

        System.out.println(set1);

//        Задание 11.5 .7
        Set<Double> set7 = new TreeSet<>();

        set7.add(21.5);
        set7.add(14.2);
        set7.add(8d); // 1
        set7.add(8.0);

        System.out.println(set7);
    }
}
