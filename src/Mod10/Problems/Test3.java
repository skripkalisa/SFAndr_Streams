package Mod10.Problems;

public class Test3 {
    public static String someMethod() {
        try {
            throw new NullPointerException();
        } catch (NullPointerException e) {
            return "catch";
        } finally {
            return "finally";
        }
    }

    public static void main(String[] args) {
        System.out.println(someMethod());
    }
}
