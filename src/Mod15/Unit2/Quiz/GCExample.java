package Mod15.Unit2.Quiz;

public class GCExample {
    static class Answer {
        final int value = 42;
    }

    static class LifeUniverseEverything {
        static final Answer ANSWER = new Answer();
    }

    public static void main(String[] args) {
        Thread thread1 = new Thread(
                GCExample::findAnswerToLifeTheUniverseAndEverything, "thread1");
        Thread thread2 = new Thread(() -> {
                int i = 0;
            while (true) {
                System.out.println(i);
                i++;
                //
            }
        }, "thread2");
        thread1.start();
        thread2.start();
    }

    public static void findAnswerToLifeTheUniverseAndEverything() {
        Answer answer = LifeUniverseEverything.ANSWER;
        System.out.println(answer.value);
    }
}
