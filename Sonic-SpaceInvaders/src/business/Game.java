package business;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.stream.IntStream;


import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.scene.Cursor;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.TextAlignment;
import javafx.stage.Stage;
import javafx.util.Duration;

public class Game extends Application {

	// AudioClips
//	private AudioClip blast = new AudioClip("file:blast.wav");
//	private AudioClip explosion = new AudioClip("file:explosion.wav");
//	private AudioClip ost = new AudioClip("file:undefeatable.mp3");
//	private AudioClip gameOverSound = new AudioClip("file:gameover.wav");

	// Variables
	private static final Random RAND = new Random();
	private static final int WIDTH = 800;
	private static final int HEIGHT = 600;
	private static final int PLAYER_SIZE = 70;

	static final Image PLAYER_IMG = new Image("file:player/sonic.png");
	static final Image PLAYER_ICON_IMG = new Image("file:player/icon.png");

	static final Image BOMBS_IMG[] = {

			new Image("file:enemies/missiles1.png"), new Image("file:enemies/spikefish.png"),
			new Image("file:enemies/buzzbomber.png"), new Image("file:enemies/sharknik.png")

	};

	final int MAX_BOMBS = 10, MAX_SHOTS = MAX_BOMBS * 3;
	boolean gameOver = false;
	private GraphicsContext gc;

	Player player;
	List<Shot> shots;
	List<Universe> univ;
	List<Enemy> Bombs;

	private double mouseY;
	private int score;
	
	//Constructor
	public Game() {
		this.setScore(score);
		this.setGc(gc);
	}
	
	
	public GraphicsContext getGc() {
		return gc;
	}


	public void setGc(GraphicsContext gc) {
		this.gc = gc;
	}


	public int getScore() {
		return score;
	}


	public void setScore(int score) {
		this.score = score;
	}


	// setup the game
	public void setup() {
		univ = new ArrayList<>();
		shots = new ArrayList<>();
		Bombs = new ArrayList<>();
		player = new Player(20, HEIGHT - PLAYER_SIZE, PLAYER_SIZE, PLAYER_IMG); // geändert
		setScore(0);
		IntStream.range(0, MAX_BOMBS).mapToObj(i -> this.newBomb()).forEach(Bombs::add);
	}

	// start
	public void start(Stage stage) throws Exception {
		Canvas canvas = new Canvas(WIDTH, HEIGHT);
		setGc(canvas.getGraphicsContext2D());
		Timeline timeline = new Timeline(new KeyFrame(Duration.millis(100), e -> run(getGc())));
		timeline.setCycleCount(Timeline.INDEFINITE);
		timeline.play();
		canvas.setCursor(Cursor.MOVE);
		canvas.setOnMouseMoved(e -> mouseY = e.getY()); // geändert
		canvas.setOnMouseClicked(e -> {
			if (shots.size() < MAX_SHOTS)
				shots.add(player.shoot());
			if (gameOver) {
				gameOver = false;
				setup();
			}
		});

		setup();
//		ost.play();
		stage.setScene(new Scene(new StackPane(canvas)));
		stage.setTitle("Sonic's Last Resort");
		stage.show();

	}
	
	// run Graphics
	private void run(GraphicsContext gc) {
		gc.setFill(Color.grayRgb(20));
		gc.fillRect(0, 0, WIDTH, HEIGHT);
		gc.setTextAlign(TextAlignment.CENTER);
		gc.setFont(Font.font(20));
		gc.setFill(Color.WHITE);
		gc.fillText("Score: " + getScore(), WIDTH / 2, 30);

		if (gameOver) {
			gc.setFont(Font.font(35));
			gc.setFill(Color.TEAL);
			gc.fillText("Game Over \n Your Score is: " + getScore() + " \n Click to play again", WIDTH / 2, HEIGHT / 2.5);
			// return;
		}
		univ.forEach(Universe::draw);

		player.update();
		player.draw();
		player.posY = (int) mouseY; // geändert

		Bombs.stream().peek(Player::update).peek(Player::draw).forEach(e -> {
			if (player.colide(e) && !player.exploding) {
				player.explode();
			}
		});

		for (int i = shots.size() - 1; i >= 0; i--) {
			Shot shot = shots.get(i);
			if (shot.posX < 0 || shot.toRemove) { // geändert
				shots.remove(i);
				continue;
			}
			shot.update();
			shot.draw();
			for (Enemy bomb : Bombs) {
				if (shot.colide(bomb) && !bomb.exploding) {
					setScore(getScore() + 1);
					bomb.explode();
//					explosion.play();
					shot.toRemove = true;
				}
			}
		}

		for (int i = Bombs.size() - 1; i >= 0; i--) {
			if (Bombs.get(i).destroyed) {
				Bombs.set(i, newBomb());
			}
		}

		gameOver = player.destroyed;

		if (RAND.nextInt(10) > 2) {
			univ.add(new Universe());
		}
		for (int i = 0; i < univ.size(); i++) {
			if (univ.get(i).posY > HEIGHT)
				univ.remove(i);
		}
	}
	
	Enemy newBomb() {
		return new Enemy(800, 50 + RAND.nextInt(HEIGHT - 100), PLAYER_SIZE, BOMBS_IMG[RAND.nextInt(BOMBS_IMG.length)]);
	}

}
