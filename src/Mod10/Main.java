package Mod10;

public class Main {
    public static void main(String[] args) {
        int a = -1;
        int b = 0;
        int res = 0;
        // float f = 0.0;
        // res = a/b;
        int[] arr = {1, 2, 3};
        // res = arr[3];
        //     Object x[] = new String[3];
        //  x[0] = new Integer(0);
        //  Object x = new Integer(0);
        //  System.out.println((String)x);

        //  int [] arrN = new int[a] ;

        // Object obj = null;
        //     obj.hashCode();

        //     int x = Integer.parseInt("30k");
        //   System.out.println(x);

        String str = "Hello how are you";
        System.out.println("Length of the String: " + str.length());
        for (int i = 0; i < str.length(); i++) {
            System.out.println(str.charAt(i));
        }
        //Accessing element at greater than the length of the String
        System.out.println(str.charAt(40));
        /*Object x = new Integer(0);
             System.out.println((String)x);
        You have to throw some runtime exceptions.
        Do it here!
        */

    }
}
