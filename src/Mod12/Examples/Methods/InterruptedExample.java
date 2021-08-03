package Mod12.Examples.Methods;

public class InterruptedExample {
  public static void main(String[] args) throws InterruptedException { // 4
    Thread threadToInterrupt = new Thread() {
      public void run() {
        while (!isInterrupted()) {
          System.out.println("Working hard");
        }
        try {
          Thread.sleep(500);
        } catch (InterruptedException e) {
          // Перехватываем молча
        }
        System.out.println("All done");
      }
    };

    threadToInterrupt.start();
    Thread.currentThread();
    Thread.sleep(2500); // 3
    threadToInterrupt.interrupt();
    threadToInterrupt.join();
    System.out.println("Thread finished");
  }
}
