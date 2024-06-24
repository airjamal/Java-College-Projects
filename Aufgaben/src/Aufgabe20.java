
public class Aufgabe20 {
	
	public static void main(String[] args) {

		int x, result;
		System.out.print("Eingabe: ");
		x = StaticScanner.nextInt();
		result = 0;

		while (x / Math.pow(10, result) > 1) {
			result++;
		}
		for (int i = result - 1; i >= 0; i--) {
			System.out.println((int) (x / Math.pow(10, i) % 10)); 
		}
		/* System.out.print("Ausgabe: " + result); */
	}
}
