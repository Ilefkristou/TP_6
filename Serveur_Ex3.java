import java.io.*;
import java.net.*;

public class Serveur_Ex3 {
    private static int clientIdCounter = 1;

    public static void main(String[] args) {
        try {
            ServerSocket serverSocket = new ServerSocket(10000); // Création du serveur sur le port 10000
            System.out.println("Serveur en attente de connexion...");
            while (true) {
                Socket socket = serverSocket.accept(); // Attente de connexion d'un client
                System.out.println("Connexion établie avec un client.");

                ObjectOutputStream out = new ObjectOutputStream(socket.getOutputStream());
                ObjectInputStream in = new ObjectInputStream(socket.getInputStream());

                // Réception des informations sur une personne
                int age = in.readInt();
                String nom = (String) in.readObject();
                
                // Traitement des informations (dans cet exemple, on renvoie simplement l'identifiant du client)
                int clientId = clientIdCounter++;
                System.out.println("Informations reçues : Age = " + age + ", Nom = " + nom);
                out.writeInt(clientId);

                out.close();
                in.close();
                socket.close();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
