
public class Aufgabe22 {

	public static void main(String[] args) {
		//Variablen
		int maxReihen = 4;
		int zahlenReihe = 8;
		int abfrage;
		int zeile;
		int spalte;

		// Schachbrett
		for (int z = 1; z <= maxReihen; z++) {
			for (int s = 1; s <= zahlenReihe; s++) {
				if (s % 2 == 0)
					System.out.print("0");
				else
					System.out.print("1");
			}
			System.out.println();
			for (int w = 1; w <= zahlenReihe; w++) {
				if (w % 2 == 0)
					System.out.print("1");
				else
					System.out.print("0");
			}
			System.out.println();
		}

		// Berechnung
		System.out.println();
		System.out.println("Welche Zeile?");
		zeile = StaticScanner.nextInt();
		System.out.println("Welche Spalte?");
		spalte = StaticScanner.nextInt();
		
		if ((zeile + spalte) % 2 == 0){
			System.out.println("Das Feld ist schwarz");
		} else System.out.println("Das Feld ist weiß");
	}
}
