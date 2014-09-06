package de.mic.picturevaluation.view;

import java.net.URL;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.fxml.JavaFXBuilderFactory;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

public class PictureValuationView extends Application {

	private static PictureValuationView instance;
	private static Image image;

	private PictureValuationViewController controller;

	public PictureValuationView() {
		PictureValuationView.instance = this;
	}

	public static PictureValuationView instance() {
		return instance;
	}

	@Override
	public void start(Stage stage) throws Exception {

		// stage.setFullScreen(true);

		FXMLLoader loader = new FXMLLoader();
		URL location = getClass().getResource("/PictureSelector.fxml");
		loader.setLocation(location);
		loader.setBuilderFactory(new JavaFXBuilderFactory());

		Parent root = (Parent) loader.load(location.openStream());

		PictureValuationViewController controller = (PictureValuationViewController) loader
				.getController();
		this.controller = controller;
		controller.setStage(stage);
		controller.setImage(image);

		Scene scene = new Scene(root);

		stage.setTitle("Choose assertion");
		stage.setScene(scene);
		stage.show();
	}

	public static void main(String[] args) {

		launch(args);
	}

	public static PictureValuationView startApplication(Image anImage) {
		image = anImage;
		Application.launch(PictureValuationView.class);
		return instance;

	}

	public boolean getResult() {
		return controller.getResult();
	}

	public String getResultText() {
		return controller.getResultText();
	}
}
