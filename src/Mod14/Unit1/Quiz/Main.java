package Mod14.Unit1.Quiz;

import java.time.*;
import java.util.Date;

public class Main {
    public static void main(String[] args) {
//    Задание 14.1.4
//   LocalDate date = LocalDate.of(2026, Month.AUGUST, 13); // строка 1
//   LocalTime time = new LocalTime(16, 15); // строка 2
//   LocalDateTime dateTime = LocalDateTime.of(date, time); // строка 3
//   System.out.println(dateTime);

        //   Задание 14.1.5
//    LocalTime time = LocalTime.of(12, 30); // строка 1
//   time.minusHours(4); // строка 2
//    time =time.plusMinutes(30);
//   System.out.println(time);
//Задание 14.1.6

        LocalDate date = LocalDate.of(2029, 8, 4);
        Period period = Period.ofDays(3);
        date = date.minus(period); // строка 1
        Duration duration = Duration.ofHours(12);
        LocalDateTime dateTime = LocalDateTime.of(date, LocalTime.of(8, 0));
        dateTime.plus(duration); // строка 2
        System.out.println(dateTime);
        Date oldDate = new Date();
        System.out.println(convertDateToTime(oldDate));
    }
//Задание 14.1.7
    //Создайте метод, который принимает в качестве аргумента объект java.util.Date и возвращает объект LocalTime, содержащий время переданного объекта в вашем часовом поясе.
    public static LocalTime convertDateToTime(Date date) {
        Instant instant = date.toInstant();
        ZonedDateTime zonedDateTime = instant.atZone(ZoneId.systemDefault());
        return zonedDateTime.toLocalTime();
    }

    public class Test implements Comparable<Integer> {
        @Override
        public int compareTo(Integer o) {
            return 0;
        }
    }
}
