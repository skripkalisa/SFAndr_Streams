package Mod11.Examples.Generics;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class WildCard {
    public static void main(String[] args) {
        Queue<String> keywords = new LinkedList<>();
        keywords.add("Java");
        printList(keywords);

//        Collection<? extends String> collection = new LinkedList<>(); // 2
//        collection.add("Hello"); // 3
//        System.out.println(collection.size());
//        List<Integer> list = new ArrayList<>(15);
//        System.out.println(list.size());

//        List<Integer> list = new LinkedList<>();
//
//        for (int i = 0; i <= 3; i++) {
//            list.add(i);
//        }
//
//        System.out.println(list.get(list.size()));

        LinkedList<Integer> list = new LinkedList<>();
        list.add(15);
        list.addLast(28);
        list.remove(0);
        list.set(0, 33);
        list.addFirst(null);
        List<Integer> anotherList = list; // 1
        System.out.println(anotherList);

//Задание 11.4.6
//
//Создайте такую программу, которая создает лист и заполняет его последовательно числами в порядке от 0 до 99.
//
//Затем, не создавая новый лист, сделайте так, чтобы этот лист теперь хранил значения по порядку от 99 до 0 (без использования сортировки).
        List<Integer> list6 = new LinkedList<>();

        for (int i = 0; i < 100; i++) {
            list6.add(i);
        }

        for (int i = 0, j = 99; i < 50 && j >= 50; i++, j--) {
            int start = list6.get(i);
            int end = list6.get(j);
            list6.set(j, start);
            list6.set(i, end);
        }

        System.out.println(list6);
    }



    //наследование работает по типам, а не по дженерикам этих типов
    private static void printList(Queue<?> keywords) {
        for (Object o : keywords) {
            System.out.println(o);
        }
    }

    //      Upper-bounded Wildcard
//
//      Пример:
    public static long total(List<? extends Number> list) {
        long count = 0;
        for (Number number : list) {
            count += number.longValue();
        }
        return count;
    }

    //    Lower-bounded Wildcard
//
//    Пример:
    public static void addSound(List<? super String> list) {
        list.add("Meow");
    }

    //    Если верхняя граница позволяет нам знать, с каким типом элементов мы работаем, то нижняя граница позволяет нам модифицировать параметризованный класс.
//    Представьте, если мы бы в данном случает пользовались верхней границей List<? extends Number>. Тогда получается, что мы можем класть в этот лист все, что наследуется от класса Number (например, Double, Integer, Long):
//Пример:
//    private static void modifyList(List<? extends Number> list) {
//        list.add(5.6d); // does not compile
//        list.add(131232134342344L); // does not compile
//        list.add(118); // does not compile
//    }

    private static void modifyList(List<? super Number> list) {
        list.add(5.6d); // does not compile
        list.add(131232134342344L); // does not compile
        list.add(118); // does not compile
    }
}
