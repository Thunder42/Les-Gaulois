package personnages;

public class Romain {
	private String nom;
	private int force;
	
	public Romain(String nom, int force) {
		assert (force > 0);
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
		return "Le romain " + nom + " : ";
	}
	public void recevoirCoup(int forceCoup) {
		assert (force > 0);
		int oldForce = force;
		force-=forceCoup;
		if (force>0) {
			parler("Aïe!");
		} else {
			parler("J'abandonne...");
		}
		assert (force > oldForce);
	}
	public static void main(String[] args) {
		Romain baba = new Romain("Orum",6);
		System.out.println(baba);
		System.out.println(baba.prendreParole());
		baba.parler("Vous connaissez ma soeur Yaga ?");
		baba.recevoirCoup(8);
	}
}