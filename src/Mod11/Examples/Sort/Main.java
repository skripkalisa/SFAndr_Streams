package Mod11.Examples.Sort;

import java.time.LocalDateTime;
import java.util.Set;
import java.util.TreeSet;

public class Main {
    public static void main(String[] args) {
//        Set<Product> set = new TreeSet<>();
//        set.add(new Product("СуперБренд", "Колбаса", 3435425455L, LocalDateTime.now()));

        Set<Product> set = new TreeSet<>();
        set.add(new Product("СуперБренд", "Колбаса", 3435425245L, LocalDateTime.now()));
        set.add(new Product("ЛучшийБренд", "Сыр", 434323434L, LocalDateTime.now()));
        set.add(new Product("ХорошийБренд", "Сыр", 4343111111L, LocalDateTime.now()));
        for (Product product : set) {
            System.out.println(product.getBrand());
        }

        Set<Product> products = new TreeSet<>(new NameComparator());
        products.add(new Product("СуперБренд", "Колбаса", 1L, LocalDateTime.now()));
        products.add(new Product("ЛучшийБренд", "Сыр", 2L, LocalDateTime.now()));

        for (Product product : products) {
            System.out.println(product.getName());
        }
        for (Product product : products) {
            System.out.println(product.getSerialNumber());
        }
    }
}
