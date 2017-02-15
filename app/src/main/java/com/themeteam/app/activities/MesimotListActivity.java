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

import com.themeteam.app.Adapters.MesimotListAdapter;
import com.themeteam.app.Adapters.StationListAdapter;
import com.themeteam.app.R;
import com.themeteam.app.Server.Mesima;
import com.themeteam.app.Server.Tachana;
import com.themeteam.app.entities.ClientChalal;

import java.util.ArrayList;

public class MesimotListActivity extends BaseActivity {

    final static String TACHANA_ID_KEY = "tachanaid";

    public static Intent intentFactoy(Context context, int tachanaId) {
        Intent intent = new Intent(context, MesimotListActivity.class);
        intent.putExtra(TACHANA_ID_KEY, tachanaId);
        return intent;
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mesimot_list);
    }

    @Override
    void init() {
        initToolbar("משימות");
        int id = getIntent().getIntExtra(TACHANA_ID_KEY, 0);
        ArrayList<Mesima> mesimot = (ArrayList<Mesima>) ClientChalal.getCurrentChalal().getTachnaot().get(id).getMesimot();

        initRecycleView(mesimot);


        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
    }

    void initRecycleView(ArrayList<Mesima> mesimot) {
        RecyclerView recycler = (RecyclerView) findViewById(R.id.cmlRecycleView);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        recycler.setLayoutManager(linearLayoutManager);

        recycler.setAdapter(new MesimotListAdapter(this, mesimot));
    }

}
