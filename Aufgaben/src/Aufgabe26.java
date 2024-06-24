
public class Aufgabe26 {

	public static void main(String[] args) {
		// Variablen
		char operator;
		double zahl1;
		double zahl2;
		double summe = 0;
		
		// Berechnungsschleife
		do {
			System.out.println();
			System.out.print("1. Zahl: ");
			zahl1 = StaticScanner.nextDouble();
			System.out.print("Operator: ");
			operator = StaticScanner.nextChar();
			System.out.print("2. Zahl: ");
			zahl2 = StaticScanner.nextDouble();
			summe = TR(zahl1, zahl2, operator, summe);
			System.out.println("Ergebnis: " + summe);
		} while (zahl1 + zahl2 >= 0);
	}
		// Methode
	public static double TR(double za1, double za2, char o, double s) {
			if (o == '+') {
				s = za1 + za2;
			} 
			if (o == '-') {
				s = za1 - za2;
			}
			if (o == '*') {
				s = za1 * za2;
			} 
			if (o == '/') {
				s = za1 / za2;
			} 
			if (o == 'p') {
				s = Math.pow(za1,za2);
			}
		return s;
	}
}
