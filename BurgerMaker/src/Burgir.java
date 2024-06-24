
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
	public String name;

	// Die Eigenschaften des Burgers
	public boolean klassisch;
	public boolean vegan;
	public boolean vegetarisch;

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
	public float preis;
	public float hoehe;
	public int time;
	public String typ;
	public int nummer;
	public String geschmack = "Normal";
	public int berechneHoehe;
	public float gesamtPreis;

	/**
	 * Array für die Zutaten
	 */
	Zutat[] zutaten = new Zutat[9];

	/**
	 * Burger Konstruktor
	 * 
	 * @param vegan       - "Vegan"-Eigenschaft
	 * @param vegetarisch - "Vegetarisch"-Eigenschaften
	 * @param klassisch   - "Klassische"-Eigenschaft
	 */
	public Burgir(String name, Zutat[] zutaten) {
		this.vegan = true;
		this.vegetarisch = true;
		this.klassisch = true;

		for (int i = 0; i < zutaten.length; i++) {
			if (zutaten[i] != null) {
				this.zutaten[i] = zutaten[i];
				this.nummer += zutaten[i].getNummer();
				this.preis += zutaten[i].getPreis();

				if (zutaten[i].getVegan() == false) {
					this.vegan = false;
				}
				if (zutaten[i].getVegetarisch() == false) {
					this.vegetarisch = false;
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
	public int zubereiten() {
		for (Zutat zutat : this.zutaten) {
			if (zutat != null) {
				zutat.zubereiten();
			}
		}
		return this.time;
	}

	/**
	 * Berechnung der Zeit
	 */
	public int berechneZeit() {
		for (int i = 0; i < zutaten.length; i++) {
			if (zutaten[i] != null) {
				zutaten[i].zubereiten();
			}
		}
		return this.time;
	}

	/**
	 * Berechnung der Hoehe
	 */
	public void berechneHoehe() {
		hoehe = 0;
		for (int i = 0; i < zutaten.length; i++) {
			if (zutaten[i] != null) {
				this.hoehe = hoehe + zutaten[i].berechneHoehe();
			}
		}
	}

	/**
	 * Berechnung des Preises
	 */
	public void berechnePreis() {
		float gesamtPreis = 0;
		for (int i = 0; i < zutaten.length; i++) {
			if (zutaten[i] != null) {
				this.gesamtPreis = gesamtPreis + zutaten[i].getPreis();
			}
		}
	}

	public void hinzufuegen() {
		int speicher = 0;

		for (int i = 0; i < zutaten.length; i++) {
			if (zutaten[i] != null) {
				speicher++;
			}
		}
		if (speicher < zutaten.length) {
			System.out.println("Du kannst noch eine Zutat hinzufuegen ");
		} else {
			System.out.println("Die maximale Anzahl an Zutaten wurde erreicht ");
		}
	}

	/**
	 * zubereiten
	 */
	public int getZubereitungszeit() {

		return zubereiten();
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
		return name;
	}

	/**
	 * @return preis
	 */
	public float getPreis() {
		return preis;
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
		return gesamtPreis;
	}

	/**
	 * @param gesamtPreis
	 */
	public void setGesamtPreis(float gesamtPreis) {
		this.gesamtPreis = gesamtPreis;
	}

	/**
	 * @return hoehe
	 */
	public float getHoehe() {
		return hoehe;
	}

	/**
	 * @param hoehe
	 */
	public void setHoehe(int hoehe) {
		this.hoehe = hoehe;
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
	public int getBerechneHoehe() {
		return berechneHoehe;
	}

	/**
	 * 
	 * @param berechneHoehe
	 */
	public void setBerechneHoehe(int berechneHoehe) {
		this.berechneHoehe = berechneHoehe;
	}
}
