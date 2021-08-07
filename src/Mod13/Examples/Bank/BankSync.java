package Mod13.Examples.Bank;

public class BankSync {

  private int money = 10000;
  // переменная, по которой и будем синхронизироваться
  private Object lock = new Object();

  int getMoney() {
    return money;
  }

  void take(int money) {
    synchronized (lock) {
      this.money -= money;
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

  public BankSync() {
    new Client().start();
    new Client().start();
    new Client().start();
  }

  public static void main(String[] args) throws InterruptedException {
    BankSync bankSync = new BankSync();
    while (true) {
      System.out.println(bankSync.money);
      Thread.sleep(1000);
    }
  }

}
