package Mod13.Examples.Unit6;

import java.util.concurrent.atomic.AtomicInteger;

public class AppAtomized {
  private AtomicInteger count = new AtomicInteger(0); // используем новый класс AtomicInteger

  public static void main(String[] args) throws InterruptedException {
    AppAtomized appAtomized = new AppAtomized();
    appAtomized.doWork();
  }

  private void doWork() throws InterruptedException {
    Thread t1 = new Thread() {
      public void run() {
        for (int i = 0; i < 10000; i++) {
          count.incrementAndGet(); // атомарно увеличивает значение на 1

        }
      }
    };

    Thread t2 = new Thread() {
      public void run() {
        for (int i = 0; i < 10000; i++) {
          count.incrementAndGet(); // атомарно увеличивает значение на 1

        }
      }
    };

    t1.start();
    t2.start();

    t1.join();
    t2.join();

    System.out.println("Count is: " + count); // Count is: 20000
  }

}
