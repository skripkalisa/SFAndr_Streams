package Mod13.Examples.Bank;

public class BankAtomized {
  private int money = 10000;
  // переменная, по которой и будем синхронизироваться
  private Object lock = new Object();

  int getMoney() {
    return money;
  }

  void take(int money) {
    synchronized (lock) {
      // выдаем кредит, только если
      // есть свободные средства
      if (this.money >= 1000) {
        this.money -= money;
      }
    }
  }

  void repay(int money) {
    synchronized (lock) {
      this.money += money;
    }
  }

  class Client extends Thread {
    @Override
    public void run() {
      while (true) {
        take(1000);
        repay(1000);
      }
    }
  }

  public BankAtomized(int clients) {

    for (int i = 0; i < clients; i++) {
      new Client().start();

    }
    // ;
    // new Client().start();
    // new Client().start();
  }

  public static void main(String[] args) throws InterruptedException {
    BankAtomized bankAtomized = new BankAtomized(20);
    while (true) {
      System.out.println(bankAtomized.money);
      Thread.sleep(1000);
    }
  }
}
