package entities;

import java.util.ArrayList;

public class Bibliotheque {
    private int capacite;
    private ArrayList<Document> documents;

    public Bibliotheque(int capacite) {
        this.capacite = capacite;
        this.documents = new ArrayList<>();
    }

    public boolean ajouter(Document doc) {
        if (documents.size() >= capacite) {
            return false;
        }
        documents.add(doc);
        return true;
    }

    public boolean supprimer(Document doc) {
        return documents.remove(doc);
    }

    public Document document(int numEnreg) {
        for (Document d : documents) {
            if (d.getNumEnreg() == numEnreg) return d;
        }
        return null;
    }

    public void afficherDocuments() {
        System.out.println("Documents de la bibliothèque :");
        for (Document d : documents) {
            System.out.println("  - " + d);
        }
    }

    public void afficherAuteurs() {
        System.out.println("Liste des auteurs :");
        for (Document d : documents) {
            if (d instanceof Livre) {
                System.out.println("  - " + ((Livre)d).getAuteur());
            }
        }
    }
}
