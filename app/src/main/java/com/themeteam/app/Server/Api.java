package com.themeteam.app.Server;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by huser on 14/02/2017.
 */

public class Api implements IApi {

    private static Api api;

    public static Api getInstance() {
        if (api == null) {
            api = new Api();
        }
        return api;
    }

    @Override
    public void insertNewTachana(Tachana tachana) {

    }

    @Override
    public Chalal getChalal(int chalalId) {
        List<Tachana> t= new ArrayList<>();
        String [] tachnotNames = new String[]{"תחנת קליטת חלל","טביעות אצבע","תחנת הכנה לקבורה"};
        for (int i=0; i<3; i++){
            Tachana tachana = new Tachana(i, tachnotNames[i]);
            List<Mesima> mesimot = new ArrayList<Mesima>();

            mesimot.add(new Mesima(i,0,"שם משימה"));
            mesimot.add(new Mesima(i,1,"שם משימה"));
            mesimot.add(new Mesima(i,2,"שם משימה"));

            tachana.setMesimot(mesimot);
            t.add(tachana);
        }

        Chalal c = new Chalal(chalalId);
        c.setTachnaot(t);

        return c;
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
        User user = new User();
        return user;
    }

    @Override
    public List<Tachana> getAllTachanot() {
        return null;
    }

    @Override
    public List<Tachana> getAllTachanotByChalal(int chalalId) {
        List<Tachana> t= new ArrayList<>();
//        t.add(new Tachana(0));
//        t.add(new Tachana(1));
//        t.add(new Tachana(2));
        return t;
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
