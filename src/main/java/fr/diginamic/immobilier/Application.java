package fr.diginamic.immobilier;

import fr.diginamic.immobilier.entites.Chambre;
import fr.diginamic.immobilier.entites.Cuisine;
import fr.diginamic.immobilier.entites.Maison;
import fr.diginamic.immobilier.entites.Salon;
import fr.diginamic.immobilier.entites.WC;

public class Application {

	public static void main(String[] args) {
		
		Maison maison = new Maison();
		maison.ajouterPiece(new Salon(0, 25));
		maison.ajouterPiece(new Cuisine(0, 15));
		maison.ajouterPiece(new WC(0, 1.5));
		maison.ajouterPiece(new Chambre(0, 12));
		maison.ajouterPiece(new Chambre(0, 11));
		maison.ajouterPiece(null);
		
		System.out.println(maison.calculerSurface());
		System.out.println(maison.superficieEtage(0));
	}
}
