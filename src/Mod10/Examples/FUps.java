package Mod10.Examples;

import java.io.*;
import java.nio.charset.Charset;
import java.text.NumberFormat;
import java.text.ParseException;

public class FUps {

    public static void main(String[] args) {
        //    IndexOfBoundsException. Программа для гаданий
//        int[] array = {1, 2, -1, 5, 3};
//        int s = 0, i;
//        for (i = 0; i <= array.length; i++) {
//            s += array[i];
//        }
//        System.out.println(s);
        //    IndexOfBoundsException. Программа для гаданий

//        List<String> lines = Files.readAllLines(Paths.get("borodino.txt"), UTF_8);
//        Scanner in = new Scanner(System.in);
//        System.out.println("Введите номер строки в диапазоне 1.." + lines.size());
//        int n = in.nextInt();
//        System.out.println("Вот предсказание для вас:\n" + lines.get(n - 1));

//        пользователь может не обратить внимание на указание ввести строку в определенных пределах, и программа упадет с ошибкой ArrayIndexOutOfBoundsException.
//       Решение 1
//        if (n < lines.size()) {
//            System.out.println("Вот предсказание для вас:\n" + lines.get(n));
//        } else {
//            System.out.println("Вы ввели недопустимый номер...");
//        } // Вы ввели недопустимый номер...
//        Решение 2
//        try {
//            System.out.println("Вот предсказание для вас:\n" + lines.get(n));
//        }
//        catch (Exception e) {
//            System.out.println("Вы ввели недопустимый номер..." );
//        }// Вы ввели недопустимый номер..
//    }

        //В данном примере мы попытаемся привести строку к числу с помощью класса NumberFormat. Для этого мы заведомо дадим неправильные данные.

        try {
            NumberFormat nf = NumberFormat.getInstance();
            //специально создаем ситуацию, которая приведет к исключению
            System.out.println(nf.parse("NOT A NUMBER"));
        } catch (ParseException e) {
            System.out.println(e.getMessage());
        }
        System.out.println("Конец программы NOT A NUMBER!");
        String string = "123";
        try {
            char chr = string.charAt(10);
        } catch (StringIndexOutOfBoundsException ex) {
            System.out.println(ex.toString());
        }
        System.out.println("Конец программы String string = 123!");
        doAction();


    }

//Вот такой метод, решающий маленькую задачу чтения единственной строки из файла, приходится писать в миллион строк.

static String readFirstLineFromFileWithFinallyBlock(String path) {
   BufferedReader br = null;
   try {
           br = new BufferedReader(new FileReader(path));
           return br.readLine();
       } catch (IOException e) {
           e.printStackTrace();
       }
   finally {

       if (br != null) {
           // и снова try-catch потому что...
           try {
               br.close();
           } catch (IOException e) {
               e.printStackTrace();
           }
       }
       return null;
   }
}

//А с использованием try-with-resources получается вполне компактно:

static String readFirstLineFromFileWithTryWithResources(String path) {
   // открывается прямо на месте, а закрывается само!
   try ( BufferedReader br = new BufferedReader(new FileReader(path))){
           return br.readLine();
       } catch (IOException e) {
           e.printStackTrace();
       }
   return null;
}



    public static void doAction() {
//        Обработка нескольких исключений
        try {
            int a = (int) (Math.random() * 2);
            System.out.println("a = " + a);
            int c[] = {1 / a}; // опасное место #1 возможно деление на ноль
            c[a] = 71; // опасное место #2 в массиве только один элемент
        } catch (ArithmeticException e) {
            System.err.println("деление на 0 " + e);
        } catch (ArrayIndexOutOfBoundsException e) {
            System.err.println("out of bound: " + e);
        } // окончание try-catch блока
        System.out.println("after try-catch");
    }

    public void subclasses() {

//        Подклассы исключений, которые используются в блоках catch, должны следовать перед любым из их суперклассов, иначе суперкласс будет перехватывать эти исключения.
//
//        Давайте рассмотрим пример:

//        try { /* код, который может вызвать исключение */
//        } catch (IllegalArgumentException e) {...
//        } catch (PatternSyntaxException e) {...} /* никогда не может быть вызван: ошибка компиляции */

//        В данном примере PatternSyntaxException представляет собой подкласс класса IllegalArgumentException. Правильная конструкция будет иметь следующий вид:

//        try { /* код, который может вызвать исключение */
//        } catch (PatternSyntaxException e) { ...
//        } catch (IllegalArgumentException e) { ...}
//        На практике иногда возникают ситуации, когда инструкций catch несколько, и обработка производится
//        идентичная, например, вывод сообщения об исключении в журнал.

//        try {
////          Любые действия, которые могут породить исключения
//        } catch (NumberFormatException e) {
//            e.printStackTrace();
//        } catch (ClassNotFoundException e) {
//            e.printStackTrace();
//        } catch (InstantiationException e) {
//            e.printStackTrace();
//        }
//        В седьмой версии Java появилась возможность сокращения кода, избавляя код от избыточности, используя
//        для разделения оператор |.
//
//        try {
//          //Любые действия, которые могут породить исключения
//        } catch (NumberFormatException | ClassNotFoundException | InstantiationException e) {
//            e.printStackTrace();
//        }


    }
}
