package personnages;
import personnages.Village;

public class Gaulois {
	private String nom;
	private int force;
	private int effetPotion = 1;
	private Village village;

	public Gaulois(String nom, int force) {
		this.nom = nom;
		this.force = force;
	}

	public String getNom() {
		return nom;
	}

	public void parler(String texte) {
		System.out.println(prendreParole() + "\"" + texte + "\"");
	}

	private String prendreParole() {
		return "Le gaulois " + nom + " : ";
	}

	public void frapper(Romain romain) {
		System.out.println(nom + " envoie un grand coup dans la mâchoire de " + romain.getNom());
		romain.recevoirCoup(force / 3);
	}

	@Override
	public String toString() {
		return nom;
	}
	
	public void boirePotion(int forcePotion) {
		this.effetPotion = forcePotion;
	}

	public static void main(String[] args) {
		Gaulois asterix = new Gaulois("Astérix", 8);
		System.out.println(asterix);
	}
	
	public void sePresenter() {
	    System.out.print("Le Gaulois " + getNom() + " : ");
	    if (village == null) {
	        System.out.println("\"Bonjour, je m'appelle " + getNom() + ". Je voyage de villages en villages.\"");
	    } else {
	        if (this == village.getChef()) {
	            System.out.println("\"Bonjour, je m'appelle " + getNom() + ". Je suis le chef du village " + village.getNom() + ".\"");
	        } else {
	            System.out.println("\"Bonjour, je m'appelle " + getNom() + ". J'habite le village " + village.getNom() + ".\"");
	        }
	    }
	}

}
