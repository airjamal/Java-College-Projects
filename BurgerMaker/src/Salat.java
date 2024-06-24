
/**
* Unterklasse Broetchen
*
* @author Berhan, Jamal, Sefa
*
*/

public class Salat extends Zutat{
	
	/**
	 * Salat Konstruktor.
	 *
	 *  nummer - Die Nummer
	 *  name - Der Name
	 *  preis - Der Preis
	 *  klassisch - "Klassisch"-Eigenschaft
	 *  vegan - "Vegan"-Eigenschaft
	 *  vegetarsich - "Vegetarisch"-Eigenschaft
	 */
	public Salat(int nummer,String name,float preis,boolean klassisch){
		super(nummer, name, preis, klassisch,true,true);
	}
	
	/**  
	* Rueckgabe der Zubereitungszeit 
	* @see Oberklasse Zutat
	*/
	public int zubereiten() {
		System.out.println(this.getName() + " wird gewaschen und geschleudert");
		return 0;
	}
	
	/** 
	* Rueckgabe der Hoehe
	* @see Oberklasse Zutat
	*/
	public float berechneHoehe() {
		return 0;
	}

}
