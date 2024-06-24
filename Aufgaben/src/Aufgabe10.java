
public class Aufgabe10 {

	public static void main(String [] args) {
		final int anzahlZeile = 8;
		final int anzahlSpalte = 8;

		for (int zeile = 0; zeile < anzahlZeile; zeile++) {
			for (int spalte = 0; spalte < anzahlSpalte; spalte++) {
				if ((spalte + zeile)%2 == 0) System.out.print("0");
				else System.out.print("1");
			}
		}
	}
}
