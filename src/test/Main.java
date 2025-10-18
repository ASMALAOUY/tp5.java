package test;

import entities.*;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Nombre de documents dans la bibliothèque : ");
        int n = sc.nextInt();
        sc.nextLine();

        Bibliotheque biblio = new Bibliotheque(n);

        // Initialisation avec deux documents
        biblio.ajouter(new Roman("Le Petit Prince", "Saint-Exupéry", 120, 15.0));
        biblio.ajouter(new Dictionnaire("Le Robert", "Français"));

        boolean quitter = false;
        while (!quitter) {
            System.out.println("\nMenu :");
            System.out.println("1. Ajouter un document");
            System.out.println("2. Afficher tous les documents");
            System.out.println("3. Supprimer un document");
            System.out.println("4. Rechercher un document par numéro");
            System.out.println("5. Afficher les auteurs");
            System.out.println("0. Quitter");
            System.out.print("Choix : ");
            int choix = sc.nextInt();
            sc.nextLine();

            switch(choix) {
                case 1:
                    System.out.print("Type (Roman/Manuel/Revue/Dictionnaire) : ");
                    String type = sc.nextLine();
                    System.out.print("Titre : ");
                    String titre = sc.nextLine();

                    Document doc = null;
                    switch(type.toLowerCase()) {
                        case "roman":
                            System.out.print("Auteur : ");
                            String auteurR = sc.nextLine();
                            System.out.print("Nombre de pages : ");
                            int pagesR = sc.nextInt();
                            System.out.print("Prix : ");
                            double prix = sc.nextDouble();
                            sc.nextLine();
                            doc = new Roman(titre, auteurR, pagesR, prix);
                            break;
                        case "manuel":
                            System.out.print("Auteur : ");
                            String auteurM = sc.nextLine();
                            System.out.print("Nombre de pages : ");
                            int pagesM = sc.nextInt();
                            sc.nextLine();
                            System.out.print("Niveau : ");
                            String niveau = sc.nextLine();
                            doc = new Manuel(titre, auteurM, pagesM, niveau);
                            break;
                        case "revue":
                            System.out.print("Mois : ");
                            String mois = sc.nextLine();
                            System.out.print("Année : ");
                            int annee = sc.nextInt();
                            sc.nextLine();
                            doc = new Revue(titre, mois, annee);
                            break;
                        case "dictionnaire":
                            System.out.print("Langue : ");
                            String langue = sc.nextLine();
                            doc = new Dictionnaire(titre, langue);
                            break;
                        default:
                            System.out.println("Type inconnu !");
                    }

                    if (doc != null) {
                        if (biblio.ajouter(doc))
                            System.out.println("Document ajouté !");
                        else
                            System.out.println("Bibliothèque pleine !");
                    }
                    break;

                case 2:
                    biblio.afficherDocuments();
                    break;

                case 3:
                    System.out.print("Numéro d'enregistrement à supprimer : ");
                    int num = sc.nextInt();
                    sc.nextLine();
                    Document toRemove = biblio.document(num);
                    if (toRemove != null && biblio.supprimer(toRemove))
                        System.out.println("Document supprimé !");
                    else
                        System.out.println("Document introuvable !");
                    break;

                case 4:
                    System.out.print("Numéro d'enregistrement : ");
                    int numSearch = sc.nextInt();
                    sc.nextLine();
                    Document found = biblio.document(numSearch);
                    if (found != null)
                        System.out.println(found);
                    else
                        System.out.println("Document introuvable !");
                    break;

                case 5:
                    biblio.afficherAuteurs();
                    break;

                case 0:
                    quitter = true;
                    break;

                default:
                    System.out.println("Choix invalide !");
            }
        }

        sc.close();
    }
}
