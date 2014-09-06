package de.mic.picturevaluation.view;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import de.mic.ma.AssertResult;

public class PictureValuationViewController {

	@FXML
	private ResourceBundle resources;

	@FXML
	private URL location;

	@FXML
	private Button acceptButton;

	@FXML
	private ImageView imageViewId;

	@FXML
	private Button notAcceptedButton;

	@FXML
	private AnchorPane pictureViewerPanel;

	@FXML
	private TextArea resultTextId;

	private AssertResult assertResult = new AssertResult();

	private Stage stage;

	@FXML
	void acceptButtonOnMouseReleased(MouseEvent event) {
		assertResult.accept();
		closeApplication();

	}

	private void closeApplication() {
		try {
			PictureValuationView.instance().stop();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Platform.exit();
	}

	@FXML
	void notAcceptButtonOnMouseReleased(MouseEvent event) {
		assertResult.notAccept();
		closeApplication();
	}

	@FXML
	void initialize() {
		assert acceptButton != null : "fx:id=\"acceptButton\" was not injected: check your FXML file 'PictureSelector.fxml'.";
		assert imageViewId != null : "fx:id=\"imageViewId\" was not injected: check your FXML file 'PictureSelector.fxml'.";
		assert notAcceptedButton != null : "fx:id=\"notAcceptedButton\" was not injected: check your FXML file 'PictureSelector.fxml'.";
		assert pictureViewerPanel != null : "fx:id=\"pictureViewerId\" was not injected: check your FXML file 'PictureSelector.fxml'.";
		assert resultTextId != null : "fx:id=\"resultTextId\" was not injected: check your FXML file 'PictureSelector.fxml'.";

	}

	public void setImage(Image image) {

		System.out.println("image");
		setSize(image);
		imageViewId.setImage(image);
		System.out.println("view: " + imageViewId.getFitHeight());
		System.out.println("view: " + imageViewId.getFitWidth());
		setSize(imageViewId.getImage());
	}

	private void setSize(Image image) {

		System.out.println("pic w 0: " + pictureViewerPanel.getPrefWidth());

		System.out.println("Höhe" + image.getHeight());
		System.out.println("Breite" + image.getWidth());

		imageViewId.setFitHeight(image.getHeight());
		imageViewId.setFitWidth(image.getWidth());

		System.out.println("pic w 1: " + pictureViewerPanel.getPrefWidth());

		pictureViewerPanel.setMaxHeight(image.getHeight());
		pictureViewerPanel.setMinWidth(image.getWidth());
		System.out.println("pic w 2: " + pictureViewerPanel.getPrefWidth());
		pictureViewerPanel.setPrefHeight(image.getHeight());
		pictureViewerPanel.setPrefWidth(image.getWidth());
		System.out.println("pic w 3: " + pictureViewerPanel.getPrefWidth());

		stage.setResizable(true);
		// stage.setFullScreen(true);
		stage.setMaxWidth(image.getWidth());
		stage.setMaxHeight(image.getHeight());
		stage.setWidth(image.getWidth());
		stage.setHeight(image.getHeight());
	}

	public Image getImage() {
		return imageViewId.getImage();
	}

	public boolean getResult() {
		return assertResult.get();
	}

	public String getResultText() {
		return this.resultTextId.getText();
	}

	public void setStage(Stage stage) {
		this.stage = stage;

	}

}
