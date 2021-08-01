package Mod11.Examples.Quiz;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeSet;

public class Sorted implements Comparable<Sorted>, Comparator<Sorted> {

    private int num;
    private String text;

    public Sorted(int num, String text) {
        this.num = num;
        this.text = text;
    }

    @Override
    public String toString() {
        return "" + num;
    }

    @Override
    public int compareTo(Sorted o) {
        return text.compareTo(o.text);
    }

    @Override
    public int compare(Sorted o1, Sorted o2) {
        return o1.num - o2.num;
    }

    public static void main(String[] args) {

        //Задание 3
//        List list = new ArrayList();
//        list.add("One");
//        list.add("Two");
//        list.add(7); // строка 1
//        for (String s : list) { // строка 2
//            System.out.println(s);
//        }

//        Задание 4
//        ArrayDeque<String> greetings = new ArrayDeque<>();
//        greetings.push("hello");
//        greetings.push("hi");
//        greetings.push("ola");
//        greetings.pop();
//        greetings.peek();
//        while (greetings.peek() != null) {
//            System.out.print(greetings.pop());
//        }
//        Задание 5
//        HashSet<Number> hs = new HashSet<Integer>();

//        HashSet<? super ClassCastException> set = new HashSet<Exception>();
//        List<Object> values = new HashSet<Object>();
//        List<? extends Object> objects = new ArrayList<Object>();

//        Задание 6
        Map<Integer, Integer> map = new HashMap<>(); // строка 1
        for (int i = 1; i <= 10; i++) {
            map.put(i, i * i); // строка 2
        }
        System.out.println(map.get(4)); // строка 3
//        Задание 7
        Sorted s1 = new Sorted(88, "a");
        Sorted s2 = new Sorted(55, "b");
        TreeSet<Sorted> t1 = new TreeSet<>();
        t1.add(s1);
        t1.add(s2);
        TreeSet<Sorted> t2 = new TreeSet<>(s1);
        t2.add(s1);
        t2.add(s2);
        System.out.println(t1 + " " + t2);
    }

}
