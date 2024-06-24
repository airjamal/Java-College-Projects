import java.awt.Color;
import java.awt.Graphics;

/**
 * Baum Element welches dann im JPanel gezeichnet werden soll
 * 
 * @author Alexander Wolfgang Mueller
 * @author Berhan Cabuk
 * @author D'Angelo-Jamal Jones
 * @author Sefa Kadir Usullu
 * @version 2.0
 */
public class Baum {
	private int x;
	private int y;
	private int rabatt;
	private boolean gefaelltes = false;
	private int discountUntergrenze = 5;
	private int discountObergrenze = 26;

	/**
	 * Constructor für den Baum
	 * 
	 * @param x x-Koordinate
	 * @param y y-Koordinate 
	 * @param discount Rabattwert der dann nach dem fällen angezeigt wird
	 */
	public Baum(int x, int y, int discount) {
		this.x = x;
		this.y = y;
		rabatt = (int) (Math.random() * discountObergrenze + discountUntergrenze);
	}

	/**
	 * Methode mit der man die Bäume anklicken kann, um ihre zustände zu ändern
	 * 
	 * @param x x-Koordinate des Mauszeigers
	 * @param y y-Koordinate des Mauszeigers
	 * @return gefaelltes Wert der den Zustand der Bäume bestimmt
	 */
	public boolean chopDown(int x, int y) {
		if (x >= this.x + 245 && x <= this.x + 255 && y >= this.y + 200 && y <= this.y + 25 + 225) {
			if (gefaelltes == true) {
				gefaelltes = false;
			} else {
				gefaelltes = true;
			}
		}
		return gefaelltes;
	}

	/**
	 * Verhältnisse der Bäume, die der Zeichnung mitgegeben werden Abfrage ob der
	 * Baum dann jeweils gefällt ist oder nicht
	 * 
	 * @param g Graphik-Kontext, auf dem die Landschaft gezeichnet wird
	 */
	public void draw(Graphics g) {
		int punkteAnzahl = 7;
		int punkteRectangle = 4;

		if (gefaelltes == false) {
			int xKoordinaten[] = { x + 200, x + 300, x + 275, x + 300, x + 250, x + 200, x + 225 };
			int yKoordinaten[] = { y + 200, y + 200, y + 175, y + 175, y + 100, y + 175, y + 175 };

			g.setColor(new Color(3, 51, 17));
			g.fillPolygon(xKoordinaten, yKoordinaten, punkteAnzahl);

			int xRectangle[] = { x + 245, x + 245, x + 255, x + 255 };
			int yRectangle[] = { y + 200, y + 225, y + 225, y + 200 };

			g.setColor(new Color(87, 53, 14));
			g.fillPolygon(xRectangle, yRectangle, punkteRectangle);
		} else {
			int xKoordinaten[] = { x + 245, x + 245, x + 220, x + 220, x + 145, x + 220, x + 220 };
			int yKoordinaten[] = { y + 230, y + 130, y + 155, y + 130, y + 180, y + 230, y + 205 };

			g.setColor(new Color(3, 51, 17));
			g.fillPolygon(xKoordinaten, yKoordinaten, punkteAnzahl);

			int xRectangle[] = { x + 245, x + 245, x + 255, x + 255 };
			int yRectangle[] = { y + 200, y + 225, y + 225, y + 200 };

			g.setColor(new Color(87, 53, 14));
			g.fillPolygon(xRectangle, yRectangle, punkteRectangle);

			g.setColor(new Color(100, 100, 100));
			g.drawString(rabatt + "%", x + 195, y + 185);
		}
	}

	/**
	 * 
	 * @return getter für den Booleanwert gefaelltes
	 */
	public boolean getGefaelltes() {
		return gefaelltes;
	}
}
