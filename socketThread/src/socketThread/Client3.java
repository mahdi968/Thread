package socketThread;

import java.io.*;
import java.net.*;

public class Client3 {
    public static void main(String[] args) {
        try {
            Socket socket = new Socket("localhost", 2022);

            
            BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
            BufferedReader keyboard = new BufferedReader(new InputStreamReader(System.in));

           
            System.out.println("Serveur : " + in.readLine());

           
            String message;
            while (true) {
                System.out.print("Votre message : ");
                message = keyboard.readLine();
                if (message.equalsIgnoreCase("exit")) {
                    System.out.println("Déconnexion...");
                    break;
                }
                out.println(message); 
                System.out.println("Serveur : " + in.readLine()); 
            }

           
            socket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
