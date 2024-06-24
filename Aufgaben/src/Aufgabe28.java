
public class Aufgabe28 {

	public static void main(String[] args) {

		float[] berhanistsus;
		int maxZeilen;
		
		System.out.println("Wie Groﬂ?");
		maxZeilen = StaticScanner.nextInt();
		berhanistsus = new float[maxZeilen];
		
		for (int i = 0; i < berhanistsus.length; i++) {
			System.out.println("Zeile: " + i);
			berhanistsus[i] = StaticScanner.nextFloat();
		}
		Ausgabe(berhanistsus);
		
	}
	public static void Ausgabe(float[] berhanistsus) {
		for (int i = 0; i < berhanistsus.length; i++) {
			System.out.print(berhanistsus[i] + " | ");
		}
	}
}
