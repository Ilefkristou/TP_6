import java.io.*;
import java.net.*;

public class Ex2_serveur {
    public static void main(String[] args) {
        try {
            ServerSocket serverSocket = new ServerSocket(10000); // Création du serveur sur le port 10000
            System.out.println("Serveur en attente de connexion...");
            Socket socket = serverSocket.accept(); // Attente de connexion d'un client
            System.out.println("Connexion établie avec le client.");

            ObjectInputStream in = new ObjectInputStream(socket.getInputStream());

            // Réception de l'objet Voiture
            Voiture voiture = (Voiture) in.readObject();
            System.out.println("Voiture reçue : " + voiture.getType() + " " + voiture.getModel());
            System.out.println("Quantité de carburant : " + voiture.getCarburant() + " litres");

            in.close();
            socket.close();
            serverSocket.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
