package com.themeteam.app.Server;

import java.util.ArrayList;
import java.util.List;

public class DBrepository {
static List<Chalal> chalalim = new ArrayList<>();
static List<Tachana> tachnaot = new ArrayList<>();
static List<Mesima> mesimot = new ArrayList<>();
static List<Hishtalshelut> Hishtalshelut = new ArrayList<>();

static{
	int mesimaId= 123;
	int tachnaId= 456;
	int chalalId= 789;
	int hishtalshelutId=9876;
	String melel = "blah1 blah1 blah1";
	
	
//	Hishtalshelut hish = new Hishtalshelut(mesimaId,hishtalshelutId);
	
//	hish.setMelel(melel);
//	Hishtalshelut.add(hish);
//
//	Mesima mesima = new Mesima(mesimaId,tachnaId);
//	mesima.setName(melel);
//	mesima.setHishtalshaluiot(Hishtalshelut);
//	mesimot.add(mesima);
//
//	Tachana tachna=  new Tachana(tachnaId);
//	tachna.addMesima(mesima);
//	tachnaot.add(tachna);

	Chalal deadGuy = new Chalal(chalalId);
	deadGuy.addTechnotMockup(tachnaot);
	chalalim.add(deadGuy);

}

}
