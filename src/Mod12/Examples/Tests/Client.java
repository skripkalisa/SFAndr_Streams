package Mod12.Examples.Tests;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class Client implements Runnable {
  Socket socket;

  public Client(Socket socket) {

    this.socket = socket;
  }

  public void run() {
    try {
      // получаем потоки ввода и вывода
      InputStream is = socket.getInputStream();
      OutputStream os = socket.getOutputStream();

      // создаем удобные средства ввода и вывода
      Scanner in = new Scanner(is);
      PrintStream out = new PrintStream(os);

      // читаем из сети и пишем в сеть
      out.println("Welcome to mountains!");
      String input = in.nextLine();
      while (!input.equals("bye")) {
        out.println(input + "-" + input + "-" + input.substring(input.length() / 2) + "...");
        input = in.nextLine();
      }
      socket.close();
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  public static void main(String[] args) throws IOException {
    // создаем серверный сокет на порту 1234
    ServerSocket server = new ServerSocket(1234);
    while (true) {
      System.out.println("Waiting...");
      // ждем клиента из сети
      Socket socket = server.accept();
      System.out.println("Client connected!");
      // создаем клиента на своей стороне
      Client client = new Client(socket);
      // запускаем поток
      Thread thread = new Thread(client);
      thread.start();
    }
    // server.close();
  }
}