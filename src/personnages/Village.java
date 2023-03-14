package personnages;

public class Village {
	private String nom; 
	private Chef chef; 
	private Gaulois villageois[];
	private int nbVillageois = 0;
		
	public Village(String nom, int nbVillageoisMaximum) { 
		this.nom = nom; 
		this.villageois = new Gaulois[nbVillageoisMaximum];
	} 
	public void setChef(Chef chef) { 
		this.chef = chef; 
	} 
	public String getNom() { 
		return nom; 
	} 
	public void ajouterHabitant(Gaulois gaulois) {
		villageois[nbVillageois]=gaulois;
		nbVillageois++;
	}
	public Gaulois trouverHabitant(int num) {
		return villageois[num];
	}
	public void afficherVillageois() {
		System.out.println("Dans le "+getNom()+" du chef "+chef.getNom()+" vivent les légendaires gaulois :");
		for (int i = 0; i < nbVillageois; i++) {
			System.out.println("- "+villageois[i].getNom());
		}
	}
	public static void main(String[] args) {
		Village village = new Village("Village des Irréductibles",30);
//		Gaulois gaulois = village.trouverHabitant(30);
//		Exception ArrayIndexOutOfBounds car 30 est plus grand que la taille du tableau
		Chef abraracourcix = new Chef("Abraracourcix",6,village);
		village.setChef(abraracourcix);
		Gaulois asterix = new Gaulois("Astérix",8);
		village.ajouterHabitant(asterix);
//		Gaulois gaulois = village.trouverHabitant(1);
//		System.out.println(gaulois);
//		Renvoie null car le chef n'est pas compté comme habitant, donc 
//		asterix est le seul et donc 1 est OutOfRange mais non (???)
		Gaulois obelix = new Gaulois("Obélix",25);
		village.ajouterHabitant(obelix);
		village.afficherVillageois();
	}
}
