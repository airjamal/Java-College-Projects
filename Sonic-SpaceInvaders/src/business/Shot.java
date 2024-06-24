package business;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

public class Shot {

	public boolean toRemove;
	
	int posX, posY,score , speed = 12;
	static final int size = 6;		
	int blastStep = 0;
	GraphicsContext gc;
	
	public Shot(int posX, int posY) {
		this.posX = posX;
		this.posY = posY;
	}

	public void update() {
		posX += speed;
	}

	public void draw() {
		gc.setFill(Color.LIGHTYELLOW);
		if (score >= 50 && score <= 80 || score >= 120) {
			gc.setFill(Color.BLUEVIOLET);
			speed = 50;
			gc.fillRect(posX - 5, posY + 10, size + 10, size + 30);
		} else {
			speed = 20;
/*			gc.drawImage(BLASTS_IMG, blastStep % BLASTS_COL * BLASTS_W,
					(blastStep / BLASTS_ROWS) * BLASTS_H + 1, BLASTS_W, BLASTS_H, posX, posY, size,
					size);
*/
			gc.fillOval(posX, posY, size + 5, size + 5);
		}
	}

	public boolean colide(Player Rocket) {
		int distance = distance(this.posX + size / 2, this.posY + size / 2, Rocket.posX + Rocket.size / 2,
				Rocket.posY + Rocket.size / 2);
		return distance < Rocket.size / 2 + size / 2;
	}
	
	int distance(int x1, int y1, int x2, int y2) {
		return (int) Math.sqrt(Math.pow((x1 - x2), 2) + Math.pow((y1 - y2), 2));
	}

}
