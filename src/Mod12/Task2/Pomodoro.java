package Mod12.Task2;

import javax.swing.*;
import java.awt.*;

public class Pomodoro extends JFrame {

  JTextArea textArea;
  JScrollPane scrollPane;


  Pomodoro(int timerShow, int timerHide) {

    super("Simple Chat client");
    setSize(800, 600);
    setDefaultCloseOperation(EXIT_ON_CLOSE);

    textArea = new JTextArea();
    textArea.setBackground(Color.BLACK);
    textArea.setForeground(Color.YELLOW);
    textArea.append(
        "Готовьте помидоры, чтобы развить способность концентрироваться и расслабляться. \nПросто отключите все устройства, которые могут вас отвлечь, поставьте таймер на 25 минут, \nсосредоточьтесь, а в конце вознаградите себя. \n");
    textArea.setEditable(false);
    textArea.setMargin(new Insets(10, 10, 10, 10));
    scrollPane = new JScrollPane(textArea);
    this.add(scrollPane);

    new Thread() {
      public void run() {
        while (!isInterrupted()) {
          try {
            Thread.sleep(timerHide);
          } catch (InterruptedException e) {
            System.out.println("Error: " + e.getMessage());
          }
          showUp();

          System.out.println("Работаем не покладая рук " + (float) (timerHide / 1000) / 60 + " минут");
          try {
            Thread.sleep(timerShow);
            hideOut();
          } catch (InterruptedException e) {
          System.out.println("Отдыхаем " + (float) (timerShow / 1000) / 60 + " минут");
          }
        }
      }
    }.start();

  }

  void hideOut() {
    this.setVisible(false);
  }

  void showUp() {
    this.setVisible(true);
  }

}
