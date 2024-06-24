
public class Aufgabe33_1 {

	public static void main(String[] args) {
		Aufgabe33 ersteDose, zweiteDose;
		
		ersteDose = new Aufgabe33();
		System.out.println("Die Höhe der ersten Dose");
		ersteDose.height = StaticScanner.nextFloat();
		System.out.println("Der Radius der ersten Dose");
		ersteDose.radius = StaticScanner.nextFloat();
		System.out.println("Der Energywert der ersten Dose");
		ersteDose.energyLevel = StaticScanner.nextFloat();
		zweiteDose = new Aufgabe33();
		System.out.println("Die Höhe der zweiten Dose");
		zweiteDose.height = StaticScanner.nextFloat();
		System.out.println("Der Radius der zweiten Dose");
		zweiteDose.radius = StaticScanner.nextFloat();
		System.out.println("Der Energywert der zweiten Dose");
		zweiteDose.energyLevel = StaticScanner.nextFloat();
		
		System.out.println("Die Kraft und Volume der ersten Dose: " + ersteDose.energy() + " J" + " , " + ersteDose.volume() + " ml");
		System.out.println();
		System.out.println("Die Kraft und Volume der zweiten Dose: " + zweiteDose.energy() + " J" + " , " + zweiteDose.volume() + " ml");
	}
}
