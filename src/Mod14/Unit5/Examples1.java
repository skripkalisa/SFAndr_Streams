package Mod14.Unit5;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.function.Predicate;
import java.util.stream.Stream;

public class Examples1 {
    public static void main(String[] args) {
//        1
        System.out.println("Example 1");
        List<String> list = Arrays.asList("monkey", "2", "chimp");
        Stream<String> infinite = Stream.generate(() -> "chimp"); // бесконечный стрим строки
        Predicate<String> pred = x -> Character.isLetter(x.charAt(0)); // проверка - первый символ - буква
        System.out.println(list.stream().anyMatch(pred)); // true
        System.out.println(list.stream().allMatch(pred)); // false
        System.out.println(list.stream().noneMatch(pred)); // false
        System.out.println(infinite.anyMatch(pred)); // true

//        2
        System.out.println("Example 2");
        Stream<String> s = Stream.of("monkey", "gorilla", "bonobo");
        System.out.println(s.count()); // 3

//        3
        System.out.println("Example 3");
        Stream<String> st = Stream.of("monkey", "ape", "bonobo");
        Optional<String> min = st.min((s1, s2) -> s1.length() - s2.length());
// минимум по длине
        min.ifPresent(System.out::println); // ape

//        4
        System.out.println("Example 4");
        Stream<String> stream = Stream.of("monkey", "gorilla", "bonobo");
        Stream<String> inf = Stream.generate(() -> "chimp");
        stream.findAny().ifPresent(System.out::println); // monkey
        inf.findAny().ifPresent(System.out::println); // chimp

//        5
        System.out.println("Example 5");
        Stream<String> printable = Stream.of("Monkey", "Gorilla", "Bonobo");
        printable.forEach(System.out::print); // MonkeyGorillaBonobo

//        6
        System.out.println("\nExample 6");
        Stream<String> stringStream = Stream.of("w", "o", "l", "f");
        String word = stringStream.reduce("", (b, c) -> b + c);
        System.out.println(word); // wolf

//        7
        System.out.println("Example 7");
        Stream<String> collectStream = Stream.of("w", "o", "l", "f");
        StringBuilder wolfBuilder = collectStream.collect(StringBuilder::new, StringBuilder::append, StringBuilder::append);
        String wolf = wolfBuilder.toString();
        System.out.println(wolf); // wolf
    }


}
