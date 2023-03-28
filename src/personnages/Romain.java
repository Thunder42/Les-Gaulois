package personnages;

public class Romain {
	private String nom;
	private int force;
	private Equipement equipements[];
	private int nbEquipements = 0;
	
	public Romain(String nom, int force, int nbEquipementsMax) {
		assert (force > 0);
		this.nom = nom;
		this.force = force;
		this.equipements = new Equipement[nbEquipementsMax];
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
		assert (force < oldForce);
	}
	public void sEquiper(Equipement equip) {
		switch (nbEquipements) {
		case 2:
			System.out.println("Le soldat "+getNom()+" est déja bien protégé !");
		break;
		case 1:
			if (equipements[0] == equip) {
				System.out.println("Le soldat "+getNom()+" possède déjà un "+equip.toString()+"!");
			} else {
				peutEquiper(equip);
			}
		break;
		case 0:
			peutEquiper(equip);
		break;
		}
	}
	private void peutEquiper(Equipement equip) {
		equipements[nbEquipements] = equip;
		nbEquipements++;
		System.out.println("Le soldat "+getNom()+" s'équipe avec un "+equip.toString()+".");
	}

	public static void main(String[] args) {
		Romain baba = new Romain("Orum",6,2);
		System.out.println(baba.prendreParole());
		baba.parler("Vous connaissez ma soeur Yaga ?");
		baba.recevoirCoup(8);
		Equipement equip1 = Equipement.CASQUE;
		System.out.println(equip1);
		equip1 = Equipement.BOUCLIER;
		System.out.println(equip1);
		equip1 = Equipement.CASQUE;
		baba.sEquiper(equip1);
		baba.sEquiper(equip1);
		Equipement equip2 = Equipement.BOUCLIER;
		baba.sEquiper(equip2);
		baba.sEquiper(equip2);
//      régler ça
	}
}