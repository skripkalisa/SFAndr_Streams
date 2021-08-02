package Mod12.Examples.Quiz;

class Test extends Thread {
  String str;

  public Test(String str) {
    this.str = str;
  }

  @Override
  public void run() {
    System.out.print(str);
  }

  public static void main(String[] args) {
    Test t1 = new Test("Thread1");
    Test t2 = new Test("Thread2");
    Test t3 = new Test("Thread3");
    t1.start();
    t3.run(); // 1
  }
}
