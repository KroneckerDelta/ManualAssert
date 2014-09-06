package de.mic.ma;

import org.junit.Test;

import de.mic.ma.snapshot.NavigationOrder;
import de.mic.ma.snapshot.NavigationsTargets;
import de.mic.ma.snapshot.Startpage;

public class NavigationTest {

	@Test
	public void testTheNavigation() throws Exception {
		Startpage startpage = new Startpage(
				"http://localhost:8080/component-showcase/showcase.iface");

		NavigationsTargets navTargets = new NavigationsTargets(
				"navigationMenuForm:navPnlSrs:0:j_id23",
				"navigationMenuForm:navPnlSrs:0:tree:n-0:navNodeLink",
				"iceform:icepnltabset:0:Text");

		NavigationOrder navigation = new NavigationOrder(startpage, navTargets);
		navigation.start();
	}
}
