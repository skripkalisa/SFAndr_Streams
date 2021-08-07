package Mod13.Examples.Worker;

import java.util.ArrayList;
import java.util.List;

public class WorkerRef {
  private List<String> list1 = new ArrayList<>();
  private List<String> list2 = new ArrayList<>();

  private void addToListOne() {
    synchronized (list1) {
      for (int i = 0; i < 100000; i++)
        list1.add("One"); // добавляем в первый лист значение

    }
  }

  private void addToListTwo() {
    synchronized (list2)

    {
      for (int i = 0; i < 100000; i++)
        list2.add("Two"); // добавляем во второй лист значение
    }
  }

  class Process extends Thread {
    public void run() {
      for (int i = 0; i < 300; i++) { // 300 раз вызываем оба метода
        addToListOne();
        addToListTwo();
      }
    }
  }

  public static void main(String[] args) throws InterruptedException {
    WorkerRef worker = new WorkerRef(); // строка 1
    Thread t1 = worker.new Process();
    Thread t2 = worker.new Process();

    long start = System.currentTimeMillis();

    t1.start();
    t2.start();

    t1.join();
    t2.join();

    long finish = System.currentTimeMillis();

    System.out.println("list 1 size is: " + worker.list1.size());
    System.out.println("list 2 size is: " + worker.list2.size());
    // замеряем время выполнения
    System.out.println("Time taken: " + (finish - start) + " ms");
  }

}
