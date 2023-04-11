package personnages;

public class Gaulois {
	private String nom;
	private int force;
	private int effetPotion = 1;
	private int nb_trophees;
	private Equipement[] trophees = new Equipement[100];
	
	public Gaulois(String nom, int force) {
		this.nom = nom;
		this.force = force;
	}
	public String getNom() {
		return nom;
	}
	public void parler(String texte) {
		System.out.println(prendreParole() + "' " + texte + " '");
	}
	private String prendreParole() {
		return "Le gaulois " + nom + " : ";
	}
	public void frapper(Romain romain) {
		System.out.println(nom + " envoie un grand coup dans la mâchoire de " + romain.getNom());
		Equipement[] tr = romain.recevoirCoup((force / 3) * effetPotion);
		for (int i = 0; tr != null && i < tr.length; i++, nb_trophees++) {
			this.trophees[nb_trophees] = tr[i];
		}
	}
	public void boirePotion(int forcePotion) {
		effetPotion = forcePotion;
		parler("Merci druide, je sens que ma force est " + effetPotion + " fois décuplée");
	}
	public void faireUneDonnation(Musee musee) {
		if (nb_trophees != 0) {
			String texte = "Je donne au musee tous mes trophees :";
			for (int i=0;i<nb_trophees;i++) {
				texte+="\n- "+ trophees[i].toString();
				parler(texte);
				musee.donnerTrophees(this, trophees[i]);
			}
		}
	}
	//Utiliser les règles de sonarLint pour modifier le code
	public static void main(String[] args) {
		Gaulois asterix = new Gaulois("Astérix",8);
		System.out.println(asterix);
		System.out.println(asterix.prendreParole());
		asterix.parler("Ca va faire mal, ca va barder la baguarre !!");
		Romain baba = new Romain("Orum",5,2);
		asterix.frapper(baba);
		asterix.boirePotion(7);
		asterix.frapper(baba);
	}
}