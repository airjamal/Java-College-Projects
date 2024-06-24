
public class Aufgabe6 {

	public static void main(String [] args) {
		
		double ergebnis;
		
		//Variablen
		int variable1;
		
		System.out.print("1.Zahl: ");
		variable1 = StaticScanner.nextInt();
			
		int variable2;
		
		System.out.print("2.Zahl: ");
		variable2 = StaticScanner.nextInt();
			
		//Berechnung
		ergebnis = variable1 + variable2;
		
		//Ausgabe
		System.out.println("Ergebnis: " + ergebnis);
	}
}
