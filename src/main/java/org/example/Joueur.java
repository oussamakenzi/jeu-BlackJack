package org.example;
import java.util.ArrayList;
import java.util.List;

public class Joueur {
    private List<Carte> main;

    public Joueur() {
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

    public boolean estBust() {
        return getTotalPoints() > 21;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        for (Carte carte : main) {
            builder.append(carte).append(", ");
        }
        if (!main.isEmpty()) {
            builder.setLength(builder.length() - 2);
        }
        return builder.toString();
    }
}
