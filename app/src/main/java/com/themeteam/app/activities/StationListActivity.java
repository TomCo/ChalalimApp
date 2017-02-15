package com.themeteam.app.activities;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;

import com.themeteam.app.Adapters.StationListAdapter;
import com.themeteam.app.R;
import com.themeteam.app.Server.Api;
import com.themeteam.app.Server.Chalal;
import com.themeteam.app.Server.Tachana;
import com.themeteam.app.entities.ClientChalal;

import java.util.ArrayList;
import java.util.List;

public class StationListActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_station_list);
    }

    @Override
    void init() {
        initToolbar();
        initRecycleView();

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

    }

    void initRecycleView() {
        RecyclerView recycler = (RecyclerView) findViewById(R.id.cslRecycleView);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        recycler.setLayoutManager(linearLayoutManager);

        ArrayList<Tachana> tachanot = (ArrayList<Tachana>) ClientChalal.getCurrentChalal().getTachnaot();

        recycler.setAdapter(new StationListAdapter(this, tachanot));
    }

}
