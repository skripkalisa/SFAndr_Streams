package Mod10.Task;

import static java.lang.Math.abs;
import static java.lang.Math.sqrt;

public class Equation {
    private float a;
    private float b;
    private float c;

    public Equation(float[] args) {
        this.a = args[0];
        this.b = args[1];
        this.c = args[2];
    }

    public void equation() {


        String s = this.c > 0 ? " + " + (int) this.c : " - " + (int) abs(this.c);
        if (this.a == 0 && this.b != 0) {
            float x;
            x = -this.c / this.b;
            System.out.println("\nSince a = 0, this is not a quadratic equation anymore\n");
            System.out.println("For this linear equation\n" + b + "*x" + s + " = 0");
            System.out.println("x = " + x);
        } else {
            String x3 = (int) a + "*x^2" + (this.b > 0 ? " + " + (int) this.b : " - " + (int) abs(this.b)) + "*x" + s + " = 0";
            if (this.a == 0 && this.b == 0) {
                if (this.c == 0) {
                    System.out.println("This quadratic equation");
                    System.out.println(x3);
                    System.out.println("has infinite number of roots");

                } else {
                    System.out.println("This quadratic equation");
                    System.out.println(x3);
                    System.out.println("is incorrect.\nThe program will exit.");
                }
            } else {
                float D;
                D = this.b * this.b - 4 * this.a * this.c;
                System.out.println("\nThis quadratic equation: ");
                System.out.println(x3);

                if (D > 0) {
                    System.out.println("has real roots:");
                    float x1;
                    x1 = (float) ((-this.b + sqrt(D)) / (2 * this.a));
                    float x2;
                    x2 = (float) ((-this.b - sqrt(D)) / (2 * this.a));
                    System.out.println("x1 = " + x1);
                    System.out.println("x2 = " + x2);
                } else if (D < 0) {
                    System.out.println("has complex roots:");
                    float v;
                    float w;
                    v = (-this.b / (2 * this.a));
                    w = (float) (sqrt(D * (-1)) / (2 * this.a));
                    System.out.println("x1 = " + v + (w >= 0 ? " + " + w : " - " + abs(w)) + "i");
                    System.out.println("x2 = " + v + (w < 0 ? " + " + w : " - " + abs(w)) + "i");
                } else {
                    System.out.println("has only one root: \n");
                    float x;
                    x = (-this.b / (2 * this.a));
                    System.out.println("x = " + x);
                }
            }
        }
    }
}
