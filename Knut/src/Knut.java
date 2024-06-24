import javax.swing.JFrame;

/**
 * Starter der Applikation.
 * 
 * Applikation wird in einem Standard-Fenster der Groesse 700 x 500 angezeigt.
 *
 * @author berdux
 * @author Alexander Wolfgang Mueller
 * @author Berhan Cabuk
 * @author D'Angelo-Jamal Jones
 * @author Sefa Kadir Usullu
 * @version 2.0
 */
public class Knut {
	/**
	 * Starten der Applikation und Anzeige des Fensters
	 * 
	 * @param args wird nicht interpretiert
	 */
	public static void main(String[] args) {
		// Initialisierung des Frames
		JFrame jFrame = new JFrame();
		jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		jFrame.setSize(700, 500);

		/*
		 * Instanziierung der eigentlichen Anzeige, die in der Klasse Knut definiert
		 * ist. Knut ist als JPanel eine Darstellungsflaeche, in der die Landschaft
		 * gezeichnet wird.
		 */
		KnutZeichnung myDisplay = new KnutZeichnung();
		jFrame.add(myDisplay);
		jFrame.setVisible(true);
	}
}