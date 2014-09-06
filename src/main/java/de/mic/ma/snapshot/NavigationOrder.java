package de.mic.ma.snapshot;

import org.apache.commons.lang3.Validate;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public final class NavigationOrder {

	protected static WebDriver driver = new FirefoxDriver();
	private Startpage startpage;
	private NavigationsTargets navTargets;

	public NavigationOrder(Startpage startpage, NavigationsTargets navTargets) {
		Validate.notNull(startpage);
		Validate.notNull(navTargets);
		this.startpage = startpage;
		this.navTargets = navTargets;
		setStartpage();
	}

	/**
	 * doesnt work with standard const.
	 */
	@SuppressWarnings("unused")
	private NavigationOrder() {
		// hide
	}

	public void start() {
		gotoPageSelection();
	}

	private void setStartpage() {

		driver.get(startpage.getStartUrl());
	}

	private void gotoPageSelection() {

		String[] pages = navTargets.getNavTargets();
		for (int indexOfElementToCheckPresent = 1; indexOfElementToCheckPresent < pages.length; ++indexOfElementToCheckPresent) {

			String idOfElementToCheckPresent = pages[indexOfElementToCheckPresent];
			if (driver.findElements(By.id(idOfElementToCheckPresent)).size() == 0) {

				int indexOfElementToClick = indexOfElementToCheckPresent - 1;
				WebElement elementToClick = driver.findElement(By
						.id(pages[indexOfElementToClick]));

				elementToClick.click();

				while (driver.findElements(By.id(idOfElementToCheckPresent))
						.size() == 0) {

					try {
						Thread.sleep(500);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
			}
		}
	}

	/**
	 * Closed the browaser.
	 */
	public void closeBrowser() {
		driver.quit();
	}

	/**
	 * isnt for public!
	 * 
	 * @return
	 */
	WebDriver getDriver() {
		return driver;
	}
}
