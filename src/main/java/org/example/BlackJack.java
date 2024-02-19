package org.example;
import java.util.Scanner;

public class BlackJack {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("---- Bienvenue au Blackjack! ----");

        int soldeJetons = 200; // Solde initial des jetons

        while (true) {
            System.out.println("\n-- Menu principal --");
            System.out.println("1- Commencer à jouer");
            System.out.println("2- Consulter mon solde de jetons");
            System.out.println("0- Quitter le jeu");
            System.out.print("Entrez votre choix: ");
            int choixMenu = scanner.nextInt();
            scanner.nextLine(); // Pour consommer la ligne restante après la saisie du choix

            if (choixMenu == 1) {
                System.out.print("Combien voulez-vous miser pour cette partie de jeu? ");
                int mise = scanner.nextInt();
                scanner.nextLine(); // Pour consommer la ligne restante après la saisie de la mise
                if (mise > soldeJetons) {
                    System.out.println("Vous n'avez pas assez de jetons pour miser cette somme. Veuillez miser moins.");
                    continue;
                }

                System.out.println(">>> Commencement du jeu");

                // Initialiser le jeu
                PaquetCartes paquet = new PaquetCartes();
                paquet.melanger();

                Joueur joueur = new Joueur();
                Croupier croupier = new Croupier();

                joueur.tirerCarte(paquet);
                joueur.tirerCarte(paquet);
                croupier.tirerCarte(paquet);

                System.out.println("Votre main: " + joueur);
                System.out.println("Main du croupier: " + croupier.premiereCarte());

                // Tour du joueur
                while (true) {
                    System.out.println("Voulez-vous tirer une carte supplémentaire ? (o/n)");
                    String choix = scanner.nextLine();
                    if (choix.equalsIgnoreCase("o")) {
                        joueur.tirerCarte(paquet);
                        System.out.println("Votre main: " + joueur);
                        if (joueur.estBust()) {
                            System.out.println("Vous avez dépassé 21, vous avez perdu!");
                            soldeJetons -= mise;
                            break;
                        }
                    } else {
                        break;
                    }
                }

                // Tour du croupier
                System.out.println("Main du croupier: " + croupier);
                while (croupier.doitTirer()) {
                    croupier.tirerCarte(paquet);
                    System.out.println("Main du croupier: " + croupier);
                    if (croupier.estBust()) {
                        System.out.println("Le croupier a dépassé 21, vous avez gagné!");
                        soldeJetons += mise;
                        break;
                    }
                }

                // Détermination du vainqueur si personne n'a bust
                if (!joueur.estBust() && !croupier.estBust()) {
                    int totalJoueur = joueur.getTotalPoints();
                    int totalCroupier = croupier.getTotalPoints();
                    System.out.println("Votre total: " + totalJoueur);
                    System.out.println("Total du croupier: " + totalCroupier);

                    if (totalJoueur > totalCroupier) {
                        System.out.println("Vous avez gagné!");
                        soldeJetons += mise;
                    } else if (totalJoueur < totalCroupier) {
                        System.out.println("Le croupier a gagné!");
                        soldeJetons -= mise;
                    } else {
                        System.out.println("Égalité!");
                    }
                }

            } else if (choixMenu == 2) {
                System.out.println("- Votre solde de jetons est de: " + soldeJetons + " pièces");
            } else if (choixMenu == 0) {
                System.out.println("Merci d'avoir joué au Blackjack! Au revoir.");
                break;
            } else {
                System.out.println("Choix invalide. Veuillez choisir une option valide.");
            }
        }

        scanner.close();
    }
}
