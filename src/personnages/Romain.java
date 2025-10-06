package personnages;

public class Romain {
	private String nom;
	private int force;

	public Romain(String nom, int force) {
		assert force > 0 : "La force initiale d'un Romain doit être positive.";
		this.nom = nom;
		this.force = force;
		assert isInvariantVerified() : "Invariant non respecté à la création.";
	}

	public String getNom() {
		return nom;
	}

	public void parler(String texte) {
		System.out.println(prendreParole() + "\"" + texte + "\"");
	}

	private String prendreParole() {
		return "Le romain " + nom + " : ";
	}
	
	private boolean isInvariantVerified() {
		return this.force >= 0;
	}

	public void recevoirCoup(int forceCoup) {
		assert forceCoup > 0 : "La force du coup doit être positive.";
        int oldForce = this.force;
		this.force -= forceCoup;
		if (this.force < 1) {
			this.force = 0;
			parler("J'abandonne...");
		} else {
			parler("Aïe !");
		}
		
        assert this.force < oldForce : "La force n'a pas diminué après le coup.";
        assert isInvariantVerified() : "Invariant non respecté après avoir reçu un coup.";
	}
	
	public static void main(String[] args) {
		Romain minus = new Romain("Minus", 6);
        System.out.println("Romain Minus créé avec une force de 6.");
        minus.recevoirCoup(3);
	}
	
	@Override
	public String toString() {
		return nom;
	}
}
