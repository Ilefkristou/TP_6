import java.io.*;
import java.net.*;

public class Client_ex3 {
    public static void main(String[] args) {
        try {
            Socket socket = new Socket("localhost", 10000); // Connexion au serveur sur le port 10000
            ObjectOutputStream out = new ObjectOutputStream(socket.getOutputStream());
            ObjectInputStream in = new ObjectInputStream(socket.getInputStream());

            // Envoi des informations sur une personne
            int age = 30;
            String nom = "John Doe";
            out.writeInt(age);
            out.writeObject(nom);

            // Réception de l'identifiant du client
            int clientId = in.readInt();
            System.out.println("Identifiant du client : " + clientId);

            out.close();
            in.close();
            socket.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
