package Mod14.Unit6;

import java.nio.file.Path;
import java.nio.file.Paths;

public class PathTest {

    public static void main(String[] args) {
        printPathInformation(Paths.get("/zoo/armadillo/shells.txt"));
        System.out.println();
        printPathInformation(Paths.get("armadillo/shells.txt"));

        System.out.println("Example 2");
        Path path1 = Paths.get("/birds/egret.txt");
        System.out.println("path1 is absolute? " + path1.isAbsolute());
        System.out.println("absolute from path1: " + path1.toAbsolutePath());

        Path path2 = Paths.get("birds/condor.txt");
        System.out.println("path2 is absolute?: " + path2.isAbsolute());
        System.out.println("absolute from path2: " + path2.toAbsolutePath());

        Path path = Paths.get("/home/skillfactory/task.task");
        System.out.println(path.isAbsolute());

    }

    public static void printPathInformation(Path path) {
        System.out.println("Filename is: " + path.getFileName());
        System.out.println("Root is: " + path.getRoot());

        Path currentPath = path;
        while ((currentPath = currentPath.getParent()) != null) {
            System.out.println("Current parent is: " + currentPath);
        }
    }
}
