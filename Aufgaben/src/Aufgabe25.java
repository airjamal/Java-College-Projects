
public class Aufgabe25 {

	public static void main(String[] args) {
		// Variable
		int zahl;
		int summe = 0;

		do {
			System.out.println();
			System.out.print("Eingabe: ");
			zahl = StaticScanner.nextInt();
			summe = ziffersumme(zahl, summe);
			System.out.print("= " + "Ziffernsumme: " + summe);
			summe = 0;
		} while (zahl > 0);
		System.out.println("Falsche Eingabe, bitte erneut versuchen.");
	}
	// Methode
	public static int ziffersumme(int za, int s) {
		int zi;
		System.out.println();
		// Berechnung
		while (za > 0) {
			zi = za % 10;
			System.out.print(zi + " ");
			s = s + zi;
			za = za / 10;	
		}
		return s;
	}
}
