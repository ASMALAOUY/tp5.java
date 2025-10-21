package com.example.tp;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        CompteEpargne ce = new CompteEpargne(800.0, 3.0);
        CompteCourant cc = new CompteCourant(200.0, 300.0);

        ce.afficherDetails();
        cc.afficherDetails();
        System.out.println();

        ce.appliquerInterets();
        ce.afficherDetails();
        System.out.println();

        cc.retirer(400);
        cc.afficherDetails();
        System.out.println();

        ce.transfert(cc, 100);
        ce.afficherDetails();
        cc.afficherDetails();
        System.out.println();

        ArrayList<Compte> comptes = new ArrayList<>();
        comptes.add(ce);
        comptes.add(cc);
        comptes.add(new CompteEpargne(500, 2.5));

        for (Compte c : comptes) {
            c.afficherDetails();
        }
    }
}
