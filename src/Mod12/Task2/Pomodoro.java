package Mod12.Task2;

import java.awt.Color;
import java.awt.Insets;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

public class Pomodoro extends JFrame implements KeyListener {

	JTextArea textArea;
	JScrollPane scrollPane;
	InputStreamReader in;
	PrintWriter out;

	Pomodoro() {

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
		Thread pomodoro = new Thread() {
			public void run() {
			};
		};
		while (!isInterrupted()) {
			System.out.println("Working hard");
		}
		try {
			Thread.sleep(500);
		} catch (InterruptedException e) {
			// Перехватываем молча
		}
		System.out.println("All done");
	}

	// ToDO
};}

	void showUp() {

		// .start();
		// ToDO

	}

	public static void main(String[] args) {
		new Pomodoro().setVisible(true);
	}
}
