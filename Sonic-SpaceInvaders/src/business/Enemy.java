package business;

import javafx.scene.image.Image;

public class Enemy extends Player {

	int score;
	private static final int WIDTH = 800;

	int SPEED = (score / 5) + 2;

	public Enemy(int posX, int posY, int size, Image image) {
		super(posX, posY, size, image);
	}

	public void update() {
		super.update();
		if (!exploding && !destroyed)
			posX -= SPEED;
		if (posX > WIDTH)
			destroyed = true;
	}
}
