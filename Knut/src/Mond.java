import java.awt.Graphics;
import java.awt.Color;

/**
 * Mond Element welches dann im JPanel gezeichnet werden soll
 * 
 * @author Alexander Wolfgang Mueller
 * @author Berhan Cabuk
 * @author D'Angelo-Jamal Jones
 * @author Sefa Kadir Usullu
 * @version 2.0
 */
public class Mond {

	private int x;
	private int y;
	private int radius;
	private boolean daytime;
	private Color farbeAn;
	private Color farbeAus;

	/**
	 * 
	 * @return getter für den Booleanwert daytime
	 */
	public boolean getDayTime() {
		return daytime;
	}

	/**
	 * Methode mit der man den Mond anklicken kann, um die Tageszeit zu ändern
	 * 
	 * @param x x-Koordinate des Mauszeigers
	 * @param y y-Koordinate des Mauszeigers
	 * @return daytime Wert der über Tag und Nacht entscheidet
	 */
	public boolean switchTime(int x, int y) {
		if (x <= this.x + radius && x >= this.x && y <= this.y + radius && y >= this.y) {
			if (daytime == true) {
				daytime = false;
			} else {
				daytime = true;
			}
		}
		return daytime;
	}

	/**
	 * 
	 * @param x      x-Koordinate
	 * @param y      y-Koordinate
	 * @param radius Radius des Mondes
	 */
	public Mond(int x, int y, int radius) {
		this.x = x;
		this.y = y;
		this.radius = radius;
		this.daytime = false;
	}

	/**
	 * Verhältnis des Mondes die der Zeichnung mitgegeben werden Abfrage zwischen
	 * Tag- und Nachtzustand
	 * 
	 * @param g Graphik-Kontext, auf dem die Landschaft gezeichnet wird
	 */
	public void draw(Graphics g) {
		g.setColor(farbeAus);
		g.setColor(farbeAn);
		g.drawOval(x, y, radius, radius);
		if (this.daytime == true) {
			this.farbeAus = Color.YELLOW;
			g.setColor(Color.YELLOW);
			g.fillOval(x, y, radius, radius);
		} else {
			this.farbeAn = Color.BLACK;
			g.setColor(Color.BLACK);
			g.fillOval(x, y, radius, radius);
		}
	}
}
