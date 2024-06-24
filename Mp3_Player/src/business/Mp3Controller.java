package business;

import java.io.File;
import java.net.URL;
import java.util.ArrayList;
import java.util.Collections;
import java.util.ResourceBundle;
import java.util.Timer;
import java.util.TimerTask;

import com.mpatric.mp3agic.ID3v1;

import javafx.animation.FadeTransition;
import javafx.application.Platform;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.MapChangeListener;
import javafx.collections.ObservableMap;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
import javafx.scene.control.ProgressBar;
import javafx.scene.control.Slider;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.util.Callback;
import javafx.util.Duration;

public class Mp3Controller implements Initializable {

	@FXML
	private HBox parent;
	@FXML
	private Pane main, sidebar, header;
	@FXML
	private Label nowPlayingLabel, songLabel, songAlbum, songYear, songArtist, mediaLabel, progressLabel;
	@FXML
	private Button playButton, pauseButton, nextButton, previousButton, resetButton, menuButton, exitButton,
			shuffleButton;
	@FXML
	private Slider volumeSlider;
	@FXML
	private ProgressBar songProgressBar;
	@FXML
	private ImageView albumCover;
	@FXML
	private ListView<File> playlistView;

	private Media media;
	private MediaPlayer mediaPlayer;

	private File directory;
	private File[] files;

	private ArrayList<File> songs;
	private int songNumber;

	private Timer timer;

	private boolean running;

	ID3v1 id3v1Tag;

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		// TODO Auto-generated method stub

// Playlist Loader
		sidebar.setVisible(false);
		shuffleButton.setVisible(false);

		songs = new ArrayList<File>();

		directory = new File("music");

		files = directory.listFiles();

		if (files != null) {
			for (File file : files) {
				songs.add(file);
			}
		}

// Media
		media = new Media(songs.get(songNumber).toURI().toString());
		mediaPlayer = new MediaPlayer(media);

		MetaData();

// Volume Control
		volumeSlider.valueProperty().addListener(new ChangeListener<Number>() {

			@Override
			public void changed(ObservableValue<? extends Number> arg0, Number arg1, Number arg2) {

				mediaPlayer.setVolume(volumeSlider.getValue() * 0.01);
			}
		});

// Progress Bar
		songProgressBar.setStyle("-fx-accent: #0000FF;");

// ListView Audio Files
		if (songs != null) {
			for (File songList : songs) {
				playlistView.getItems().add(songList);
			}
		}

// Show abbreviated Mp3 File		
		playlistView.setCellFactory(new Callback<>() {
			public ListCell<File> call(ListView<File> param) {
				return new ListCell<>() {
					@Override
					protected void updateItem(File file, boolean empty) {
						super.updateItem(file, empty);

// Show file name without extension (when item not null and not empty):
						setText(file == null || empty ? null
								: file.getName().substring(0, file.getName().lastIndexOf(".")));
					}
				};
			}
		});

// On Click Event for Selected File
		playlistView.setOnMouseClicked(new EventHandler<MouseEvent>() {

			@Override
			public void handle(MouseEvent arg0) {
				// TODO Auto-generated method stub

				if (!running) {
					media = new Media(playlistView.getSelectionModel().getSelectedItem().toURI().toString());

					mediaPlayer = new MediaPlayer(media);

					MetaData();

				} else {
					reset();

					media = new Media(playlistView.getSelectionModel().getSelectedItem().toURI().toString());

					mediaPlayer = new MediaPlayer(media);

					MetaData();

				}

			}
		});

	}

// Meta Data
	public void MetaData() {

// Meta Daten der Mp3 Dateien
		ObservableMap<String, Object> meta_data = mediaPlayer.getMedia().getMetadata();

		meta_data.addListener(new MapChangeListener<String, Object>() {
			@Override
			public void onChanged(Change<? extends String, ? extends Object> ch) {

				if (ch.wasAdded()) {

					String key = ch.getKey();
					Object value = ch.getValueAdded();

					switch (key) {
					case "artist":
						songArtist.setText(value.toString());
						break;
					case "album":
						songAlbum.setText(value.toString());
						break;
					case "year":
						songYear.setText(value.toString());
						break;
					case "title":
						songLabel.setText(value.toString());
						break;
					}

				}

			}
		});
	}

// MP3 Player Controls
	public void play() {
		beginTimer();
		mediaPlayer.setVolume(volumeSlider.getValue() * 0.01);
		mediaPlayer.play();
	}

	public void pause() {
		cancelTimer();
		mediaPlayer.pause();
	}

	public void reset() {
		cancelTimer();
		songProgressBar.setProgress(0);
		mediaPlayer.seek(Duration.seconds(0));
		mediaPlayer.stop();
	}

	public void previous() {

		if (songNumber > 0) {

			songNumber--;

			mediaPlayer.stop();

			if (running) {
				cancelTimer();
			}

			media = new Media(songs.get(songNumber).toURI().toString());
			mediaPlayer = new MediaPlayer(media);

			MetaData();
			
			play();

		} else {

			songNumber = songs.size() - 1;

			mediaPlayer.stop();

			if (running) {
				cancelTimer();
			}

			media = new Media(songs.get(songNumber).toURI().toString());
			mediaPlayer = new MediaPlayer(media);

			MetaData();
			
			play();

		}
	}

	public void next() {

		if (songNumber < songs.size() - 1) {

			songNumber++;

			mediaPlayer.stop();

			if (running) {
				cancelTimer();
			}

			media = new Media(songs.get(songNumber).toURI().toString());
			mediaPlayer = new MediaPlayer(media);

			MetaData();
			
			mediaPlayer.play();

		} else {

			songNumber = 0;

			mediaPlayer.stop();

			media = new Media(songs.get(songNumber).toURI().toString());
			mediaPlayer = new MediaPlayer(media);

			MetaData();
			
			mediaPlayer.play();

		}
	}

	public void shuffle() {
		Collections.shuffle(songs);
	}

	public void openMenu() {

		if (!sidebar.isVisible()) {

			sidebar.setVisible(true);
			shuffleButton.setVisible(true);

			FadeTransition fade = new FadeTransition();
			fade.setNode(sidebar);
			fade.setDuration(Duration.millis(500));
			fade.setFromValue(0);
			fade.setToValue(1);
			fade.play();

			FadeTransition fade2 = new FadeTransition();
			fade2.setNode(shuffleButton);
			fade2.setDuration(Duration.millis(500));
			fade2.setFromValue(0);
			fade2.setToValue(1);
			fade2.play();
		} else {

			FadeTransition fade = new FadeTransition();
			fade.setNode(sidebar);
			fade.setDuration(Duration.millis(500));
			fade.setFromValue(1);
			fade.setToValue(0);
			fade.play();

			FadeTransition fade2 = new FadeTransition();
			fade2.setNode(shuffleButton);
			fade2.setDuration(Duration.millis(500));
			fade2.setFromValue(0);
			fade2.setToValue(1);
			fade2.play();

			sidebar.setVisible(false);
			shuffleButton.setVisible(false);
		}

	}

	public void exitPlayer() {
		System.exit(0);
	}

// Progress Bar Timer
	public void beginTimer() {

		timer = new Timer();

		double end = media.getDuration().toMinutes();

		end = Math.round(end * 100.0) / 100.0;

		double newEnd = end;
		progressLabel.setText(Double.toString(newEnd));

		timer.scheduleAtFixedRate(new TimerTask() {
			@Override
			public void run() {
				Platform.runLater(() -> {

					running = true;
					double current = mediaPlayer.getCurrentTime().toSeconds();
					double end = media.getDuration().toSeconds();
					songProgressBar.setProgress(current / end);

					if (current / end == 1) {

						cancelTimer();
					}
				});
			}
		}, 1000, 1000);
	}

	public void cancelTimer() {

		running = false;

		timer.cancel();

		timer.purge();
	}

}
