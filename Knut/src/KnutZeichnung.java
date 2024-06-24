import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JPanel;

/**
 * Basis-Panel stellt Grundfunktionen fuer den Aufbau interaktiver Anwendungen
 * zur Verfuegung.
 * 
 * Alle Mausereignisse koennen in einzelnen Methoden verarbeitet werden.
 * 
 * @author Joerg Berdux
 * @author Alexander Wolfgang Mueller
 * @author Berhan Cabuk
 * @author D'Angelo-Jamal Jones
 * @author Sefa Kadir Usullu
 * @version 2.0
 */
public class KnutZeichnung extends JPanel implements MouseListener {
	/**
	 * Deklaration der Elemente die gezeichnet werden
	 */
	Mond moon;
	Baum tree[] = new Baum[5];
	Stern star[] = new Stern[8];

	private static final long serialVersionUID = 1L;

	/**
	 * Initialisierung des Panels und setzen des MouseListerns fuer die Verwendung
	 * von Maus-Ereignissen
	 */
	public KnutZeichnung() {

		/**
		 * registriert Panel als MouseListener, so dass die jeweilige spezialisierte
		 * Methode aufgerufen wird, wenn ein Mausereignis innerhalb des Panels
		 * ausgeloest wird
		 */
		this.addMouseListener(this);
		/**
		 * Initialisierung des Mondes
		 */
		moon = new Mond(500, 50, 80);
		/**
		 * Initialisierung der Baeume
		 */

		tree[0] = new Baum(-75, 100, 10);
		tree[1] = new Baum(-150, 200, 20);
		tree[2] = new Baum(200, 105, 150);
		tree[3] = new Baum(20, 170, 80);
		tree[4] = new Baum(350, 150, 35);
		/**
		 * Initialisierung der Sterne
		 */
		star[0] = new Stern(0, 10);
		star[1] = new Stern(70, 50);
		star[2] = new Stern(300, 70);
		star[3] = new Stern(245, 40);
		star[4] = new Stern(180, 50);
		star[5] = new Stern(400, 60);
		star[6] = new Stern(600, 80);
		star[7] = new Stern(590, 20);
	}

	/**
	 * Zeichnen des Bodens und des Hintergrundes.
	 * 
	 * Umsetzung der Methode
	 *
	 * 
	 * @param g Graphik-Kontext, auf dem die Landschaft gezeichnet wird
	 */
	public void paintComponent(Graphics g) {
		super.paintComponent(g);

		g.setColor(new Color(50, 100, 200));
		g.fillRect(0, 0, getWidth(), getHeight());
		/**
		 * zeichnen der Elemente im JPanel
		 * 
		 * @param getDayTime Abfrage ob Tag oder Nacht
		 */
		if (moon.getDayTime() == true) {
			g.setColor(new Color(8, 148, 191));
			g.fillRect(0, 0, getWidth(), getHeight());

			g.setColor(new Color(29, 173, 39));
			g.fillRect(0, 250, getWidth(), getHeight());
		} else {
			g.setColor(new Color(37, 46, 38));
			g.fillRect(0, 0, getWidth(), getHeight());

			g.setColor(new Color(3, 18, 4));
			g.fillRect(0, 250, getWidth(), getHeight());

			star[0].draw(g);
			star[1].draw(g);
			star[2].draw(g);
			star[3].draw(g);
			star[4].draw(g);
			star[5].draw(g);
			star[6].draw(g);
			star[7].draw(g);
		}
		moon.draw(g);

		tree[0].draw(g);
		tree[1].draw(g);
		tree[2].draw(g);
		tree[3].draw(g);
		tree[4].draw(g);

	}

	/**
	 * Aufloesung der x, y-Position, an der Mausbutton betaetigt wurde.
	 * 
	 * Umsetzung der Methode
	 * 
	 * @see MouseListener#mouseClicked(MouseEvent)
	 * 
	 * @param e Maus-Ereignis, das ausgeloest wurde
	 */
	public void mouseClicked(MouseEvent e) {
		int x, y;

		x = e.getX(); // x-Koordinate, an der Mausereignis stattgefunden hat
		y = e.getY(); // y-Koordinate, an der Mausereignis stattgefunden hat

		// hier sollte dann der Maus-Event entsprechend verarbeitet werden
		moon.switchTime(x, y);
		tree[0].chopDown(x, y);
		tree[1].chopDown(x, y);
		tree[2].chopDown(x, y);
		tree[3].chopDown(x, y);
		tree[4].chopDown(x, y);
		// nach jeder Veraenderung soll der Graphik-Kontext neu gezeichnet werden
		repaint();

	}

	/**
	 * Faengt Mouse-Event ab, ohne ihn weiter zu verarbeiten
	 * 
	 * @see MouseListener#mouseEntered(MouseEvent)
	 */
	public void mouseEntered(MouseEvent e) {
		// diese Methode bleibt einfach leer
	}

	/**
	 * Faengt Mouse-Event ab, ohne ihn weiter zu verarbeiten
	 * 
	 * @see MouseListener#mouseExited(MouseEvent)
	 */
	public void mouseExited(MouseEvent e) {
		// diese Methode bleibt einfach leer
	}

	/**
	 * Faengt Mouse-Event ab, ohne ihn weiter zu verarbeiten
	 * 
	 * @see MouseListener#mousePressed(MouseEvent)
	 */
	public void mousePressed(MouseEvent e) {
		// diese Methode bleibt einfach leer
	}

	/**
	 * Faengt Mouse-Event ab, ohne ihn weiter zu verarbeiten
	 * 
	 * @see MouseListener#mouseReleased(MouseEvent)
	 */
	public void mouseReleased(MouseEvent e) {
		// diese Methode bleibt einfach leer
	}
}