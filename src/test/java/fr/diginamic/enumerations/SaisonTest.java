package fr.diginamic.enumerations;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SaisonTest {

    @Test
    public void valueOfLibelle() {
        final String libelle = "Printemps";
        final Saison saison = Saison.valueOfLibelle(libelle);
        assertEquals(saison, Saison.PRINTEMPS);

        final String libelle2 = "printemps";
        final Saison saison2 = Saison.valueOfLibelle(libelle2);
        assertEquals(saison2, Saison.PRINTEMPS);

        final String libelle3 = "Eté";
        final Saison saison3 = Saison.valueOfLibelle(libelle3);
        assertEquals(saison3, Saison.ETE);

        final String libelle4 = "été";
        final Saison saison4 = Saison.valueOfLibelle(libelle4);
        assertEquals(saison4, Saison.ETE);

        final String libelle5 = "Automne";
        final Saison saison5 = Saison.valueOfLibelle(libelle5);
        assertEquals(saison5, Saison.AUTOMNE);

        final String libelle6 = "automne";
        final Saison saison6 = Saison.valueOfLibelle(libelle6);
        assertEquals(saison6, Saison.AUTOMNE);
    }

    @Test
    public void getLibelle() {
        final Saison saison = Saison.PRINTEMPS;
        assertEquals(saison.getLibelle(), "Printemps");

        final Saison saison2 = Saison.ETE;
        assertEquals(saison2.getLibelle(), "Eté");

        final Saison saison3 = Saison.AUTOMNE;
        assertEquals(saison3.getLibelle(), "Automne");

        final Saison saison4 = Saison.HIVER;
        assertEquals(saison4.getLibelle(), "Hiver");
    }
}