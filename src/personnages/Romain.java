package personnages;

public class Romain {
	private String nom;
	private int force;
	private Equipement equipements[];
	private int nbEquipement = 0;
	private String texte;
	
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
//	public void recevoirCoup(int forceCoup) {
//		assert (force > 0);
//		int oldForce = force;
//		force-=forceCoup;
//		if (force>0) {
//			parler("A�e!");
//		} else {
//			parler("J'abandonne...");
//		}
//		assert (force < oldForce);
//	}
	public void sEquiper(Equipement equip) {
		switch (nbEquipement) {
		case 2:
			System.out.println("Le soldat "+getNom()+" est d�ja bien prot�g� !");
		break;
		case 1:
			if (equipements[0] == equip) {
				System.out.println("Le soldat "+getNom()+" poss�de d�j� un "+equip.toString()+"!");
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
		equipements[nbEquipement] = equip;
		nbEquipement++;
		System.out.println("Le soldat "+getNom()+" s'�quipe avec un "+equip.toString()+".");
	}
	public Equipement[] recevoirCoup(int forceCoup) {
		Equipement[] equipementEjecte = null;
		// pr�condition
		assert force > 0;
		int oldForce = force;
		forceCoup = CalculResistanceEquipement(forceCoup);
		force -= forceCoup;
//		if (force > 0) {
//			parler("A�e");
//		} else {
//			equipementEjecte = ejecterEquipement();
//			parler("J'abandonne...");
//		}
		switch (force) {
		case 0:
			parler("A�e");
		default:
			equipementEjecte = ejecterEquipement();
			parler("J'abandonne...");
			break;
		}
		// post condition la force a diminu�e
		assert force < oldForce;
		return equipementEjecte;
		}
	private int CalculResistanceEquipement(int forceCoup) {
		texte = "Ma force est de " + this.force + ", et la force du coup est de " + forceCoup;
		int resistanceEquipement = 0;
		if (!(nbEquipement == 0)) {
			texte += "\nMais heureusement, grace � mon �quipement sa force est diminu� de ";
			for (int i = 0; i < nbEquipement;) {
				if ((equipements[i] != null && equipements[i].equals(Equipement.BOUCLIER)) == true) {
					resistanceEquipement += 8;
				} else {
					System.out.println("Equipement casque");
					resistanceEquipement += 5;
				}
				i++;
			}
			texte =+ resistanceEquipement + "!";
		}
		parler(texte);
		forceCoup -= resistanceEquipement;
		return forceCoup;
	}
	
	private Equipement[] ejecterEquipement() {
		Equipement[] equipementEjecte = new Equipement[nbEquipement];
		System.out.println("L'�quipement de " + nom.toString() + "s'envole sous la force du coup.");
		//TODO
		int nbEquipementEjecte = 0;
		for (int i = 0; i < nbEquipement; i++) {
			if (equipements[i] == null) {
				continue;
			} else {
				equipementEjecte[nbEquipementEjecte] = equipements[i];
				nbEquipementEjecte++;
				equipements[i] = null;
			}
		}
		return equipementEjecte;
	}
	public int getForce() {
		return force;
	}
	//Utiliser les r�gles de sonarLint pour modifier le code
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
	}
}