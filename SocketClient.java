// Importation des bibliothèques nécessaires
import java.io.*;
import java.net.*;
import java.util.Scanner;

// Définition de la classe SocketClient
class SocketClient {
    // Méthode principale
    public static void main(String argv[]) {
        int port = 0; // Initialisation du port à 0
        String host = ""; // Initialisation du nom d'hôte à une chaîne vide
        Scanner keyb = new Scanner(System.in); // Création d'un objet Scanner pour lire depuis le clavier

        // Demande à l'utilisateur de spécifier le nom du serveur
        System.out.print("Nom du serveur : ");
        host = keyb.next(); // Lecture du nom du serveur depuis le clavier

        // Demande à l'utilisateur de spécifier le port du serveur
        System.out.print("Port du serveur : ");
        try {
            port = keyb.nextInt(); // Lecture du port du serveur depuis le clavier
        } catch (NumberFormatException e) {
            System.err.println("Le second paramètre n'est pas un entier.");
            System.exit(-1); // Quitter le programme en cas d'erreur de formatage
        }

        // Tentative de création de la connexion au serveur
        try {
            // Résolution de l'adresse IP du serveur
            InetAddress adr = InetAddress.getByName(host);

            // Création d'un socket client avec l'adresse IP et le port du serveur
            Socket socket = new Socket(adr, port);

            // Initialisation des flux de sortie et d'entrée pour envoyer et recevoir des données
            ObjectOutputStream output = new ObjectOutputStream(socket.getOutputStream());
            ObjectInputStream input = new ObjectInputStream(socket.getInputStream());

            // Envoi d'une chaîne de caractères au serveur via le flux de sortie
            output.writeObject(new String("ma première socket"));

            // Lecture de la réponse du serveur depuis le flux d'entrée
            String chaine = (String) input.readObject();

            // Affichage de la réponse du serveur
            System.out.println(" recu du serveur : " + chaine);
        } catch (Exception e) {
            System.err.println("Erreur : " + e); // Affichage de l'erreur en cas de problème
        }
    }
}
