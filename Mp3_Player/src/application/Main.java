package application;

import java.util.Scanner;

import javafx.application.Application;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.fxml.FXMLLoader;

/**
 * --module-path "C:\Program Files\Java\javafx-sdk-19\lib" --add-modules javafx.controls,javafx.fxml,javafx.media,javafx.web
 * 
 **/

public class Main extends Application {

	String playlist;
	
	public static String selectPlaylist(String playlist) {
		Scanner writable;
		try {
			System.out.println("Name Playlist:\n");
			writable = new Scanner(System.in);

			playlist = writable.toString();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return playlist;

	}

	@Override
	public void start(Stage primaryStage) {
		
		try {
				Parent root = FXMLLoader.load(getClass().getClassLoader().getResource("../bin/view/Scene.fxml"));
				Scene scene = new Scene(root);
				scene.getStylesheets()
						.add(getClass().getClassLoader().getResource("../bin/view/application.css").toExternalForm());
				primaryStage.setScene(scene);
				primaryStage.initStyle(StageStyle.UNDECORATED);
				primaryStage.show();
		
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		launch(args);
	}
}
