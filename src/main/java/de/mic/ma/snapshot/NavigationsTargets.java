package de.mic.ma.snapshot;

/**
 * This class holds the nav targets, after starturl.
 * 
 * @author thomicha
 * 
 */
public class NavigationsTargets {

	String[] targets;

	/**
	 * Gets every url/link or whatever to click and navigate. Be care of the
	 * order!
	 * 
	 * @param targets
	 */
	public NavigationsTargets(String... targets) {
		super();
		this.targets = targets;
	}

	public String[] getNavTargets() {
		// TODO Auto-generated method stub
		return targets;
	}
}
