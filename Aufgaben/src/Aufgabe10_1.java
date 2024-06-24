
public class Aufgabe10_1 {

	public static void main(String [] args) {

		int feld;
		
		System.out.println("Welches Feld überprüfen?");
		feld = StaticScanner.nextInt();
		
		if (feld % 2 == 0 && feld % 8 != 0) {
			System.out.println("Das Feld ist schwarz");
		} else System.out.println("Das Feld ist weiß");
	}
}
