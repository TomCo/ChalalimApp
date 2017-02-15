package com.themeteam.app.Server;

import java.util.ArrayList;
import java.util.List;

public class DB implements IApi {
	List<Chalal> chalalim;
	List<Tachana> tachnaot;
	List<Mesima> mesimot;

	DB(){
		chalalim = new ArrayList<>();
		tachnaot = new ArrayList<>();
		mesimot = new ArrayList<>();
	}
	

    public void insertNewTachana (Tachana tachana){
    	tachnaot.add(tachana);
    }

	@Override
	public Chalal getChalal(int chalalId) {
		return null;
	}

	@Override
	public void createNewMesimaForTachana(Mesima mesima, int tachanaId) {

	}

	@Override
	public void deleteTachana(int tachanaId) {

	}

	@Override
	public void deleteMesima(int mesimaId) {

	}

	@Override
	public void createChalal(int chalalId) {

	}

	@Override
	public void AddDetailsToMesima(int tachanaId, int chalalId, Mesima mesimaId) {

	}

	@Override
	public User getUserByMisparIshi(String misparIshi) {
		return null;
	}

	@Override
	public List<Tachana> getAllTachanot() {
		return null;
	}

	@Override
	public List<Tachana> getAllTachanotByChalal(int chalalId) {
		return null;
	}

	@Override
	public List<Mesima> getAllMesimotByTachana(int tachanaId) {
		return null;
	}

	@Override
	public List<Mesima> getAllMesimotByTachanaAndChalal(int tachanaId, int chalalId) {
		return null;
	}

	@Override
	public Mesima getMesima(int tachanaId, int chalalId, int mesimaId) {
		return null;
	}

	@Override
	public List<Hishtalshelut> getAllHeshtalsheloyot(int tachanaId, int chalalId, int mesimaId) {
		return null;
	}


}
