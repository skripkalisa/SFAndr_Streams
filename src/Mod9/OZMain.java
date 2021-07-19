package Mod9;

import java.util.Scanner;

public class OZMain {
    public static void main(String[] args) {
/*

Make byte InputStream OneZeroStream, which gives
1 0 1 0 .....

*/

        OneZeroStream oz = new OneZeroStream();
//        oz.nextInt();
//        System.out.println(oz.nextInt());
        Scanner scanner = new Scanner(new OneZeroStream());
        for (int i = 0; i < 10; i++) {
            System.out.print(scanner.nextInt());
        }

/*

The code above has to output

1010101010

*/
    }
}
