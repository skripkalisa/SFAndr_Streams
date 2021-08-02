package Mod12.Examples.Tests;

public class TestStart extends Thread {
  int i;

  public TestStart(int i) {
    this.i = i;
  }

  @Override
  public void run() {
    System.out.print(i);
  }

  public static void main(String[] args) {
    for (int i = 0; i < 10; i++) {
      new TestStart(i).start();
    }
    System.out.println("");
  }
}