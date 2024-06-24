
public class Aufgabe21 {

	public static void main(String[] args) {

		int tipp = 0;
		int becher = (int) (Math.random() * 3 + 1);

		System.out.println("gebe deinen tipp ab");
		

		// System.out.print(tipp + " = " + becher + " ?");

		do {
			tipp = StaticScanner.nextInt();
			if (tipp == becher)
				System.out.println("Richtig!!!");
			else
				System.out.println("Falsch, tippen sie erneut: ");
			} while (tipp != becher);
		}
	}
