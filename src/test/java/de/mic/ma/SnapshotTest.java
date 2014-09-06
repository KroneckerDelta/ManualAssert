package de.mic.ma;

import static org.junit.Assert.assertNotNull;
import javafx.scene.image.Image;

import org.junit.Test;

import de.mic.ma.snapshot.NavigationOrder;
import de.mic.ma.snapshot.NavigationsTargets;
import de.mic.ma.snapshot.Snapshot;
import de.mic.ma.snapshot.Startpage;

public class SnapshotTest {

	@Test
	public void takeSnapshottest() throws Exception {

		Snapshot snapshot = new Snapshot(createNavigation());
		Image sayCheese = snapshot.sayCheese();
		assertNotNull(sayCheese);

	}

	private NavigationOrder createNavigation() {
		Startpage startpage = new Startpage(
				"http://localhost:8080/component-showcase/showcase.iface");

		String idDropdownSelectComponentType = "iceform:icepnltabset:0:SlctCompTyp";
		// String idLinkSelection =
		// "navigationMenuForm:navPnlSrs:0:tree:n-2:navNodeLink";
		// String idLinkExtendedComponents =
		// "navigationMenuForm:navPnlSrs:0:j_id23"; // TODO

		NavigationsTargets navTargets = new NavigationsTargets(
				idDropdownSelectComponentType);
		NavigationOrder navigation = new NavigationOrder(startpage, navTargets);
		return navigation;
	}
}
