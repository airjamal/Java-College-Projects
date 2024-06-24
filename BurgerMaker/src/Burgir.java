
/**
 * Burger Klasse
 *
 * @author Berhan, Jamal, Sefa
 *
 */

public class Burgir {

//	Zutat preis, name, nummer, berechneHoehe, zubereiten;

	/**
	 * 
	 * 
	 */
	public static final String length = null;

	// Der Name des Burgers
	private String name;

	// Die Eigenschaften des Burgers
	private boolean klassisch;
	private boolean vegan;
	private boolean vegetarisch;

	/**
	 * 
	 * @param preis         - Der Preis
	 * @param hoehe         - Die Hoehe
	 * @param time          - Die Zeit
	 * @param typ           - Der Typ des Burgers
	 * @param nummer        - Die Nummer der Zutat
	 * @param geschmack     - Der Geschmack des Burgers gesetzt auf Klassisch
	 * @param berechneHoehe - Die Berechnung der Hoehe
	 * @param gesamtPreis   - Der gesamte Preis des Burgers
	 */
	
	
	private String typ;
	private int nummer;
	private String geschmack = "Normal";
	private int berechneHoehe;

	/**
	 * Array für die Zutaten
	 */
	private Zutat[] zutaten = new Zutat[9];

	/**
	 * Burger Konstruktor
	 * 
	 * @param vegan       - "Vegan"-Eigenschaft
	 * @param vegetarisch - "Vegetarisch"-Eigenschaften
	 * @param klassisch   - "Klassische"-Eigenschaft
	 */
	public Burgir() {
		this.vegan = true;
		this.vegetarisch = true;
		this.klassisch = true;

		for (int i = 0; i < zutaten.length; i++) {
			if (zutaten[i] != null) {
				this.zutaten[i] = zutaten[i];
				this.nummer += zutaten[i].getNummer();

				if (zutaten[i].getVegan() == true) {
					this.vegan = true;
				}
				if (zutaten[i].getVegetarisch() == true) {
					this.vegetarisch = true;
				}
				if (zutaten[i].getVegan() == false || zutaten[i] instanceof Bratling) {
					if (zutaten[i] instanceof Bratling) {
						Bratling bratling = (Bratling) zutaten[i];
						if (!bratling.getName().equalsIgnoreCase("VEGGIE")) {
							this.vegetarisch = false;
						}
					} else if (zutaten[i].getVegan() == false) {
						this.vegetarisch = false;
					}

				}
				if (zutaten[i].getKlassisch() == false) {
					this.klassisch = false;
				}
				if (zutaten[i] instanceof Sauce) {
					Sauce sauce = (Sauce) zutaten[i];
					this.geschmack = sauce.getGeschmack();
				}
			}
		}
	}

	/**
	 * Rueckgabe des Zustandes des Burgers
	 * 
	 * @return ausgabe
	 */
	public String toString() {
		String ausgabe = "";
		for (int i = 0; i < zutaten.length; i++) {
			if (zutaten[i] != null) {
				ausgabe = ausgabe + zutaten[i].toString() + "\n";
			}
		}
		return ausgabe;
	}

	/**
	 * Rueckgabe der Zubereitungszeit
	 * 
	 * @return time
	 */
	public float zubereiten() {
	 float time = 0;
		for (Zutat zutat : this.zutaten) {
			if (zutat != null) {
				time += zutat.zubereiten();
			}
		}
		return time;
	}

	/**
	 * Berechnung der Zeit
	 */
	public float berechneZeit() {
		float time = 0;
		for (int i = 0; i < zutaten.length; i++) {
			if (zutaten[i] != null) {
				time = (time + zutaten[i].zubereiten() / 60);
			}
		}
		return time;
	}

	/**
	 * Berechnung der Hoehe
	 */
	public float berechneHoehe() {
		float hoehe = 0;
		for (int i = 0; i < zutaten.length; i++) {
			if (zutaten[i] != null) {
				hoehe = hoehe + zutaten[i].berechneHoehe();
			}
		}
		return hoehe;
	}

	/**
	 * Berechnung des Preises
	 */
	public float berechnePreis() {
		
		float gesamtPreis = 0;
		for (int i = 0; i < zutaten.length; i++) {
			if (zutaten[i] != null) {
				gesamtPreis = gesamtPreis + zutaten[i].getPreis();
			}
		}
		return gesamtPreis;
	}

	public boolean hinzufuegen() {

		int speicher = 0;
		boolean voll = false;

		for (int i = 0; i < zutaten.length; i++) {
			if (zutaten[i] != null) {
				speicher++;
			}
		}
		for (int z = 0; z < 9; z++) {
			if (z < zutaten.length) {
				voll = false;
			} else {
				voll = true;
			}
		}

		if (speicher < zutaten.length) {
			System.out.println("\nDu kannst noch eine Zutat hinzufuegen");
			voll = false;
		} else {
			System.out.println("\nDie maximale Anzahl an Zutaten wurde erreicht");
			voll = true;
		}
		return voll;
	}

	/**
	 * zubereiten
	 */
	public float getZubereitungszeit() {
		return berechneZeit();
	}

	/**
	 * @param nummer
	 */
	public void setZutat(int nummer) {
		this.nummer = nummer;
	}

	/**
	 * @return name
	 */
	public String getName() {
		return this.name;
	}

	/**
	 * @return preis
	 */
	public float getPreis() {
		return this.getGesamtPreis();
	}

	/**
	 * @param name
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return typ
	 */
	public String getTyp() {
		return typ;
	}

	/**
	 * @param typ
	 */
	public void setTyp(String typ) {
		this.typ = typ;
	}

	/**
	 * @return klassisch
	 */
	public boolean getKlassisch() {
		return klassisch;
	}

	/**
	 * @param klassisch
	 */
	public void setKlassisch(boolean klassisch) {
		this.klassisch = klassisch;
	}

	public boolean getVegetarisch() {
		return vegetarisch;
	}

	public void setVegetarisch(boolean vegetarisch) {
		this.vegetarisch = vegetarisch;
	}

	public boolean getVegan() {
		return vegetarisch;
	}

	public void setVegan(boolean vegan) {
		this.vegan = vegan;
	}

	/**
	 * @return geschmack
	 */
	public String getGeschmack() {
		return geschmack;
	}

	/**
	 * @param geschmack
	 */
	public void setGeschmack(String geschmack) {
		this.geschmack = geschmack;
	}

	/**
	 * @return gesamtPreis
	 */
	public float getGesamtPreis() {
		return berechnePreis();
	}

	/**
	 * @param gesamtPreis
	 */
	public void setGesamtPreis(float gesamtPreis) {
	}

	/**
	 * @return hoehe
	 */
	public float getHoehe() {
		return this.getHoehe();
	}

	/**
	 * @param hoehe
	 */
	public void setHoehe(int hoehe) {
	}

	/**
	 * @return nummer
	 */
	public int getNummer() {
		return this.nummer;
	}

	/**
	 * @param zutats
	 */
	public void setZutat(Zutat[][] zutats) {
	}

	/**
	 * @return zutaten
	 */
	public Zutat[] getZutaten() {
		return zutaten;
	}

	/**
	 * @param zutaten
	 */
	public void setZutaten(Zutat[] zutaten) {
		this.zutaten = zutaten;
	}

	/**
	 * @return berechneHoehe
	 */
	public float getBerechneHoehe() {
		return berechneHoehe();
	}

	/**
	 * 
	 * @param berechneHoehe
	 */
	public void setBerechneHoehe(int berechneHoehe) {
		this.berechneHoehe = berechneHoehe;
	}
}
