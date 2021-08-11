package Mod14.Unit5;

import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import java.util.TreeSet;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Examples3 {
    public static void main(String[] args) {
//        1
//        Этот коллектор, позволяет соединять элементы стрима по передаваемому значению.
        System.out.println("Example " + 1);
        Stream<String> ohMy1 = Stream.of("lions", "tigers", "bears");
        String result1 = ohMy1.collect(Collectors.joining(", ")); // lions, tigers, bears
        System.out.println(result1);

//        2
//        Такой коллектор позволяет посчитать среднее арифметическое
//        значение чисел (есть методы также для double, long, int).
        System.out.println("Example " + 2);
        Stream<String> ohMy2 = Stream.of("lions", "tigers", "bears");
        Double result2 = ohMy2.collect(Collectors.averagingInt(String::length)); // 5.33333333333333333
        System.out.println(result2);

//        3
//        Мы можем записать результат в нужную нам коллекцию,
//        при этом помимо общего метода toCollection()
//        можем пользоваться специфичными toList(), toSet().
//        В таком случае имплементация коллекции (list или set) нас не интересует —
//        Java сама решит, какую имплементацию нам дать в ответе.
        System.out.println("Example " + 3);
        Stream<String> ohMy3 = Stream.of("lions", "tigers", "bears");
        TreeSet<String> result3 = ohMy3
                .filter(s -> s.startsWith("t"))
                .collect(Collectors.toCollection(TreeSet::new)); // [tigers]
        System.out.println(result3);

//        4
//        Теперь мы собираем результат работы в Map.
//        Первый аргумент — то, что будет ключом нашей Map.
//        В данном случае ключами выступят сами элементы стрима.
//        Второй аргумент — непосредственно значения по ключу —
//        кладем длины элементов-строк.
        System.out.println("Example " + 4);
        Stream<String> ohMy4 = Stream.of("lions", "tigers", "bears");
        Map<String, Integer> map4 = ohMy4.collect(Collectors.toMap(
                s -> s, String::length
        )); // {lions = 5, bears = 5, tigers = 6}
            System.out.println(map4);

//        5
//        Здесь третьим параметром как раз-таки определяем,
//        как мы хотим иметь дело с одинаковыми ключами —
//        конкатенировать (складывать) строки-значения через запятую.
        System.out.println("Example " + 5);
        Stream<String> ohMy5 = Stream.of("lions", "tigers", "bears");
        Map<Integer, String> map5 = ohMy5.collect(Collectors.toMap(
                String::length, // ключ - длина массива
                k -> k, // значение - сами строки
                (s1, s2) -> s1 + "," + s2 // таким образом объединяем строки по одинаковому ключу
        )); // {5 = lions,bears, 6 = tigers}
        System.out.println(map5.getClass()); // class java.util.HashMap

//        6
        System.out.println("Example " + 6);
        Stream<String> ohMy6 = Stream.of("lions", "tigers", "bears");
        Map<Integer, String> map6 = ohMy6.collect(Collectors.toMap(
                String::length, // ключ - длина массива
                k -> k, // значение - сами строки
                (s1, s2) -> s1 + "," + s2, // таким образом объединяем строки по одинаковому ключу
                TreeMap::new // указали Java дать конкретную требуемую имплементацию
        )); // {5 = lions,bears, 6 = tigers}
        System.out.println(map6.getClass()); // class java.util.TreeMap

//        7
//        Такая простая и элегантная запись позволила сгруппировать нам в листы
//        значения по ключам, //        равным длинам этих самых значений.
        System.out.println("Example " + 7);
        Stream<String> ohMy7 = Stream.of("lions", "tigers", "bears");
        Map<Integer, List<String>> map7 = ohMy7.collect(Collectors.groupingBy(String::length));
        System.out.println(map7); // {5=[lions, bears], 6=[tigers]}

//        8
//        Тут мы меняем стратегию и буквально «делим пополам»
//        наш стрим по некоему условию.
//        Ключами выступают boolean true или false.
        System.out.println("Example " + 8);
        Stream<String> ohMy8 = Stream.of("lions", "tigers", "bears");
        Map<Boolean, List<String>> map8 = ohMy8.collect(Collectors.partitioningBy(s -> s.length() <= 5));
        System.out.println(map8); // {false=[tigers], true=[lions, bears]}


    }
}
