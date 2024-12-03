package socketThread;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

class ClientHandler implements Runnable {
    private Socket clientSocket;

    public ClientHandler(Socket clientSocket) {
        this.clientSocket = clientSocket;
    }

    public void run() {
        try {
           
            BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
            PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);

            
            out.println("Bienvenue sur le serveur !");
            String message;
            while ((message = in.readLine()) != null) {
                System.out.println("Message reçu du client : " + message);
                out.println("Message reçu : " + message); 
            }

         
            clientSocket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}