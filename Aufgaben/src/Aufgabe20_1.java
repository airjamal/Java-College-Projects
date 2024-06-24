
public class Aufgabe20_1 {

	public static void main(String[] args) {
		// Variable
		System.out.println("Eingabe: ");
		int zahl = StaticScanner.nextInt();
		int ziffer = zahl;
		int summe = 0;
		// Berechnung
		while (zahl > 0) {
			ziffer = zahl % 10; // das ergibt die letzte Ziffer
			// jetzt kannst du mit ziffer was rechnen
			System.out.print(ziffer + " ");
			summe = summe + ziffer;
			zahl = zahl / 10; // das schneidet die letzte Ziffer ab	
		}
		System.out.print("= " + "Ziffernsumme: " + summe);
	}
}
