package Mod12.Task1;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class Client implements Runnable {
  Socket socket;
  // создаем удобные средства ввода и вывода
  Scanner in;
  PrintStream out;
  ChatServer server;

  public Client(Socket socket, ChatServer server) {

    this.socket = socket;
    this.server = server;
    // запускаем поток
    new Thread(this).start();
  }

  public Client(Socket socket) {
  }

  void receive(String message) {
    out.println(message);
  }

  public void run() {
    try {
      // получаем потоки ввода и вывода
      InputStream is = socket.getInputStream();
      OutputStream os = socket.getOutputStream();
      in = new Scanner(is);
      out = new PrintStream(os);

      // читаем из сети и пишем в сеть
      out.println("Welcome to our chat!");
      String input = in.nextLine();
      while (!input.equals("bye")) {
        server.sendAll(input);
        // out.println(input + "-" + input + "-" + input.substring(input.length() / 2) +
        // "...");
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
