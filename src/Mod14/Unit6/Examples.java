package Mod14.Unit6;

import java.nio.file.Path;
import java.nio.file.Paths;

public class Examples {
    public static void main(String[] args) {
        Path path = Paths.get("/land/hippo/harry.happy");
        System.out.println("The path name is: " + path); // The path name is: land/hippo/harry.happy

        for (int i = 0; i < path.getNameCount(); i++) {
            System.out.println("Element " + i + " is : " + path.getName(i));
        }
        /*
         * Element 0 is land
         * Element 1 is hippo
         * Element 2 is harry.happy
         */

//Создадим суб-пути:
        Path path2 = Paths.get("/mammal/carnivore/raccoon.image");
        System.out.println("Path is: " + path2);

        System.out.println("Subpath from 0 to 3 is: " + path2.subpath(0, 3));
        System.out.println("Subpath from 1 to 3 is: " + path2.subpath(1, 3));
        System.out.println("Subpath from 1 to 2 is: " + path2.subpath(1, 2));
    }
}
