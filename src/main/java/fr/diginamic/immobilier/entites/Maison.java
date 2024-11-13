package fr.diginamic.immobilier.entites;

import java.util.Arrays;

/**
 * Représente une maison avec toutes ses pièces
 *
 * @author DIGINAMIC
 */
public class Maison {

    /**
     * pieces : tableau de pièces de la maison
     */
    private Piece[] pieces;

    /**
     * Constructeur
     */
    public Maison() {
        pieces = new Piece[0];
    }

    /**
     * Ajoute une pièce à la maison
     *
     * @param nvPiece nouvelle pièce à ajouter
     */
    public void ajouterPiece(Piece nvPiece) {

        if (nvPiece == null) {
            throw new NullPointerException("La pièce à ajouter ne peut pas être null");
        }

        // On est obligé d'agrandir le tableau initial de 1 à chaque ajout
        // d'une nouvelle pièce

        // On commence donc par créer un tableau temporaire appelé newTab
        // qui a une taille égale à la tableau du tableau pieces+1
        Piece[] newTab = new Piece[pieces.length + 1];

        // On déverse toutes les pièces du tableau pieces dans newTab
        System.arraycopy(pieces, 0, newTab, 0, pieces.length);

        // On place en dernière position dans le nouveau tableau la nouvelle
        // pièce
        newTab[newTab.length - 1] = nvPiece;

        // Enfin on affecte newTab à pieces
        this.pieces = newTab;
    }

    public int nbPieces() {
        return pieces.length;
    }

    /**
     * Retourne la superficie d'un étage
     *
     * @param choixEtage choix de l'étage
     * @return double
     */
    public double superficieEtage(int choixEtage) {
        int[] etages = Arrays.stream(pieces).mapToInt(Piece::getNumEtage).distinct().toArray();
        if (!Arrays.stream(etages).anyMatch(etage -> etage == choixEtage)) {
            throw new IllegalArgumentException("L'étage " + choixEtage + " n'existe pas");
        }
        return Arrays.stream(pieces).filter(piece -> piece.getNumEtage() == choixEtage).mapToDouble(Piece::getSuperficie).sum();
    }

    /**
     * Retourne la superficie total pour un type de pièce donné
     *
     * @param typePiece type de pièce
     * @return double
     */
    public double superficieTypePiece(String typePiece) {
        if (typePiece == null) {
            throw new NullPointerException("Le type de pièce ne peut pas être null");
        }
        return Arrays.stream(pieces).filter(piece -> piece.getType().equals(typePiece)).mapToDouble(Piece::getSuperficie).sum();
    }

    /**
     * Retourne la surface totale
     *
     * @return double
     */
    public double calculerSurface() {
        return Arrays.stream(pieces).mapToDouble(Piece::getSuperficie).sum();
    }

    /**
     * Getter pour l'attribut pieces
     *
     * @return the pieces
     */
    public Piece[] getPieces() {
        return pieces;
    }

}