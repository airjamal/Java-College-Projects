


/**
* Unterklasse Broetchen
*
* @author Berhan, Jamal, Sefa
*
*/

public class Broetchen extends Zutat {
	
	/**
	 * @param backzeit - Die Dauer der Backzeit
	 * @param hoehe - Die Hoehe
	 */
	private int backzeit;
	private float hoehe;
	
	/**
	 * Broetchen Konstruktor.
	 *
	 * @param nummer - Die Nummer
	 * @param name - Der Name
	 * @param preis - Der Preis
	 * @param klassisch - "Klassisch"-Eigenschaft
	 * @param vegan - "Vegan"-Eigenschaft
	 * @param vegetarsich - "Vegetarisch"-Eigenschaft
	 * @param backzeit - Zubereitungszeit
	 * @param hoehe - Die Hoehe
	 */
	public Broetchen(int nummer,String name, float preis, boolean klassisch, boolean vegan, boolean vegetarisch, int backzeit, int hoehe) {
		super(nummer, name, preis, klassisch, vegan, vegetarisch);
		this.backzeit = backzeit;
		this.hoehe = hoehe;
	}

	/**  
	* Rueckgabe der Zubereitungszeit 
	* @see Oberklasse Zutat
	*/
	public int zubereiten() {
		if (backzeit > 0) {
			System.out.println(getName() + " wird " + (backzeit / 60) + " Minuten aufgebacken.");
		} else {
			System.out.println(getName()+ " wird direkt verwendet.");
		}
		return this.backzeit;
	}

	/**
	 * Rueckgabe der Zubereitungszeit
	 * @return backzeit
	 */
	public int getZeit() {
		return this.backzeit;
	}

	/** 
	* Rueckgabe der Hoehe
	* @see Oberklasse Zutat
	*/
	public float berechneHoehe() {
		float gebHoehe = hoehe + (backzeit/60f) * 0.25f;
		return gebHoehe;
	}
	
	/**
	 * @return backzeit
	 */
	public String toString(){
		if(backzeit > 0){
			return (super.toString() + " " + backzeit + " Sekunden Backzeit ");
		}else{
			return super.toString();
		}
	}
}

