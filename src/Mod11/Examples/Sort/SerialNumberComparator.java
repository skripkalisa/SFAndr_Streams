package Mod11.Examples.Sort;

import java.util.Comparator;

public class SerialNumberComparator implements Comparator<Product> {
    @Override
    public int compare(Product o1, Product o2) {
        return Long.compare(o1.getSerialNumber(), o2.getSerialNumber());
    }
}
