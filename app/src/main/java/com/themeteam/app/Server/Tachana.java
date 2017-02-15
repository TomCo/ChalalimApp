package com.themeteam.app.Server;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Tachana {
	
	private int tachnaId;

	public String getTachanaName() {
		return this.tachanaName;
	}

	public void setTachanaName(String tachanaName) {
		this.tachanaName = tachanaName;
	}

	private String tachanaName;
	private int numberOfDoneMesimot;
	private List<Mesima> mesimot;
	
	Tachana(int tachnaId, String tachanaName){
		this.tachnaId=tachnaId;
		this.tachanaName = tachanaName;
		numberOfDoneMesimot=0;
		mesimot=new ArrayList<Mesima>();
	}
	
	
	public void addMesima(Mesima m){
		mesimot.add(m);
		
	}
	
	public int getTachnaId() {
		return tachnaId;
	}

	public void setTachnaId(int tachnaId) {
		this.tachnaId = tachnaId;
	}

	public int getNumberOfDoneMesimot() {
		//return numberOfDoneMesimot;
		return new Random().nextInt(3);
	}

	public void setNumberOfDoneMesimot(int numberOfDoneMesimot) {
		this.numberOfDoneMesimot = numberOfDoneMesimot;
	}

	public List<Mesima> getMesimot() {
		return mesimot;
	}

	public void setMesimot(List<Mesima> mesimot) {
		this.mesimot = mesimot;
	}


}
