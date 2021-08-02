package Mod10.Examples;

public class StackTraceEx {
//        public static void main(String[] args) {
//        System.out.println("Метод main() успешно запущен");
//        method1();
//        System.out.println("Метод main() заканчивает свою работу");
//    }
//
//    static void method1() {
//        System.out.println("Первый метод передаёт привет!");
//        method2();
//    }
//
//    static void method2() {
//        System.out.println("Второй метод передаёт привет!");
//    }

    public static void main(String[] args) {
        System.out.println("Метод Main успешно запущен");
        method1();
        System.out.println("Метод Main заканчивает свою работу");
    }

    //    static void method1() {
//        System.out.println("Первый метод передаёт привет!");
//        method2();
//    }
    static void method1()  {
        try {
            System.out.println("Первый метод передаёт привет!");
            method2();
        } catch (ArithmeticException err) {
            System.out.println(err.getMessage());
        }
    }

    static void method2() {
        int x = 10;
        int y = 0;
        try{
            if (y == 0){
                throw new MyException1(y, "Can't divide by zero!");
            }
        }
        catch (MyException1 a){
            System.err.println("MyException1 is caught! " + a);
        }
        double z = x / y;
        System.out.println(z);
        System.out.println("Второй метод");
    }
    public static class MyException1 extends Exception {
        private int detail;
        public MyException1(int detail, String message) {
            super(message);
            this.detail = detail;
        }

        public MyException1() {

        }

        @Override
        public String toString() {
            return "MyException{"
                    + "detail=" + detail
                    + ", message=" + getMessage()
                    + "} ";
        }
    }
}
