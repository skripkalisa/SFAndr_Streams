package Mod13.Examples;

class Processor extends Thread {

  private volatile boolean running = true;

  @Override
  public void run() {
    while (running) {
      System.out.println("Processing...");
      try {
        Thread.sleep(100);
      } catch (InterruptedException exception) {
        exception.printStackTrace();
      }
    }
  }

  public void shutDown() {
    running = false;
  }

  public static void main(String[] args) throws InterruptedException {
    Processor processor1 = new Processor();
    processor1.start();

    Thread.sleep(1000);

    processor1.shutDown();
  }
}

// public class Examples1 {

// }
