package Mod11.Examples.Lists.LIFO;

import java.util.ArrayDeque;
import java.util.Deque;

public class Main {
    public static void main(String[] args) {
        int numberOfTasks = 5; // ограничим нашу очередь 5 задачами
        Deque toDo = new ArrayDeque(numberOfTasks); // создаем очередь
        Boss boss = new Boss(toDo); // создаем начальника с ссылкой на
        // очередь
        Worker worker = new Worker(toDo); // то же самое делаем с рабочим
        // в цикле начальник заполняет очередь заданиями
        for (int i = 1; i <= numberOfTasks; i++) {
            boss.giveTask("Задание " + i);
        }

        System.out.println("Начальник закончил давать задания");
        // в цикле говорим рабочему взять задание из очереди и выполнить его
        // скажем ему взять на одно задание больше, чем есть в очереди
        for (int i = 1; i <= numberOfTasks + 1; i++) {
            worker.takeTask();
        }

        Deque deque = new ArrayDeque();
        deque.offer(12);
        deque.add(6);
        deque.add(4);

        deque.poll();
        deque.peek();
        System.out.println(deque.element());
    }
}
