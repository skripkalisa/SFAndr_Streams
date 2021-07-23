package Mod8.Date;

import java.text.SimpleDateFormat;
import java.util.Calendar;

public class Calendar_ {
    public static void main(String[] args) {
        Calendar calendar = Calendar.getInstance();
        int era = calendar.get(Calendar.ERA);//Эра
        int year = calendar.get(Calendar.YEAR);//Год
        int month = calendar.get(Calendar.MONTH);//Месяц Jan = 0, dec = 11
        int dayOfMonth = calendar.get(Calendar.DAY_OF_MONTH);//День месяца
        int dayOfWeek = calendar.get(Calendar.DAY_OF_WEEK);//День недели
        int weekOfYear = calendar.get(Calendar.WEEK_OF_YEAR);//Неделя года
        int weekOfMonth = calendar.get(Calendar.WEEK_OF_MONTH);//Неделя месяца

        int hour = calendar.get(Calendar.HOUR);//Час в 12 часовом формате
        int hourOfDay = calendar.get(Calendar.HOUR_OF_DAY);//Час в 24 часовом формате
        int minute = calendar.get(Calendar.MINUTE);//Минуты
        int second = calendar.get(Calendar.SECOND);//Секунды
        int millisecond = calendar.get(Calendar.MILLISECOND);//Миллисекунды
        System.out.println("Сейчас " + hourOfDay + ":" + minute + "/" + dayOfMonth + "." + (month + 1) + "." + year);

        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy MMM dd HH:mm:ss");

        System.out.println("Сейчас " + dateFormat.format(calendar.getTime()));

        System.out.println(calendar.get(Calendar.HOUR_OF_DAY));//11
        calendar.add(Calendar.HOUR_OF_DAY, 1);
        System.out.println(calendar.get(Calendar.HOUR_OF_DAY));//12
        System.out.println(calendar.get(Calendar.HOUR_OF_DAY));//11
//        calendar.clear();
        System.out.println(calendar.get(Calendar.HOUR_OF_DAY));//0
        System.out.println(calendar.getTime());
//Thu Dec 03 00:41:46 MSK 2020
        System.out.println(calendar.get(Calendar.HOUR_OF_DAY));//11
        calendar.set(Calendar.HOUR_OF_DAY, 3);
        System.out.println(calendar.get(Calendar.HOUR_OF_DAY));//23


    }
}
