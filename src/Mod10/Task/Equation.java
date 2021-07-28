package Mod10.Task;

import java.io.PrintWriter;

import static Mod10.Task.Main.output;
import static java.lang.Math.abs;
import static java.lang.Math.sqrt;

public class Equation {
    private float a;
    private float b;
    private float c;
    private PrintWriter outputFile;

    public Equation(float[] args, PrintWriter outputFile) {
        this.a = args[0];
        this.b = args[1];
        this.c = args[2];
        this.outputFile = outputFile;
    }

    public void equation() {
// при желании можно перевести сообщения на русский.

        String s = this.c > 0 ? " + " + (int) this.c : " - " + (int) abs(this.c);
        if (this.a == 0 && this.b != 0) {
            float x;
            x = -this.c / this.b;
            output("\nSince a = 0, this is not a quadratic equation anymore\n", System.out, outputFile);
            output("For this linear equation\n" + b + "*x" + s + " = 0", System.out, outputFile);
            output("x = " + x, System.out, outputFile);
        } else {
            String x3 = (int) a + "*x^2" + (this.b > 0 ? " + " + (int) this.b : " - " + (int) abs(this.b)) + "*x" + s + " = 0";
            if (this.a == 0 && this.b == 0) {
                if (this.c == 0) {
                    output("This quadratic equation", System.out, outputFile);
                    output(x3, System.out, outputFile);
                    output("has infinite number of roots", System.out, outputFile);

                } else {
                    output("This quadratic equation", System.out, outputFile);
                    output(x3, System.out, outputFile);
                    output("is incorrect.\nThe program will exit.", System.out, outputFile);
                }
            } else {
                float D;
                D = this.b * this.b - 4 * this.a * this.c;
                output("\nThis quadratic equation: ", System.out, outputFile);
                output(x3, System.out, outputFile);

                if (D > 0) {
                    output("has real roots:", System.out, outputFile);
                    float x1;
                    x1 = (float) ((-this.b + sqrt(D)) / (2 * this.a));
                    float x2;
                    x2 = (float) ((-this.b - sqrt(D)) / (2 * this.a));
                    output("x1 = " + x1, System.out, outputFile);
                    output("x2 = " + x2, System.out, outputFile);
                } else if (D < 0) {
                    output("has complex roots:", System.out, outputFile);
                    float v;
                    float w;
                    v = (-this.b / (2 * this.a));
                    w = (float) (sqrt(D * (-1)) / (2 * this.a));
                    output("x1 = " + v + (w >= 0 ? " + " + w : " - " + abs(w)) + "i", System.out, outputFile);
                    output("x2 = " + v + (w < 0 ? " + " + w : " - " + abs(w)) + "i", System.out, outputFile);
                } else {
                    output("has only one root: \n", System.out, outputFile);
                    float x;
                    x = (-this.b / (2 * this.a));
                    output("x = " + x, System.out, outputFile);
                }
            }
        }
    }
}
