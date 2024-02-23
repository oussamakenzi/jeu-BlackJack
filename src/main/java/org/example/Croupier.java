package org.example;
import java.util.ArrayList;
import java.util.List;

public class Croupier implements CroupierInterface{
    private List<Carte> main;

    public Croupier() {
        main = new ArrayList<>();
    }

    public void tirerCarte(PaquetCartes paquet) {
        main.add(paquet.tirerCarte());
    }

    public List<Carte> getMain() {
        return main;
    }

    public int getTotalPoints() {
        int total = 0;
        int nombreAs = 0;

        for (Carte carte : main) {
            total += carte.getValeur();
            if (carte.getValeur() == 11) {
                nombreAs++;
            }
        }

        while (total > 21 && nombreAs > 0) {
            total -= 10;
            nombreAs--;
        }

        return total;
    }

    public boolean doitTirer() {
        return getTotalPoints() < 17;
    }

    public Carte premiereCarte() {
        return main.get(0);
    }
    public boolean estBust() {
        return getTotalPoints() > 21;
    }


    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < main.size(); i++) {
            if (i == 0) {
                builder.append(main.get(i)).append(", [Carte cachée]");
            } else {
                builder.append(", ").append(main.get(i));
            }
        }
        return builder.toString();
    }
}
