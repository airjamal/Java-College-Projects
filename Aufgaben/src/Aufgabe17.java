
public class Aufgabe17 {

	public static void main(String [] args) {
		// Variablen
		int WochentagNummer;
		char Wochentag = ' ';
		
		// Berechnung
		System.out.println("Nenne mir eine Wochentags-Nummer (1-7): ");
		WochentagNummer = StaticScanner.nextInt();
		switch (WochentagNummer) {
		case 1:
			System.out.println("Es ist Montag");
			break;
		case 2:
			System.out.println("Es ist Dienstag");
			break;
		case 3:
			System.out.println("Es ist Mittwoch");
			break;
		case 4:
			System.out.println("Es ist Donnerstag");
			break;
		case 5:
			System.out.println("Es ist Freitag");
			break;
		case 6:
			System.out.println("Es ist Samstag");
			break;
		case 7:
			System.out.println("Es ist Sonntag");
			break;
		default:
			System.out.println("Falsche Eingabe, versuche es erneut");
			break;
		}
	}
}
