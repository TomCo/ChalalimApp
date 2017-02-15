package com.themeteam.app.Adapters;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.themeteam.app.R;
import com.themeteam.app.Server.Tachana;
import com.themeteam.app.activities.MesimotListActivity;

import java.util.ArrayList;

/**
 * Created by huser on 14/02/2017.
 */

public class StationListAdapter extends RecyclerView.Adapter {

    private LayoutInflater layoutInflater;
     static ArrayList<Tachana> stations;


    public StationListAdapter(Context context, ArrayList<Tachana> stations ) {
        StationListAdapter.stations = stations;
        this.layoutInflater = LayoutInflater.from(context);
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = layoutInflater.inflate(R.layout.row_station, parent, false);
        StationViewHolder viewHolder = new StationViewHolder(view, new IStationsViewHolderClicks() {
            @Override
            public void onLayoutClick(View clicked, int id) {
                Context context = clicked.getContext();
                Intent intent = MesimotListActivity.intentFactoy(context, id);
                context.startActivity(intent);
            }
        });

        return viewHolder;
    }


    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        StationViewHolder viewHolder = (StationViewHolder) holder;
        viewHolder.stationName.setText(stations.get(position).getTachanaName());
    }

    @Override
    public int getItemCount() {
        return stations.size();
    }


    public static class StationViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        TextView stationName;
        IStationsViewHolderClicks listener;
        View clickable;

        StationViewHolder(View v, IStationsViewHolderClicks listener) {
            super(v);

            this.listener = listener;
            this.clickable = v.findViewById(R.id.rsClickable);
            this.clickable.setOnClickListener(this);

            this.stationName = (TextView) v.findViewById(R.id.rsStationName);
        }


        @Override
        public void onClick(View v) {
            if (v.getId() == R.id.rsClickable) {
                listener.onLayoutClick(v, stations.get(getAdapterPosition()).getTachnaId());
            }
        }

    }

    interface IStationsViewHolderClicks {
        void onLayoutClick(View clicked, int id);
    }
}
