package entities;

public class Manuel extends Livre {
    private String niveau;

    public Manuel(String titre, String auteur, int nbrPages, String niveau) {
        super(titre, auteur, nbrPages);
        this.niveau = niveau;
    }

    @Override
    public String toString() {
        return "Manuel#" + numEnreg + " [titre=" + titre 
            + ", auteur=" + auteur 
            + ", pages=" + nbrPages 
            + ", niveau=" + niveau + "]";
    }
}
