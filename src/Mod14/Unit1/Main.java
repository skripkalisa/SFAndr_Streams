package Mod14.Unit1;

import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.Period;

public class Main {
   private static boolean isGreaterTime(LocalTime time, Duration duration) {
   return time.plus(duration).isAfter(LocalTime.now());
}
    public static void main(String[] args) {
        LocalTime time = LocalTime.of(16, 30); // строка 1
        LocalTime newTime = time.withHour(14).plusMinutes(15);
        System.out.println(newTime);

        LocalDate date = LocalDate.of(2009, 4, 22);
        Period period = Period.ofYears(4);
        System.out.println(date.minus(period)); // 2005-4-22
        LocalTime time2 = LocalTime.of(16, 30);
        Duration duration = Duration.ofMinutes(15);
        System.out.println(time2.plus(duration)); // 16:45
       System.out.println(isGreaterTime(time2, duration));
    }
}
