package Mod11.Examples.Sort;

public class CarQuiz {
    private String brand;
    private long serialNumber;

    public CarQuiz(String brand, long serialNumber) {
        this.brand = brand;
        this.serialNumber = serialNumber;
    }

    @Override
    public String toString() {
        return brand;
    }
}
