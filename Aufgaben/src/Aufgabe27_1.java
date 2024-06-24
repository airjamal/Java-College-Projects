
public class Aufgabe27_1 {

	public static void main(String[] args) {

		int lang = 1;
		int baum;

		baum = StaticScanner.nextInt();

		Tannenbaum(baum, lang);
		for (int i = 1; i <= baum; i++)
			System.out.print("  ");
		for (int i = 1; i <= lang; i++)
			System.out.print("* ");
	}

	public static void Tannenbaum(int b, int l) {
		while (b != 1) {
			for (int i = 1; i <= b; i++)
				System.out.print("  ");
			for (int i = 1; i <= l; i++)
				System.out.print("* ");
			System.out.println();
			b--;
			l = l + 2;
		}
	}
}
