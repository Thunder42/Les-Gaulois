package personnages;

public class Romain {
	private String nom;
	private int force;
	private Equipement equipements[];
	private int nbEquipement = 0;
	
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
	public void sEquiper(Equipement equip) {
		switch (nbEquipement) {
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
		equipements[nbEquipement] = equip;
		nbEquipement++;
		System.out.println("Le soldat "+getNom()+" s'équipe avec un "+equip.toString()+".");
	}
	public Equipement[] recevoirCoup(int forceCoup) {
		Equipement[] equipementEjecte = null;
		// précondition
		assert force > 0;
		int oldForce = force;
		forceCoup = calculResistanceEquipement(forceCoup);
		force -= forceCoup;
//		if (force > 0) {
//			parler("Aïe");
//		} else {
//			equipementEjecte = ejecterEquipement();
//			parler("J'abandonne...");
//		}
		if (force > 0) {
			parler("Aïe");
		} else {
			equipementEjecte = ejecterEquipement();
			parler("J'abandonne...");
		}
		// post condition la force a diminuée
		assert force < oldForce;
		return equipementEjecte;
		}
	
	private int calculResistanceEquipement(int forceCoup) {
		String texte = "Ma force est de " + this.force + ", et la force du coup est de " + forceCoup;
		int resistanceEquipement = 0;
		if (nbEquipement != 0) {
			texte += "\nMais heureusement, grace à mon équipement sa force est diminué de ";
			for (int i = 0; i < nbEquipement;i++) {
				if (equipements[i] != null && equipements[i].equals(Equipement.BOUCLIER)) {
					resistanceEquipement += 8;
				} else {
					System.out.println("Equipement casque");
					resistanceEquipement += 5;
				}
			}
			texte += resistanceEquipement + "!";
		}
		parler(texte);
		forceCoup -= resistanceEquipement;
		return forceCoup;
	}
	
	private Equipement[] ejecterEquipement() {
		Equipement[] equipementEjecte = new Equipement[nbEquipement];
		System.out.println("L'équipement de " + nom + "s'envole sous la force du coup.");
		int nbEquipementEjecte = 0;
		for (int i = 0; i < nbEquipement; i++) {
			if (equipements[i] != null) {
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