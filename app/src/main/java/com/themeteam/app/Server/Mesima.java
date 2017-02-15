package com.themeteam.app.Server;

import java.io.File;
import java.sql.Array;
import java.util.ArrayList;
import java.util.List;

public class Mesima {

	private int technaIdThatContainsMe;
	private int mesimaId;
	private String name;
	private List<File> file;
	private List<Hishtalshelut> hishtalshaluiot;
	private Boolean isDone;
	
	Mesima(int mesimaId,int technaIdThatContainsMe, String name){
		this.mesimaId=mesimaId;
		this.technaIdThatContainsMe=technaIdThatContainsMe;
		this.name= name;
		file=new ArrayList<File>();
		hishtalshaluiot=new ArrayList<Hishtalshelut>();
		isDone=false;
	}
	
	public int getTechnaIdThatContainsMe() {
		return technaIdThatContainsMe;
	}

	public void setTechnaIdThatContainsMe(int technaIdThatContainsMe) {
		this.technaIdThatContainsMe = technaIdThatContainsMe;
	}

	public int getMesimaId() {
		return mesimaId;
	}

	public void setMesimaId(int mesimaId) {
		this.mesimaId = mesimaId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<File> getFile() {
		return file;
	}

	public void setFile(List<File> file) {
		this.file = file;
	}

	public List<Hishtalshelut> getHishtalshaluiot() {
		List<Hishtalshelut> hishtalsheluts = new ArrayList<>();
		hishtalsheluts.add(new Hishtalshelut("לא נמצאה טלית במאנח, אריאל יצא לחפש טלית בבני ברק"));
		hishtalsheluts.add(new Hishtalshelut("טלית נמצאה והחלל נעטפה"));
		return hishtalsheluts;
	}

	public void setHishtalshaluiot(List<Hishtalshelut> hishtalshaluiot) {
		this.hishtalshaluiot = hishtalshaluiot;
	}

	public Boolean getIsDone() {
		return isDone;
	}

	public void setIsDone(Boolean isDone) {
		this.isDone = isDone;
	}

	
	
	
	
}
