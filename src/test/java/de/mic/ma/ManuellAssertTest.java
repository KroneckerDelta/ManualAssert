package de.mic.ma;

import javafx.scene.image.Image;

import org.junit.Test;

import de.mic.ma.snapshot.NavigationOrder;
import de.mic.ma.snapshot.NavigationsTargets;
import de.mic.ma.snapshot.Startpage;

public class ManuellAssertTest {

	@Test
	public void testWithImage() throws Exception {
		Image image = new Image("/Screenshot2.PNG");
		new ManuellAssert().assertTrue(image);
	}

	@Test
	public void testWithNavigation() {
		Startpage startpage = new Startpage(
				"http://localhost:8080/component-showcase");
		NavigationsTargets navTargets = new NavigationsTargets(
				"navigationMenuForm:navPnlSrs:0:j_id23",
				"navigationMenuForm:navPnlSrs:0:tree:n-0:navNodeLink",
				"iceform:icepnltabset:0:Text");
		NavigationOrder navOrder = new NavigationOrder(startpage, navTargets);
		new ManuellAssert().assertTrue(navOrder);
	}
}
