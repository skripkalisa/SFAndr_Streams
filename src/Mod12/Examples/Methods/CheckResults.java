package Mod12.Examples.Methods;

public class CheckResults {
  private static int counter = 0;

  public static void main(String[] args) throws InterruptedException {
    new Thread() {
      public void run() {
        for (int i = 0; i < 100; i++) {
          CheckResults.counter++;
        }
      }
    }.start();
    while (CheckResults.counter < 100) {
      System.out.println("Not reached yet");
      // Метод sleep()
      Thread.sleep(1000); // 1 секунда
    }
    System.out.println("Reached");
  }
}
