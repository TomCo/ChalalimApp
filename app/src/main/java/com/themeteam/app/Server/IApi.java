package com.themeteam.app.Server;

import java.util.List;

/**
 * Created by huser on 14/02/2017.
 */
public interface IApi {
	//Akiva has done
	
	
    void insertNewTachana(Tachana tachana);
    Chalal getChalal (int chalalId);
    void createNewMesimaForTachana(Mesima mesima, int tachanaId);
    void deleteTachana(int tachanaId);
    void deleteMesima(int mesimaId);
    void createChalal(int chalalId);
    void AddDetailsToMesima(int tachanaId, int chalalId, Mesima mesimaId);

    User getUserByMisparIshi(String misparIshi);
    List<Tachana> getAllTachanot();
    List<Tachana> getAllTachanotByChalal(int chalalId);
    List<Mesima> getAllMesimotByTachana(int tachanaId);
    List<Mesima> getAllMesimotByTachanaAndChalal(int tachanaId, int chalalId);
    Mesima getMesima(int tachanaId, int chalalId, int mesimaId);
    List<Hishtalshelut> getAllHeshtalsheloyot(int tachanaId, int chalalId, int mesimaId);
}