package Mod11.Examples.Lists.LIFO;

import java.util.Deque;

public class Worker {
    private Deque toDo; // у рабочего есть ссылка на очередь из заданий

    public Worker(Deque toDo) {
        this.toDo = toDo; // даем ссылку на очередь в конструкторе
    }

    public void takeTask() {
        Object task = toDo.pollLast(); // вынимаем задание из очереди
        if (task != null) {
            System.out.println("Выполняю задачу: " + task);
        } else {
            System.out.println("Нет работы! Можно идти домой");
        }
    }
}
