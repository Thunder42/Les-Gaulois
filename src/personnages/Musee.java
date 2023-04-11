package personnages;

public class Musee {
	private Trophee[] trophees = new Trophee[200];
	private int nb_trophees = 0;
	
	public void donnerTrophees(Gaulois gaulois, Equipement equipement) {
		Trophee tr = new Trophee(gaulois,equipement);
		trophees[nb_trophees] = tr;
		nb_trophees++;
	}
	public String extraireInstructionsCaml() {
		String texte = "let "+ this + "= [";
		for (int i = 0;i<nb_trophees;i++) {
			texte+=trophees[i].getGaulois().getNom()+", "+trophees[i].getEquipement().toString();
		}
		texte+=" ]";
		return texte;
	}
}
