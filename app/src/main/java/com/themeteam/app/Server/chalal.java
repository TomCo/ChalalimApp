package com.themeteam.app.Server;

import java.util.ArrayList;
import java.util.List;

public class Chalal {

	private int chalalId;
	private List<Tachana> tachnaot;

	Chalal(int chalalId){
		this.chalalId=chalalId;
		tachnaot=new ArrayList<Tachana>();
		addAllTechanotFromDB();
	}
	
	
	
	private void addAllTechanotFromDB() {
		// TODO Auto-generated method stub
		//
		
	}

	public void addTechnotMockup(List<Tachana> tachnaot){//TODO delete be the end
		this.tachnaot=tachnaot;
		
	}


	public int getChalalId() {
		return chalalId;
	}

	public void setChalalId(int chalalId) {
		this.chalalId = chalalId;
	}

	public List<Tachana> getTachnaot() {
		String [] tachnotNames = new String[]{"תחנת קליטת חלל","טביעות אצבע","תחנת הכנה לקבורה"};
		List<Tachana> t= new ArrayList<>();
		for (int i=0; i<3; i++){
			Tachana tachana = new Tachana(i, tachnotNames[i]);
			List<Mesima> mesimot = new ArrayList<Mesima>();

			mesimot.add(new Mesima(i,0,"עטיפה בטלית"));
			mesimot.add(new Mesima(i,1,"הכנסה לארון"));
			mesimot.add(new Mesima(i,2,"עטיפת הארון בדגל"));

			tachana.setMesimot(mesimot);
			t.add(tachana);
		}


		return t;


	}

	public void setTachnaot(List<Tachana> tachnaot) {
		this.tachnaot = tachnaot;
	}


}
