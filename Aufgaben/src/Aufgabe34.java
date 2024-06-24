
public class Aufgabe34 {

	public int number;
	public String description;
	public boolean open;
	
	
	public void initToDo(int toDoNumber, String toDoListe) {
		number = toDoNumber;
		description = toDoListe;
		open = true;
	}
	public boolean isOpen() {
		return open;
	}
	
	public void finished() {
		open = false;
	}
	
	public void print() {
		System.out.print("Aufgabe " + number + " ist: " + description);
		System.out.println();
		if (open = false) {
		System.out.println("Die Aufgabe wurde erledigt");	
		} else {
		System.out.println("Die Aufgabe ist noch offen");
		}
		
	}
}
