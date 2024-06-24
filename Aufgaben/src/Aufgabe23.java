
public class Aufgabe23 {

	public static void main(String[] args) {
		
		int stufe;
		System.out.println("Wie viele Stufen?");
		stufe = StaticScanner.nextInt();
		Treppe(stufe);

	}

	public static void Treppe(int t) {
		do {
			for (int z = 1; z <= t; z++) {
				System.out.print("* ");
			}
			t--;
			System.out.println();
		} while (t != 0);
		
	}
}
