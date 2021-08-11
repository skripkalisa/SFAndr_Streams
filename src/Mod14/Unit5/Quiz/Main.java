package Mod14.Unit5.Quiz;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.OptionalDouble;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) {

        // Задание 14.5.2
        System.out.println("Задание 14.5.2 ");
        Stream<Double> stream = Stream.of(1d, 2.94d, 2.33d);
        System.out.println(stream.min((d1, d2) -> (int) (d1 - d2)).orElse(0d));

        System.out.println("Задание 14.5.3 ");
        Stream<Integer> infinite = Stream.iterate(2, x -> x * 2);
        System.out.println(infinite.anyMatch(test -> test / 8 == 0));

        System.out.println(" Задание 14.5.4 ");
        System.out.println("Программа будет работать, пока ее не убъешь");
//        Stream<Long> stream2 = Stream.iterate(0L, l -> l + 100);
//        boolean match = stream2.allMatch(elem -> elem % 100 == 0);
//        System.out.println(match);

//        Задание 14.5.5
        System.out.println("Задание 14.5.5");
        Stream<Integer> stream2 = Stream.of(1, 2, 3);
        int result = stream2
                .filter(integer -> integer <= 2)
                .findFirst()
                .orElse(4);
        System.out.println(result);

//        Задание 14.5.6
        System.out.println("Задание 14.5.6");
        Stream<String> stream3 = Stream.of("One", "Two");
        stream3.limit(3).skip(2).forEach(System.out::println);

//        Задание 14.5.7
        System.out.println("Задание 14.5.7 ");
        Stream<Integer> stream4 = Stream.iterate(1, integer -> integer + 1);
        boolean match = stream4
                .map(String::valueOf)
                .distinct()
                .limit(5)
                .noneMatch(str -> str.length() != 1);
        System.out.println(match);

//        Задание 14.5.8
        System.out.println("Задание 14.5.8");
//        Необходимо список строк перевести в список чисел и
//        произвести их последовательное перемножение.
//        Решите задачу, сначала используя обычный подход,
//        а затем попробуйте написать тот же код на стримах.

        System.out.println("No streams: ");
        List<String> strings = Arrays.asList("1", "2", "3", "4", "5");
        List<Integer> integers = new ArrayList<>();
        for (String s : strings) {
            integers.add(Integer.parseInt(s));
        }
        int multiply = 1;
        for (int i : integers) {
            multiply *= i;
        }
        System.out.println(multiply);

//
//        With streams
        System.out.println("With streams: ");
        int multiplyStreams = Stream.of("1", "2", "3", "4", "5")
                .map(Integer::parseInt)
                .reduce(1, (integer, integer2) -> integer * integer2);
        System.out.println(multiplyStreams);

//        Задание 14.5.9
        System.out.println("Задание 14.5.9");
        IntStream stream9 = IntStream.generate(() -> 15);
        OptionalDouble average = stream9.mapToLong(integer -> integer)
                .average();
        System.out.println(average.orElseThrow(() -> new RuntimeException()));

    }
}
