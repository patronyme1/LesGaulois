package personnages;

public class Village {
	private String nom;
	private Gaulois chef;
	private Gaulois[] villageois;
    private int nbVillageois = 0;

	public Village(String nom, Gaulois chef, int nbVillageoisMaximum) {
		this.nom = nom;
		this.chef = chef;
		this.villageois = new Gaulois[nbVillageoisMaximum];
	}

	public String getNom() {
		return nom;
	}

	public void setChef(Gaulois chef) {
		this.chef = chef;
	}
	
	public Gaulois getChef() {
        return this.chef;
    }
	
	public void ajouterHabitant(Gaulois gaulois) {
	    if (nbVillageois < villageois.length) {
	        villageois[nbVillageois] = gaulois;
	        nbVillageois++;
	    }
	}
	
	public Gaulois trouverVillageois(int numeroVillageois) {
	    int indice = numeroVillageois - 1;
	    if (indice >= 0 && indice < nbVillageois) {
	        return villageois[indice];
	    } else {
	        System.out.println("Il n’y a pas autant d’habitants dans notre village !");
	        return null;
	    }
	}
	
	public static void main(String[] args) {
	    Gaulois abraracourcix = new Gaulois("Abraracourcix", 6);
	    Village village = new Village("Village des Irréductibles", abraracourcix, 30);

	    System.out.println("Test avec un villageois inexistant (30) :");
	    Gaulois gauloisTest = village.trouverVillageois(30); 

	    Gaulois asterix = new Gaulois("Astérix", 8);
	    village.ajouterHabitant(asterix);

	    System.out.println("\nTest de recherche des villageois 1 et 2 :");
	    Gaulois gauloisTrouve = village.trouverVillageois(1);
	    System.out.println(gauloisTrouve.getNom()); 

	    gauloisTrouve = village.trouverVillageois(2);
	    System.out.println(gauloisTrouve);
	    
	    System.out.println("\nAjout d'Obélix et affichage du village :");
	    Gaulois obelix = new Gaulois("Obélix", 25);
	    village.ajouterHabitant(obelix);
	    village.afficherVillageois();

	    System.out.println("\nPrésentation des personnages :");
	    Gaulois doublepolemix = new Gaulois("Doublepolémix", 4);
	    
	    abraracourcix.sePresenter();
	    asterix.sePresenter();
	    doublepolemix.sePresenter();
	}
	
	public void afficherVillageois() {
	    System.out.println("Dans le village \"" + getNom() + "\" du chef " + chef.getNom() + " vivent les légendaires gaulois :");
	    for (int i = 0; i < nbVillageois; i++) {
	        System.out.println("- " + villageois[i].getNom());
	    }
	}
}
