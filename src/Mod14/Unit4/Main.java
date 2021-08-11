package Mod14.Unit4;
import java.util.Optional;
public class Main {   public static Optional<Double> average(int... scores) {
       if (scores.length == 0) {
           return Optional.empty(); // строка 1
       }
       int sum = 0;
       for (int score : scores) {
           sum += score;
       }
       return Optional.of((double) sum / scores.length); // строка 2
   }
public static void main(String[] args) {
   Optional<Double> average = average(90, 100);
   if (average.isPresent()) { // проверяем наличие элемента
       System.out.println(average.get()); // 95.0
   }
      Optional<Double> average2 = average();
   System.out.println(average2.orElse(Double.NaN));
   System.out.println(average2.orElseGet(Math::random));
//   System.out.println(average2.orElseThrow(IllegalStateException::new));
   Optional<Double> average3= average(90, 100);
   System.out.println(average3.orElse(Double.NaN));
   System.out.println(average3.orElseGet(Math::random));
   System.out.println(average3.orElseThrow(IllegalStateException::new));

}


}
