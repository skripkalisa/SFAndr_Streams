package Mod12.Examples.Methods;

import java.util.Random;

class ChickenEgg extends Thread {

  public ChickenEgg(String name) {
    super(name);
  }

  @Override
  public void run() {
    for (int i = 0; i < 5; i++) {
      try {
        // Приостанавливаем поток
        sleep(getTimeSleep());
        System.out.println(getName());
      } catch (InterruptedException e) {
      }
    }
  }

  final Random random = new Random();

  int getTimeSleep() {

    return random.nextInt(300);
  }

  public static void main(String[] args) {
    // Создание потоков с именами
    ChickenEgg chicken = new ChickenEgg("Курица");
    ChickenEgg egg = new ChickenEgg("Яйцо");
    System.out.println("Начинаем спор: кто появился первым?");
    // Запуск потоков
    chicken.start();
    egg.start();
    // Пока оба потока работают
    while (chicken.isAlive() || egg.isAlive()) {
      try {
        // Приостанавливаем поток "судьи"
        Thread.sleep(100);
        System.out.println("Курица");
      } catch (InterruptedException e) {
      }
    }
    // Cказало ли яйцо последнее слово?
    if (egg.isAlive()) {
      try {
        // Прерываем яйцо
        egg.interrupt();
        // Ждем, пока яйцо закончит высказываться
        egg.join();
      } catch (InterruptedException e) {
      }

      System.out.println("Первым появилось яйцо!");
    } else {
      try {
        // Прерываем курицу
        chicken.interrupt();
        // Ждем, пока курица закончит высказываться
        chicken.join();
      } catch (InterruptedException e) {
      }
      System.out.println("Первой появилась курица!");
    }
    System.out.println("Спор закончен");
  }
}

// public class Main {

// }