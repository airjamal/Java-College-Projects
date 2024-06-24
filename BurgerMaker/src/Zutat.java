


/**
 * Unterklasse Broetchen
 *
 * @author Berhan, Jamal, Sefa
 *
 */

public abstract class Zutat {

	// Die Nummer der Zutat
	protected int nummer;

	// Der Name der Zutat
	protected String name;

	// Der Preis der Zutat
	protected float preis;

	// Die Hoehe der Zutat
	protected float hoehe;

	// Die Eigenschaften der Zutaten
	protected boolean klassisch = false;
	protected boolean vegan = false;
	protected boolean vegetarisch = false;
	

	/**
	 * Zutat Konstruktor.
	 *
	 * nummer - Die Nummer der Zutat name - Der Name der Zutat preis - Der Preis der
	 * Zutat klassisch - "Klassisch"-Eigenschaft der Zutat vegan -
	 * "Vegan"-Eigenschaft der Zutat vegetarisch - "Vegetarisch"-Eigenschaft der
	 * Zutat bratzeit - Zubereitungszeit der Zutat hoehe - Die Hoehe der Zutat
	 */
	public Zutat(int nummer, String name, float preis, boolean klassisch, boolean vegan, boolean vegetarisch) {
		this.nummer = nummer;
		this.name = name;
		this.preis = preis;
		this.klassisch = klassisch;
		this.vegan = vegan;
		this.vegetarisch = vegetarisch;
	}

	// Getter Methode dafür ob die Zutat klassisch ist
	public boolean getKlassisch() {
		return klassisch;
	}

	// Getter Methode dafür ob die Zutat vegetarisch ist
	public boolean getVegetarisch() {
		return vegetarisch;
	}

	// Getter Methode dafür ob die Zutat vegan ist
	public boolean getVegan() {
		return vegan;
	}

	// Getter Methode für den Preis der Zutat
	public float getPreis() {
		return this.preis;
	}

	// Getter Methode für den Namen der Zutaten
	public String getName() {
		return this.name;
	}

	// Getter Methode für die Nummer der Zutaten
	public int getNummer() {
		return this.nummer;
	}

	// Getter Methode für die Zeit der Zutaten
	public int getZeit() {
		return 0;
	}

	// Getter Methode für die Hoehe der Zutaten
	public float getHoehe() {
		return this.hoehe;
	}

	// Abstract Methode für die Zubereitung
	public abstract int zubereiten();

	// Abstract Methode für die Berechnung der Hoehe der Zutaten
	public abstract float berechneHoehe();

	// Hier wird zurückgegeben, was für eine Bedingung die Zutat hat
	public String toString() {
		String rueckgabe = String.format("%-20s", this.name) + String.format("%.2f", this.preis) + " Euro";
		if (klassisch) {
			rueckgabe += " klassisch";
		}
		if (vegan) {
			rueckgabe += " vegan";
		}
		if (vegetarisch) {
			rueckgabe += " vegetarisch";
		}
		return String.format("%-50s ", rueckgabe);
	}
}

