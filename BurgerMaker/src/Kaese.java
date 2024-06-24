

public class Kaese extends Zutat {

	private int schmelzZeit = 0;
	private String typ;
	
	/**
	 *  Kaese Konstruktor.
	 *
	 *  nummer - Die Nummer
	 *  name - Der Name
	 *  preis - Der Preis
	 *  klassisch - "Klassisch"-Eigenschaft
	 *  vegan - "Vegan"-Eigenschaft
	 *  vegetarsich - "Vegetarisch"-Eigenschaft
	 */
	public Kaese(int nummer,String name,float preis,boolean klassisch, boolean vegetarisch, int schmelzZeit, String typ){
		super(nummer, name, preis, klassisch,false,true);
		this.schmelzZeit = schmelzZeit;
		this.typ = typ;
	}
	
	/**  
	* Rueckgabe der Zubereitungszeit 
	* @see Oberklasse Zutat
	*/
	public int zubereiten() {
		System.out.println(this.name + " auf Patty legen und " + schmelzZeit + " Sekunden schmelzen");
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
