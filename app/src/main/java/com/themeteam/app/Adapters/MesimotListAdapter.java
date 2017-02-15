package com.themeteam.app.Adapters;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CompoundButton;
import android.widget.Switch;
import android.widget.TextView;

import com.themeteam.app.R;
import com.themeteam.app.Server.Mesima;
import com.themeteam.app.activities.HishtalshelutActivity;
import com.themeteam.app.activities.MesimotListActivity;

import java.util.ArrayList;

/**
 * Created by huser on 14/02/2017.
 */

public class MesimotListAdapter extends RecyclerView.Adapter {

    private LayoutInflater layoutInflater;
    private static ArrayList<Mesima> mesimot;


    public MesimotListAdapter(Context context, ArrayList<Mesima> mesimot) {
        this.mesimot = mesimot;
        this.layoutInflater = LayoutInflater.from(context);
    }


    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = layoutInflater.inflate(R.layout.row_mesima, parent, false);
        MesimotListAdapter.MesimotViewHolder viewHolder = new MesimotListAdapter.MesimotViewHolder(view, new MesimotListAdapter.IMesimotViewHolderClicks() {
            @Override
            public void onLayoutClick(View clicked, int id) {
                Context context = clicked.getContext();
                Intent intent = HishtalshelutActivity.intentFactoy(context, id);
                context.startActivity(intent);
            }
        });

        return viewHolder;
    }


    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        MesimotViewHolder viewHolder = (MesimotViewHolder) holder;
        viewHolder.stationName.setText(mesimot.get(position).getName());
    }

    @Override
    public int getItemCount() { return mesimot.size(); }


    private static class MesimotViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener, Switch.OnCheckedChangeListener {
        TextView stationName;
        Switch switcher;
        IMesimotViewHolderClicks listener;
        View clickable;

        public MesimotViewHolder(View v, IMesimotViewHolderClicks listener) {
            super(v);

            this.listener = listener;
            this.switcher = (Switch) v.findViewById(R.id.rmSwitch);
            this.clickable = v.findViewById(R.id.rmClickable);
            this.clickable.setOnClickListener(this);

            this.switcher.setOnCheckedChangeListener(this);
            this.stationName = (TextView) v.findViewById(R.id.rmMesimaName);
        }


        @Override
        public void onClick(View v) {
            if (v.getId() == R.id.rmClickable) {
                listener.onLayoutClick(v, mesimot.get(getAdapterPosition()).getMesimaId());
            }
        }

        @Override
        public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
            // ToDo: change isDoneOServerSide
        }
    }

    interface IMesimotViewHolderClicks {
        void onLayoutClick(View clicked, int id);
    }
}
