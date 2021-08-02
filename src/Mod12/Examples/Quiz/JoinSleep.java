package Mod12.Examples.Quiz;

public class JoinSleep {
  static Thread t1 = new Thread() {
    public void run() {
      try {
        Thread.sleep(500);
      } catch (InterruptedException e) {
        e.printStackTrace();
      }
      Thread.currentThread().start(); // 1
    }
  };

  public static void main(String[] args) throws InterruptedException {

    t1.start(); // 2
    t1.join();
  }
}
