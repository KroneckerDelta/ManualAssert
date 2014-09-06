package de.mic.ma;

public class AssertResult {

	private Boolean result;

	public void accept() {
		result = Boolean.TRUE;
	}

	public void notAccept() {
		result = Boolean.FALSE;
	}

	public Boolean get() {
		return result;
	}
}
