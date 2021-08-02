package Mod12.Examples.Methods;

public class JoinExample {
  private static int counter = 0;

  public static void main(String[] args) throws InterruptedException {
    new Thread() {
      public void run() {
        for (int i = 0; i < 50000000; i++) {
          JoinExample.counter++;
        }
      }
    }.start();

    System.out.println("Counter value: " + counter); // Counter value: 0
  }
}
