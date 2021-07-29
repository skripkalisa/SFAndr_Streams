package Mod11.Examples.Sets;

import java.util.Objects;

public class Car {
    private final String brand;

    private final String name;
    private boolean onSale;

    public Car(String brand, String name, boolean onSale) {
        if (brand == null || name == null) throw new IllegalArgumentException();
        this.brand = brand;
        this.name = name;
        this.onSale = onSale;
    }


    public String getBrand() {
        return brand;
    }

//    public void setBrand(String brand) {
//        this.brand = brand;
//    }

    public String getName() {
        return name;
    }

//    public void setName(String name) {
//        this.name = name;
//    }

    public boolean isOnSale() {
        return onSale;
    }

    public void setOnSale(boolean onSale) {
        this.onSale = onSale;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Car car = (Car) o;
        return getBrand().equals(car.getBrand()) && getName().equals(car.getName());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getBrand(), getName());
    }

    @Override
    public String toString() {
        return "Car{" +
                "brand='" + brand + '\'' +
                ", name='" + name + '\'' +
                ", onSale=" + onSale +
                '}';
    }
}
