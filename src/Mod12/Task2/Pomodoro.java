package Mod12.Task2;

import java.awt.Color;
import java.awt.Insets;
import java.io.InputStreamReader;
import java.io.PrintWriter;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

public class Pomodoro extends JFrame {

	JTextArea textArea;
	JScrollPane scrollPane;
	int timerShow;
	int timerHide;
	// InputStreamReader in;
	// PrintWriter out;

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
		// ToDO
		// showUp();
		new Thread() {
			public void run() {
				while (!isInterrupted()) {
					try {
						Thread.sleep(timerHide);
					} catch (InterruptedException e) {
						// e.printStackTrace();
					}
					showUp();
					// showUp();
					System.out.println("Working hard");
					try {
						Thread.sleep(timerShow);
						hideOut();
					} catch (InterruptedException e) {
						// Перехватываем молча
					}
					System.out.println("All done");
				}
			};
		}.start();

		// ToDO
	};

	// private boolean isInterrupted() {
	// return false;
	// }
	void hideOut() {
		this.setVisible(false);
	}

	void showUp() {
		this.setVisible(true);
		// this.start();
		// .start();
		// ToDO

	}

}
