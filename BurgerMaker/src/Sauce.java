


/**
 * Unterklasse Broetchen
 *
 * @author Berhan, Jamal, Sefa
 *
 */

public class Sauce extends Zutat {

	/**
	 *  menge     - Die Saucenmenge
	 *  geschmack - Geschmack des Burgers
	 */
	private int menge = 5;
	private String geschmack = "normal";

	/**
	 * Sauce Konstruktor.
	 *
	 *  nummer      - Die Nummer der Sauce
	 *  name        - Der Name der Sauce 
	 *  preis       - Der Preis der Sauce
	 *  klassisch   - "Klassisch"-Eigenschaft von der Sauce
	 *  vegan       - "Vegan"-Eigenschaft von der Sauce
	 *  vegetarsich - "Vegetarisch"-Eigenschaft von der Sauce
	 */
	public Sauce(int nummer, String name, float preis, boolean klassisch, boolean vegan, boolean vegetarisch, int menge,
			String geschmack) {
		super(nummer, name, preis, klassisch, vegan, vegetarisch);
		this.menge = menge;
		this.geschmack = geschmack;
	}

	/**
	 * Rueckgabe der Zubereitungszeit
	 * 
	 * @see Oberklasse Zutat
	 */
	public int zubereiten() {
		System.out.println(this.getName() + " wird geschuettelt.");
		return 0;
	}

	/**
	 * Rueckgabe des Geschmacks
	 * 
	 * @return geschmack
	 */
	public String getGeschmack() {
		return this.geschmack;
	}

	/**
	 * Rueckgabe der Hoehe der Sauce
	 * 
	 * @see Oberklasse Zutat
	 */
	public float berechneHoehe() {
		return 0;
	}

	/**
	 * 
	 * @return Der Sauce mit der gewissen Menge und dem Geschmack 
	 */
	public String toString() {
		return (super.toString() + " " + menge + "ml " + geschmack);
	}
}
