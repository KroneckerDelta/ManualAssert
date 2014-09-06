package de.mic.ma;

import javafx.scene.image.Image;

import org.junit.Assert;

import de.mic.ma.snapshot.NavigationOrder;
import de.mic.ma.snapshot.Snapshot;
import de.mic.picturevaluation.view.PictureValuationView;

public class ManuellAssert {

	/**
	 * Evaluate one picture.
	 * 
	 * @param image
	 */
	public void assertTrue(Image image) {

		evaluateImage(image);
	}

	private void evaluateImage(Image image) {
		PictureValuationView view = PictureValuationView
				.startApplication(image);

		boolean result = view.getResult();
		String resultText = view.getResultText();
		Assert.assertTrue(resultText, result);
	}

	/*
	 * Navigate to the target and takes an picture to evaluate.
	 */
	public void assertTrue(NavigationOrder navTargets) {
		Snapshot snapshot = new Snapshot(navTargets);
		Image image = snapshot.sayCheese();

		evaluateImage(image);
	}
}
