
public class Aufgabe11 {
	
	public static void main(String [] args) {
		
		//variablen
		char variable1;
		char variable2;
		
		boolean answer1 = true;
		boolean answer2 = true;
		boolean answer3 = true;
		
		//berechnung (Vergleich)
		System.out.print("Buchstabe 1.: ");
		variable1 = StaticScanner.nextChar();
		
		System.out.print("Buchstabe 2.: ");
		variable2 = StaticScanner.nextChar();
		
		answer1 = variable1 < variable2;
		answer2 = variable1 > variable2;
		answer3 = variable1 == variable2;
		
		
		//Ausgabe
		if (answer1 == true) {
			System.out.println(variable1 + " ist kleiner als " + variable2);
		}
		if (answer2 == true) {
			System.out.println(variable1 + " ist größer als " + variable2);
		}	
		if (answer3 == true) {
			System.out.println(variable1 + " ist gleich " + variable2);
		}
	}
}
