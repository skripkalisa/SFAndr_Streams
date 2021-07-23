package Mod8.Date;

import java.util.Date;

public class Dates {
    public static void main(String[] args) {
        Date date = new Date();
        System.out.println(date);
        Date date1 = new Date(1);
        Date date2 = new Date(2);
        System.out.println(date1.after(date2));//false
        System.out.println(date1.before(date2));//true
        System.out.println(date1.compareTo(date2));//-1
        System.out.println(date1.getTime());
        date1.setTime(2);
        System.out.println(date1.getTime());//2
    }
}
