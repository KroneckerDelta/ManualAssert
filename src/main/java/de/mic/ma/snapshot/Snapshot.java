package de.mic.ma.snapshot;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

import javafx.scene.image.Image;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

/**
 * Navigates to the navTarget and takes a picture.
 * 
 * @author thomicha
 * 
 */
public class Snapshot {

	NavigationOrder navigation;

	public Snapshot(NavigationOrder navigation) {
		super();
		this.navigation = navigation;
	}

	/**
	 * Navigate to the navTargets, take a picture, close the browser and returns
	 * the picture.
	 * 
	 * @return picture
	 */
	public Image sayCheese() {
		navigation.start();

		File result = takePicture();

		navigation.closeBrowser();

		try {
			return convertToImage(result);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	private File takePicture() {
		WebDriver driver = navigation.getDriver();
		return ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
	}

	public Image convertToImage(File file) throws FileNotFoundException {
		return new Image(new FileInputStream(file));
	}
}
