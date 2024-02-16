import java.io.*;
import java.net.*;

public class Ex2_client {
    public static void main(String[] args) {
        try {
            Socket socket = new Socket("localhost", 10000); // Connexion au serveur sur le port 10000
            ObjectOutputStream out = new ObjectOutputStream(socket.getOutputStream());

            // Création et envoi de l'objet Voiture
            Voiture voiture = new Voiture("Berline", "Toyota");
            voiture.setCarburant(50); // Fixer la quantité de carburant
            out.writeObject(voiture);
            
            out.close();
            socket.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
