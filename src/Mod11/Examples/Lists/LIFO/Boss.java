package Mod11.Examples.Lists.LIFO;

import java.util.Deque;

public class Boss {
    private Deque toDo;// у босса тоже есть ссылка на очередь из заданий
    public Boss(Deque toDoQueue) {
        this.toDo = toDoQueue;// даем ссылку на очередь в конструкторе
    }
    public void giveTask(String task) {
        toDo.add(task); // кладем задание в очередь
        System.out.println("Дал задачу " + task);
    }
}
