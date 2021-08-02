package Mod12.Task1;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;

public class ChatServer {

  ArrayList<Client> clients = new ArrayList<>();
  ServerSocket serverSocket;

  ChatServer() throws IOException {
    serverSocket = new ServerSocket(1234);
  }

  public void sendAll(String message) {
    for (Client client : clients)
      client.receive(message);
  }

  public void run() {
    while (true) {
      System.out.println("Waiting... ");
      // ждем клиента из сети
      Socket socket;
      try {
        socket = serverSocket.accept();
        System.out.println("Client connected!");
        // создаем клиента на своей стороне
        clients.add(new Client(socket, this));

      } catch (IOException e) {
        // TODO Auto-generated catch block
        e.printStackTrace();
      }
    }
  }

  public static void main(String[] args) throws IOException {
    new ChatServer().run();
  }
}
