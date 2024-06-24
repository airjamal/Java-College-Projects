
public class Aufgabe9 {

	public static void main(String[] args) {
		final int PACKUNGSGROESSE = 6;

		int anzahlFlaschen;
		int anzahlPacks;
		int anzahlEinzelflaschen;

		System.out.print("Anzahl Flaschen: ");
		anzahlFlaschen = StaticScanner.nextInt();

		anzahlPacks = anzahlFlaschen / PACKUNGSGROESSE;

		anzahlEinzelflaschen = anzahlFlaschen % PACKUNGSGROESSE;
		// alternative Berechnung
		// anzahlEinzelflaschen = anzahlFlaschen - (anzahlSixPacks * 6);

		System.out.println(anzahlPacks + " Packungen (" + PACKUNGSGROESSE + " Flaschen/Packung" + " und "
				+ anzahlEinzelflaschen + " Einzelflaschen");

	}
}
