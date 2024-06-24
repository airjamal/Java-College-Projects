


/**
 * Unterklasse Bratling
 *
 * @author Berhan, Jamal, Sefa
 *
 */

public class Bratling extends Zutat {

	/**
	 * @param bratzeit
	 * @param hoehe
	 *
	 */
	private int bratzeit;
	private float hoehe;

	/**
	 * Bratling Konstruktor.
	 *
	 * @param name        Der Name
	 * @param preis       Der Preis
	 * @param klassisch   "Klassisch"-Eigenschaft
	 * @param vegan       "Vegan"-Eigenschaft
	 * @param vegetarisch "Vegetarisch"-Eigenschaft
	 * @param bratzeit    Zubereitungszeit
	 * @param hoehe       Die Hoehe
	 */
	public Bratling(int nummer, String name, float preis, boolean klassisch, boolean vegan, boolean vegetarisch,
			int bratzeit, int hoehe) {
		super(nummer, name, preis, klassisch, vegan, vegetarisch);
		this.bratzeit = bratzeit;
		this.hoehe = hoehe;
	}

	/**
	 * Rueckgabe der Zubereitungszeit
	 * 
	 * @param this.bratzeit
	 */
	public int zubereiten() {
		System.out.println(getName() + " wird in " + (bratzeit / 60) + " Minuten gegrillt!");
		return this.bratzeit;
	}

	/**
	 * Rueckgabe der Hoehe
	 * 
	 * @param this.hoehe
	 */
	public float berechneHoehe() {
		float gebHoehe = hoehe - (bratzeit/60f) * 0.35f;
		return gebHoehe;
	}

	/**
	 * Rueckgabe des Zustandes des Bratlings
	 * 
	 * @see Oberklasse Zutat
	 */
	public String toString() {
		String veggie = "";
		if (this.getVegetarisch()) {
			veggie = " vegetarisch";
		} else if (this.getVegan()) {
			veggie = " vegan";
		}
		return (super.toString() + " " + (bratzeit / 60) + " Minuten Bratzeit" + veggie);
	}

}