
public class Aufgabe27 {

	public static void main(String[] args) {

		int zeile = StaticScanner.nextInt();
		int anzahl = StaticScanner.nextInt();
		int baum = 0;
		int maxZeilen = 5;

		do {
			System.out.println();
			maxZeilen = Tannenbaum1(anzahl, zeile);
		} while (maxZeilen != 5);
		Tannenbaum2(baum);
	}

	public static int Tannenbaum1(int a, int z) {
		System.out.println("Zeile? (1-5)");
		z = StaticScanner.nextInt();
		System.out.println();
		System.out.println("Wie viele in dieser Zeile?");
		a = StaticScanner.nextInt();
		return a;
	}

	public static void Tannenbaum2(int b) {
		for (int i = 0; i <= b; i++) {
			System.out.print("* ");
		}
	}
}
