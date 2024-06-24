
public class Aufgabe8 {

	public static void main(String[] args) {
		// Variablen
		// Trainer
		double x1;
		double y1;
		// Pokémon
		double x2;
		double y2;
		// Ergebnisse
		double a;
		double b;
		double x3;
		double y3;
		double abstand;
		
		// Berechnung
		System.out.println("Position des Trainers: ");
		System.out.println("X-Koordinate: ");
		x1 = StaticScanner.nextDouble();
		System.out.println("Y-Koordinate: ");
		y1 = StaticScanner.nextDouble();
		
		System.out.println("Position des Pokémons: ");
		System.out.println("X-Koordinate: ");
		x2 = StaticScanner.nextDouble();
		System.out.println("Y-Koordinate: ");
		y2 = StaticScanner.nextDouble();	

		System.out.println("Berechnung...");
		x3 = x2 - x1;
		y3 = y2 - y1;
		a = x3 * x3;
		b = y3 * y3;
		abstand = Math.sqrt(a) + Math.sqrt(b);
		/*abstand = abstand / abstand;*/
		
		//Ergebnis
		System.out.println("Der Abstand zwischen dem Pokémon und dem Trainer beträgt " + abstand + " meter");
	}
}
