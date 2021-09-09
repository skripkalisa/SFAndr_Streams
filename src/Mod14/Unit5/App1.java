package Mod14.Unit5;


import java.util.*;

//Давайте решим следующую задачу:
// необходимо в списке отобрать первые 2 строки в алфавитном порядке,
// которые имеют длину 4.
//
public class App1 {
    public static void main(String[] args) {

//Рассмотрим первый способ решения без стримов:
        System.out.println("No streams: ");
        List<String> list = Arrays.asList("Toby", "Anna", "Leroy", "Alex");
        List<String> filtered = new ArrayList<>();
        for (String name : list) {
            if (name.length() == 4) {
                filtered.add(name);
            }
        }

        Collections.sort(filtered);
        Iterator<String> iter = filtered.iterator();
        if (iter.hasNext()) {
            System.out.println(iter.next());
        }
        if (iter.hasNext()) {
            System.out.println(iter.next());
        }

//        Теперь посмотрим, как мы можем решить ту же самую задачу, используя стримы:
        System.out.println("With streams: ");
        List<String> listStream = Arrays.asList("Toby", "Anna", "Leroy", "Alex");
        listStream
                .stream()
                .filter(n -> n.length() == 4)
                .sorted()
                .limit(2)
                .forEach(System.out::println);

    }
}
