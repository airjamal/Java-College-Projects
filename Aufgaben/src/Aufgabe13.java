
public class Aufgabe13 {
	
	public static void main(String args[]){
		final char MAXCHAR = Character.MAX_VALUE;
		final char MINCHAR = Character.MIN_VALUE;
		char posChar = 'a';
		char negChar = 'A';
		byte posByte = 1;
		byte negByte = -1;
		short posShort = Short.MAX_VALUE;
		short negShort = Short.MIN_VALUE;
		int smallInt = 65535;
		int bigInt = 65536;
		int count = 1;

		//Was wird Ausgegeben?
		System.out.println(count++ + ". MAXCHAR: " + (int) MAXCHAR + "\tMINCHAR: " + (int) MINCHAR);
		System.out.println();
		System.out.println(count++ + ". posChar: " + posChar + "\t\tnegChar: " + negChar);
		System.out.println(count++ + ". posChar: " + (int) posChar + "\t\tnegChar: " + (int) negChar);
		System.out.println();
		posChar = (char) posByte;
		negChar = (char) negByte;
		System.out.println(count++ + ". posChar: " + (int) posChar + "\t\tnegChar: " + (int) negChar);
		System.out.println();
		posChar = (char) posShort;
		negChar = (char) negShort;
		System.out.println(count++ + ". posChar: " + (int) posChar + "\t\tnegChar: " + (int) negChar);
		System.out.println();
		posChar = (char) smallInt;
		negChar = (char) bigInt;
		System.out.println(count++ + ". posChar: " + (int) posChar + "\tnegChar: " + (int) negChar);
	}
}
