
public class Aufgabe16 {

	public static void main(String [] args) {
		
		//Variablen Zuweisung
		int schaltjahr;
		
		//Berechnung		
		System.out.print("Nenne mir ein Jahr: ");
		schaltjahr = StaticScanner.nextInt();

		if (schaltjahr % 4 == 0 && schaltjahr % 100 != 0 || schaltjahr % 400 == 0) {	
		System.out.print(schaltjahr + " ist ein Schaltjahr");
		}
		else {
			System.out.print(schaltjahr + " ist kein Schaltjahr");
		}		
	}
}
