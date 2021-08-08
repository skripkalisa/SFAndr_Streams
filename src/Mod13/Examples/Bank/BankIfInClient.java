package Mod13.Examples.Bank;

public class BankIfInClient {
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
        // выдаем кредит, только если
        // есть свободные средства
        if (getMoney() >= 1000) {
          take(1000);
          repay(1000);
        }
      }
    }
  }

  public BankIfInClient(int clients) {

    for (int i = 0; i < clients; i++) {
      new Client().start();

    }
    // ;
    // new Client().start();
    // new Client().start();
  }

  public static void main(String[] args) throws InterruptedException {
    BankIfInClient bankIfInClient = new BankIfInClient(20);
    while (true) {
      System.out.println(bankIfInClient.money);
      Thread.sleep(100);
    }
  }

}
