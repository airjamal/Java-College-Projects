package business;

import business.Player;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;

public class Player {

	static final int EXPLOSION_W = 128;
	static final int EXPLOSION_ROWS = 3;
	static final int EXPLOSION_COL = 3;
	static final int EXPLOSION_H = 128;
	static final int EXPLOSION_STEPS = 15;

/*	static final int BLASTS_W = 128;
	static final int BLASTS_ROWS = 3;
	static final int BLASTS_COL = 3;
	static final int BLASTS_H = 128;
	static final int BLASTS_STEPS = 15;
*/
	static final Image EXPLOSION_IMG = new Image("file:images/explosion.png");
	static final Image BLASTS_IMG = new Image("file:energyBlast.png");
	
	int posX, posY, size;
	boolean exploding, destroyed;
	Image img;
	int explosionStep = 0;
	
	GraphicsContext gc = gc.getGc();
	

	public Player(int posX, int posY, int size, Image image) {
		this.posX = posX;
		this.posY = posY;
		this.size = size;
		img = image;
		
		
	}

	public Shot shoot() {
		return new Shot(posX + size - Shot.size / 2, posY + size / 3 + Shot.size); // geändert
	}

	public void update() {
		if (exploding)
			explosionStep++;
		destroyed = explosionStep > EXPLOSION_STEPS;
	}

	public void draw() {
		if (exploding) {
			gc.drawImage(EXPLOSION_IMG, explosionStep % EXPLOSION_COL * EXPLOSION_W,
					(explosionStep / EXPLOSION_ROWS) * EXPLOSION_H + 1, EXPLOSION_W, EXPLOSION_H, posX, posY, size,
					size);
		} else {
			gc.drawImage(img, posX, posY, size, size);
		}
	}

	public boolean colide(Player other) {
		int d = distance(this.posX + size / 2, this.posY + size / 2, other.posX + other.size / 2,
				other.posY + other.size / 2);
		return d < other.size / 2 + this.size / 2;
	}

	public void explode() {
		exploding = true;
		explosionStep = -1;
	}

	int distance(int x1, int y1, int x2, int y2) {
		return (int) Math.sqrt(Math.pow((x1 - x2), 2) + Math.pow((y1 - y2), 2));
	}
}
