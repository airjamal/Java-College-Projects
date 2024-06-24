
import java.awt.Graphics;
import java.awt.Color;

/**
 * Stern Element welches dann im JPanel gezeichnet werden soll
 * 
 * @author Alexander Wolfgang Mueller
 * @author Berhan Cabuk
 * @author D'Angelo-Jamal Jones
 * @author Sefa Kadir Usullu
 * @version 2.0
 */
public class Stern {
	private int x;
	private int y;

	/**
	 * Constructor für die Sterne
	 * 
	 * @param x x-Koordinate
	 * @param y y-Koordinate
	 */
	public Stern(int x, int y) {
		this.x = x;
		this.y = y;
	}

	/**
	 * Verhältnisse der Sterne, die der Zeichnung mitgegeben werden
	 * 
	 * @param g Graphik-Kontext, auf dem die Landschaft gezeichnet wird
	 */
	public void draw(Graphics g) {
		int anzahlPunkte = 10;

		int xKoordinaten[] = { x + 5, x + 12, x + 0, x + 18, x + 26, x + 29, x + 47, x + 32, x + 34, x + 21 };
		int yKoordinaten[] = { y + 4, y + 20, y + 33, y + 31, y + 47, y + 29, y + 26, y + 17, y + 0, y + 11 };

		g.setColor(new Color(255, 215, 0));
		g.fillPolygon(xKoordinaten, yKoordinaten, anzahlPunkte);
	}
}
