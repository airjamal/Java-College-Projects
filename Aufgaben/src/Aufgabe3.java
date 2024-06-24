import javax.swing.JFrame;
import java.awt.Color;
import java.awt.Graphics;

public class Aufgabe3 extends JFrame {

	public void paint (Graphics g) {
		super.paint(g);
		g.drawString("Hello World", 100, 100);
	}
	public static void main(String[] args) {
		Aufgabe3 app = new Aufgabe3();
		app.setSize(600, 400);
		app.setVisible(true);
	}
}
