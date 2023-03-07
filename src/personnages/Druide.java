package personnages;

import java.util.Random;

public class Druide {
	private String nom;
	private int effetPotionMin;
	private int effetPotionMax;
	private int forcePotion=1;
	
	public Druide(String nom, int effetPotionMin, int effetPotionMax) {
		super();
		this.nom = nom;
		this.effetPotionMin = effetPotionMin;
		this.effetPotionMax = effetPotionMax;
		parler("Bonjour, je suis le druide " + nom + " et ma potion peut aller d'une force " + effetPotionMin + " � " + effetPotionMax + ".");
	}

	public String getNom() {
		return nom;
	}
	public void parler(String texte) {
		System.out.println(prendreParole() + "' " + texte + " '");
	}
	private String prendreParole() {
		return "Le druide " + nom + " : ";
	}
	private int preparerPotion() {
		Random random = new Random();
		forcePotion = random.nextInt(effetPotionMax);
		boolean entre = false;
		while (!entre) {
			if (forcePotion > effetPotionMin) {
				entre = true;
			} else {
				forcePotion = random.nextInt(effetPotionMax);
			}
		}
		if (forcePotion>7) {
			parler("J'ai pr�par� une super potion de force");
		} else {
			parler("Je n'ai pas trouv� tous les ingr�dients, ma potion est seulement de force");
		}
		return forcePotion;
	}
	public static void main(String[] args) {
		Druide panoramix = new Druide("Panoramix",5,10);
		for (int i = 0; i < 3; i++) {
			int a = panoramix.preparerPotion();
			System.out.println(a);
		}
	}
}