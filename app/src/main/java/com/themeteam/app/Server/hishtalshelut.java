package com.themeteam.app.Server;

public class Hishtalshelut {

	private int mesimaIdThatContainsMe;
	private int hishtalshelutId;
	private String melel;

	public Hishtalshelut(String melel){
		this.melel = melel;
	}

	public int getMesimaIdThatContainsMe() {
		return mesimaIdThatContainsMe;
	}

	public void setMesimaIdThatContainsMe(int mesimaIdThatContainsMe) {
		this.mesimaIdThatContainsMe = mesimaIdThatContainsMe;
	}

	public int getHishtalshelutId() {
		return hishtalshelutId;
	}

	public void setHishtalshelutId(int hishtalshelutId) {
		this.hishtalshelutId = hishtalshelutId;
	}

	public String getMelel() {
		return melel;
	}

	public void setMelel(String melel) {
		this.melel = melel;
	}
}
