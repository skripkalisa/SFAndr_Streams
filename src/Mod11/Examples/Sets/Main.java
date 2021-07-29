package Mod11.Examples.Sets;

import java.util.*;

public class Main {

//    public static final String TOYOTA = "Toyota";
//    public static final String BMW = "BMW";
//    public static final String KIA = "KIA";


    public static void main(String[] args) {
        final int carPark = 30;
        final int models = 3;
        String[][] carModels = {
                {"Camri", "Raw 4", "Corolla"},
                {"X3", "X5", "X6"},
                {"Ceed", "Yaris", "Rio"},
        };
        String[] carBrands = {"Toyota", "BMW", "KIA"};
        Car[] cars = new Car[carPark];
        List<Car> carList = new ArrayList<>();
        for (int i = 0; i < carPark; i++) {
            int j = (i + models) % models;
            for (int k = 0; k < models; k++) {
                cars[i] = new Car(carBrands[j], carModels[j][k], k % 2 != 0);
                carList.add(cars[i]);
                System.out.println(cars[i]);
            }
        }
        System.out.println(cars.length);
        Set<Car> carSet = new HashSet<>(carList);
//        Set<Car> carSet = new HashSet<>(Arrays.asList(cars));

        for (Car car : carSet) {
            System.out.println(car);
        }

    }

}
