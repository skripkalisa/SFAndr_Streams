package Mod12.Examples.Methods;

public class InterruptExample {
  public static void main(String[] args) throws InterruptedException { // 4
    Thread threadToInterrupt = new Thread() {
      public void run() {
        while (true) {
          System.out.println("Working hard");
          try {
            Thread.sleep(1000); // 1
          } catch (InterruptedException e) {
            System.out.println("Interrupted!");
            break; // 2
          }
        }
      }
    };

    threadToInterrupt.start();
    Thread.currentThread();
    Thread.sleep(2500); // 3
    threadToInterrupt.interrupt(); // 5
  }
}
