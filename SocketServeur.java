// Import des classes nécessaires pour la communication via les sockets
import java.io.*;
import java.net.*;
import java.util.Scanner;

// Définition de la classe côté serveur
public class SocketServeur {
    // Méthode principale
    public static void main(String argv[]) {
        // Initialisation des variables
        int port = 0; // Port sur lequel le serveur écoute
        Scanner keyb = new Scanner(System.in); // Scanner pour la saisie utilisateur

        // Demande à l'utilisateur de saisir le port d'écoute
        System.out.print("Port d'écoute : ");
        try {
            // Tentative de lecture du port saisi par l'utilisateur
            port = keyb.nextInt();
        } catch (NumberFormatException e) { // Gestion de l'exception si la saisie n'est pas un entier
            System.err.println("Le paramètre n'est pas un entier.");
            System.err.println("Usage : java ServeurUDP port-serveur");
            System.exit(-1); // Sortie du programme avec code d'erreur
        }

        try {
            // Création d'un objet ServerSocket qui écoute sur le port spécifié
            ServerSocket serverSocket = new ServerSocket(port);

            // Attente de la connexion d'un client et acceptation de la connexion
            Socket socket = serverSocket.accept();

            // Création de flux de sortie et d'entrée pour la communication avec le client
            ObjectOutputStream output = new ObjectOutputStream(socket.getOutputStream());
            ObjectInputStream input = new ObjectInputStream(socket.getInputStream());

            // Lecture du message envoyé par le client
            String chaine = (String) input.readObject();
            System.out.println(" recu : " + chaine); // Affichage du message reçu

            // Affichage de l'adresse IP et du port du client
            System.out.println(" ca vient de : " + socket.getInetAddress() + ":" + socket.getPort());

            // Envoi d'une réponse au client
            output.writeObject(new String("bien recu"));

        } catch (Exception e) { // Gestion des exceptions
            System.err.println("Erreur : " + e); // Affichage de l'erreur
        }
    }
}