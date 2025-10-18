package entities;

public class Roman extends Livre {
    private double prix;

    public Roman(String titre, String auteur, int nbrPages, double prix) {
        super(titre, auteur, nbrPages);
        this.prix = prix;
    }

    @Override
    public String toString() {
        return "Roman#" + numEnreg + " [titre=" + titre 
            + ", auteur=" + auteur 
            + ", pages=" + nbrPages 
            + ", prix=" + prix + "]";
    }
}
