
public class Aufgabe24 {

	public static void main(String[] args) {

		double min;
		double max;

		System.out.println("Gebe einen Minimum");
		min = StaticScanner.nextInt();
		System.out.println("Gebe einen Maximum");
		max = StaticScanner.nextInt();

		random(min, max);
	}

	public static void random(double u, double o) {
		int zufallszahl;
		int counter = 20;
		for (int z = 1; z <= counter; z++) {
			zufallszahl = (int) (Math.random() * (o - u) + u);
			System.out.println("Ergebnis " + zufallszahl);
		}
	}
}
