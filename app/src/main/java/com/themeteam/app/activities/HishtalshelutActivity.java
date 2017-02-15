package com.themeteam.app.activities;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;

import com.themeteam.app.Adapters.HishtaleshelutAdapter;
import com.themeteam.app.Adapters.StationListAdapter;
import com.themeteam.app.R;
import com.themeteam.app.Server.Hishtalshelut;
import com.themeteam.app.Server.Tachana;
import com.themeteam.app.entities.ClientChalal;

import java.util.ArrayList;
import java.util.List;

public class HishtalshelutActivity extends BaseActivity {

    final static String MESIMA_ID_KEY = "mesimaId";
    static ArrayList<Hishtalshelut> hishtalshelutList;
    HishtaleshelutAdapter ad;
    public static Intent intentFactoy(Context context, int mesimaId) {
        Intent intent = new Intent(context, HishtalshelutActivity.class);
        intent.putExtra(MESIMA_ID_KEY, mesimaId);
        return intent;
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hishtalshelut);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ad.addItem();
            }
        });
    }

    @Override
    void init() {
        initToolbar("השתלשלויות");
        initRecycleView();
    }

    void initRecycleView() {
        RecyclerView recycler = (RecyclerView) findViewById(R.id.chRecycleView);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        recycler.setLayoutManager(linearLayoutManager);
        int mesimaId = getIntent().getIntExtra(MESIMA_ID_KEY, 0);
        hishtalshelutList =
                (ArrayList<Hishtalshelut>) ClientChalal.getCurrentChalal().getTachnaot().get(0).getMesimot().get(mesimaId).getHishtalshaluiot();
        ad = new HishtaleshelutAdapter(this, hishtalshelutList);
        recycler.setAdapter(ad);
    }

}
