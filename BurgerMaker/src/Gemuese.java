
/**
* Unterklasse Gemuese
*
* @author Berhan, Jamal, Sefa
*
*/

public class Gemuese extends Zutat{
	
	/*
	 * 
	 */
	private int scheibenDicke = 0;
	private int scheibenAnzahl = 0;
	
	/**
	 * Gemuese Konstruktor.
	 *
	 * int nummer - Die Nummer
	 * param name - Der Name
	 * @param preis - Der Preis
	 * @param klassisch - "Klassisch"-Eigenschaft
	 * @param vegan - "Vegan"-Eigenschaft
	 * @param vegetarsich - "Vegetarisch"-Eigenschaft
	 * @param backzeit - Zubereitungszeit
	 * @param hoehe - Die Hoehe
	 */
	public Gemuese(int nummer, String name, float preis, boolean klassisch,int scheibenAnzahl, int scheibenDicke) {
		super(nummer, name, preis, klassisch, true,true);
		this.scheibenAnzahl = scheibenAnzahl;
		this.scheibenDicke = scheibenDicke;
	}

	/**  
	* Rueckgabe der Zubereitungszeit 
	* @see Oberklasse Zutat
	*/
	public int zubereiten() {
		System.out.println(getName() + " wird gewaschen.");
		for (int scheibe = 0; scheibe == this.scheibenAnzahl; scheibe ++) {
			System.out.println( "Scheibe " + scheibe + " wird mit " + scheibenDicke + " mm Dicke geschnitten.");
		}
		return this.scheibenAnzahl;
	}

	/**
	 * Rueckgabe der Zubereitungszeit
	 * @return backzeit
	 */
	public int getZeit() {
		return scheibenAnzahl;
	}
	
	/** 
	* Rueckgabe des Zustandes des Bratlings
	* @see Oberklasse Zutat 
	*/
	public String toString(){
		return (super.toString() + " " + scheibenAnzahl + " Scheiben á " + scheibenDicke + "mm Dicke");
	}
	
	/** 
	* Rueckgabe der Hoehe
	* @see Oberklasse Zutat
	*/
	public float berechneHoehe() {
		return this.getHoehe();
	}
}
