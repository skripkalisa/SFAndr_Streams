package Mod12.Examples.Quiz;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;

class ConsoleClock extends Thread {

  // write class which print time as HH:MM:SS
  // every second here

  @Override
  public void run() {
    while (!isInterrupted()) {
      DateFormat timeFormat = new SimpleDateFormat("HH:mm:ss");
      Calendar cali = Calendar.getInstance();
      cali.getTime();
      String time = timeFormat.format(cali.getTimeInMillis());
      System.out.println(time);
      try {
        Thread.sleep(1000);
      } catch (InterruptedException e) {
        break;
      }
    }
    System.out.println("The clock was stopped");
  }

  public static void main(String[] args) throws InterruptedException {

    ConsoleClock cc = new ConsoleClock();
    cc.start();
    Thread.sleep(3000);
    cc.interrupt();
  }
}