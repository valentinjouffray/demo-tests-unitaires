package fr.diginamic.immobilier.entites;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class MaisonTest {

    private static Maison maison;

    @BeforeEach
    void setMaison() throws Exception {
        maison = new Maison();
        Piece piece1 = new Cuisine(0, 20);
        Piece piece2 = new Salon(1, 30);
        Piece piece3 = new Chambre(2, 40);
        Piece piece4 = new SalleDeBain(2, 10);
        Piece piece5 = new WC(2, 5);
        Piece[] pieces = {piece1, piece2, piece3, piece4, piece5};
        Arrays.stream(pieces).forEach(maison::ajouterPiece);
    }

    @Test
    void ajouterPiece() {
        maison.ajouterPiece(new Cuisine(0, 20));
        int nbCuisine = Arrays.stream(maison.getPieces()).filter(piece -> piece instanceof Cuisine).toList().size();
        assertEquals(2, nbCuisine);

        assertThrows(NullPointerException.class, () -> maison.ajouterPiece(null));
    }

    @Test
    void nbPieces() {
        assertEquals(5, maison.nbPieces());
    }

    @Test
    void superficieEtage() {
        // etage 0 -> 20
        // etage 1 -> 30
        // etage 2 -> 55
        assertEquals(20, maison.superficieEtage(0));
        assertEquals(30, maison.superficieEtage(1));
        assertEquals(55, maison.superficieEtage(2));

        assertThrows(IllegalArgumentException.class, () -> maison.superficieEtage(3));
    }

    @Test
    void superficieTypePiece() {
        // cuisine -> 20
        // salon -> 30
        // chambre -> 40
        // salle de bain -> 10
        // wc -> 5
        assertEquals(20, maison.superficieTypePiece(Piece.TYPE_CUISINE));
        assertEquals(30, maison.superficieTypePiece(Piece.TYPE_SALON));
        assertEquals(40, maison.superficieTypePiece(Piece.TYPE_CHAMBRE));
        assertEquals(10, maison.superficieTypePiece(Piece.TYPE_SDB));
        assertEquals(5, maison.superficieTypePiece(Piece.TYPE_WC));

        assertThrows(NullPointerException.class, () -> maison.superficieTypePiece(null));

        maison = new Maison();
        assertEquals(0, maison.superficieTypePiece(Piece.TYPE_CUISINE));
    }

    @Test
    void calculerSurface() {
        // 20 + 30 + 40 + 10 + 5 = 105
        assertEquals(105, maison.calculerSurface());
    }
}