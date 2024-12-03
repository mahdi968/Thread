package socketThread;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

class AccepterClients implements Runnable {
    private ServerSocket serverSocket;
    private int nbrclient = 1;

    public AccepterClients(ServerSocket serverSocket) {
        this.serverSocket = serverSocket;
    }

  

	public void run() {
        try {
            while (true) {
                Socket clientSocket = serverSocket.accept();
                System.out.println("Le client numéro " + nbrclient + " est connecté !");
                nbrclient++;

                
                Thread clientHandler = new Thread(new ClientHandler(clientSocket));
                clientHandler.start();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

