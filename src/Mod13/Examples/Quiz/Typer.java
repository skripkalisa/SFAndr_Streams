package Mod13.Examples.Quiz;

class Typer extends Thread {
  /* put your code here */
  static Object lock = new Object();
  String message;

  Typer(String message) {
    this.message = message;
  }

  public void run() {
    synchronized (lock) {
      for (int i = 0; i < message.length(); i++) {
        System.out.print(message.charAt(i));
        try {
          Thread.sleep(500);
        } catch (InterruptedException e) {
          break;
        }
      }
    }
  }

  public static void main(String[] args) {
    /*
     * Make class Typer which will type it's Message symbol by symbol every 500ms
     */

    /*
     * This code has to print Message first. Message second. in 15 seconds
     */
    new Typer("Message One. ").start();
    new Typer("Message Two.\n").start();

  }
}