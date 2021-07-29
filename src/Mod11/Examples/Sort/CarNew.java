package Mod11.Examples.Sort;


import java.util.Objects;

public class CarNew implements Comparable<CarNew> {
    private final String brand;
    private final long serialNumber;

    public CarNew(String brand, long serialNumber) {
        this.brand = brand;
        this.serialNumber = serialNumber;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CarNew CarNew = (CarNew) o;
        return serialNumber == CarNew.serialNumber &&
                brand.equals(CarNew.brand);
    }

    @Override
    public int hashCode() {
        return Objects.hash(serialNumber);
    }

    @Override
    public String toString() {
        return brand;
    }

    @Override
    public int compareTo(CarNew o) {
        return brand.compareTo(o.brand);
    }
}
