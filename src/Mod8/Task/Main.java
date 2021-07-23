package Mod8.Task;

import java.util.Scanner;

import static java.lang.Math.abs;
import static java.lang.Math.sqrt;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.println("This program calculates roots of any quadratic equation");
        System.out.println("a*x^2 + b*x + c = 0\n");
        System.out.print("Please enter the first number: ");
        while(!input.hasNextFloat()) input.next();
        float a = input.nextFloat();
        System.out.print("Please enter the second number: ");
        while(!input.hasNextFloat()) input.next();
        float b = input.nextFloat();
        System.out.print("Please enter the third number: ");
        while(!input.hasNextFloat()) input.next();
        float c = input.nextFloat();

        String s = c > 0 ? " + " + c : " - " + abs(c);
        if (a == 0 && b != 0) {
            float x;
            x = -c / b;
            System.out.println("\nSince a = 0, this is not a quadratic equation anymore\n");
            System.out.println("For this linear equation\n"+ b + "*x" + s + " = 0");
            System.out.println("x = " + x);
        } else {
            String x3 = a + "*x^2" + (b > 0 ? " + " + b : " - " + abs(b)) + "*x" + s + " = 0";
            if (a == 0 && b == 0) {
                if (c == 0) {
                    System.out.println("This quadratic equation" );
                    System.out.println(x3);
                    System.out.println("has infinite number of roots");

                } else {
                    System.out.println("This quadratic equation");
                    System.out.println(x3);
                    System.out.println("is incorrect.\nThe program will exit.");
                }
            } else {
                float D;
                D = b * b - 4 * a * c;
                System.out.println("\nThis quadratic equation: ");
                System.out.println(x3);

                if (D > 0) {
                    System.out.println("has real roots:");
                    float x1;
                    x1 = (float) ((-b + sqrt(D)) / (2 * a));
                    float x2;
                    x2 = (float) ((-b - sqrt(D)) / (2 * a));
                    System.out.println("x1 = " + x1);
                    System.out.println("x2 = " + x2);
                } else if (D < 0) {
                    System.out.println("has complex roots:");
                    float v;
                    float w;
                    v = (-b / (2 * a));
                    w = (float) (sqrt(D * (-1)) / (2 * a));
                    System.out.println("x1 = " + v + (w >= 0 ? " + " + w : " - " + abs(w)) + "i");
                    System.out.println("x2 = " + v + (w < 0 ? " + " + w : " - " + abs(w)) + "i");
                } else {
                    System.out.println("has only one root: \n");
                    float x;
                    x = (-b / (2 * a));
                    System.out.println("x = " + x);
                }
            }
        }
    }
}
