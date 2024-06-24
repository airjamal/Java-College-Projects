
public class Aufgabe19 {
	
	public static void main(String [] args) {
		
	int y, result;
	System.out.print("Berechne Fakultät von: ");
	y = StaticScanner.nextInt();
	result = 1;
	
	for (int i = 1; i <= y; i++)
		result = result * i;
	System.out.println("Ausgabe: " + y + "! " + "= " + result);
	
	}
}
