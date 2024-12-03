package socketThread;

import java.io.*;
import java.net.*;

public class Serveur3 {
    public static void main(String[] args) {
        ServerSocket serverSocket;
        try {
            serverSocket = new ServerSocket(2022);
            Thread t = new Thread(new AccepterClients(serverSocket));
            t.start();
            System.out.println("Serveur concurrent prêt :");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
