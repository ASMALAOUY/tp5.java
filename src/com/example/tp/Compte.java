package com.example.tp;

public abstract class Compte {
    private static int compteur = 0;
    private final int numero;
    protected double solde;

    public Compte(double soldeInitial) {
        this.numero = ++compteur;
        this.solde  = soldeInitial;
    }

    public int getNumero() {
        return numero;
    }

    public double getSolde() {
        return solde;
    }

    public void deposer(double montant) {
        if (montant > 0) {
            solde += montant;
            System.out.println("Compte #" + numero + " : dépôt de " + montant);
        }
    }

    public void retirer(double montant) {
        if (montant > 0 && solde >= montant) {
            solde -= montant;
            System.out.println("Compte #" + numero + " : retrait de " + montant);
        } else {
            System.out.println("Compte #" + numero + " : retrait impossible (solde insuffisant)");
        }
    }

    public void transfert(Compte autre, double montant) {
        if (autre == null) {
            System.out.println("Transfert impossible : compte destinataire nul");
            return;
        }
        if (montant <= 0) {
            System.out.println("Transfert impossible : montant invalide");
            return;
        }
        if (solde >= montant) {
            this.retirer(montant);
            autre.deposer(montant);
            System.out.println("Transfert de " + montant + " du compte #" + this.numero + " vers compte #" + autre.getNumero());
        } else {
            System.out.println("Transfert impossible : solde insuffisant");
        }
    }

    
    public abstract void afficherDetails();
}
