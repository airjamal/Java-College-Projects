
public class Aufgabe36_1 {
	public static void main(String[] args) {
		Aufgabe36 ersteDose, zweiteDose;
		
		Aufgabe36.energyLevel = 10;
		
		ersteDose = new Aufgabe36();
		
		ersteDose.height = StaticScanner.nextFloat();
	
		ersteDose.radius = StaticScanner.nextFloat();
		
		zweiteDose = new Aufgabe36();
	
		zweiteDose.height = StaticScanner.nextFloat();
		
		zweiteDose.radius = StaticScanner.nextFloat();
		
		System.out.println("Die Kraft und Volume der ersten Dose: " + ersteDose.energy() + " J" + " , " + ersteDose.volume() + " ml");
		System.out.println();
		System.out.println("Die Kraft und Volume der zweiten Dose: " + zweiteDose.energy() + " J" + " , " + zweiteDose.volume() + " ml");
	}
}
