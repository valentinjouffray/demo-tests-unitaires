package fr.diginamic.enumerations;

import java.text.Collator;
import java.util.Locale;

/**
 * Représente une saison et fournit les 4 instances de saisons.
 *
 * @author DIGINAMIC
 */
public enum Saison {

    /**
     * Les 4 instances de Saison
     */
    PRINTEMPS("Printemps", 1), ETE("Eté", 2), AUTOMNE("Automne", 3), HIVER("Hiver", 4);

    /**
     * libelle
     */
    private final String libelle;
    /**
     * ordre
     */
    private final int ordre;

    /**
     * Constructeur
     *
     * @param libelle libellé
     * @param ordre   ordre
     */
    Saison(String libelle, int ordre) {
        this.libelle = libelle;
        this.ordre = ordre;
    }

    /**
     * Permet de rechercher une Saison à partir de son libellé
     *
     * @param libelle libellé
     * @return {@link Saison}
     */
    public static Saison valueOfLibelle(String libelle) {
        Collator collator = Collator.getInstance(Locale.FRANCE);
        collator.setStrength(Collator.PRIMARY);
        Saison[] saisons = Saison.values();
        for (Saison saison : saisons) {
            if (collator.equals(libelle, saison.getLibelle())) {
                return saison;
            }
        }
        return null;
    }

    @Override
    public String toString() {
        return ordre + ". " + libelle;
    }

    /**
     * Getter
     *
     * @return the libelle
     */
    public String getLibelle() {
        return libelle;
    }

    /**
     * Getter
     *
     * @return the ordre
     */
    public int getOrdre() {
        return ordre;
    }
}