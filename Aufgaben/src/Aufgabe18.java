
public class Aufgabe18 {
	public static void main(String[] args) {
		
		int tipp = 0;
		int becher = (int) (Math.random() * 3 + 1);
		boolean gefunden = false;

		System.out.println("gebe deinen tipp ab");
		tipp = StaticScanner.nextInt();

		// System.out.print(tipp + " = " + becher + " ?");

		while (!gefunden) {
			if (tipp == becher) {
				System.out.print("Richtig");
				gefunden = true;

			} else {
				System.out.print("Falsch");
				System.out.print("Tippen sie erneut : ");
			}
		}

	}
}
