package com.themeteam.app.Adapters;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;

import com.themeteam.app.R;
import com.themeteam.app.Server.Hishtalshelut;
import com.themeteam.app.Server.Tachana;
import com.themeteam.app.activities.HishtalshelutActivity;
import com.themeteam.app.activities.MesimotListActivity;

import java.util.ArrayList;

/**
 * Created by huser on 14/02/2017.
 */

public class HishtaleshelutAdapter  extends RecyclerView.Adapter {

    private LayoutInflater layoutInflater;
    static ArrayList<Hishtalshelut> hishtalshelout;


    public HishtaleshelutAdapter(Context context, ArrayList<Hishtalshelut> hishtalsheluts ) {
        HishtaleshelutAdapter.hishtalshelout = hishtalsheluts;
        this.layoutInflater = LayoutInflater.from(context);
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = layoutInflater.inflate(R.layout.row_hishtalshelut, parent, false);
        HishtaleshelutAdapter.HishtaleshelutViewHolder viewHolder = new HishtaleshelutViewHolder(view, new HishtaleshelutAdapter.IHishtaleshelutViewHolderClicks() {
            @Override
            public void onLayoutClick(View clicked, int id) {
//                Context context = clicked.getContext();
//                Intent intent = HishtalshelutActivity.intentFactoy(context, id);
//                context.startActivity(intent);
            }
        });

        return viewHolder;
    }


    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        HishtaleshelutViewHolder viewHolder = (HishtaleshelutViewHolder) holder;
        viewHolder.hishtalshelutMelel.setText(hishtalshelout.get(position).getMelel());
        //viewHolder.text;
    }

    @Override
    public int getItemCount() {
        return hishtalshelout.size();
    }

    public void addItem() {
        hishtalshelout.add(new Hishtalshelut(""));
        notifyDataSetChanged();

    }


    private static class HishtaleshelutViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        EditText hishtalshelutMelel;
        IHishtaleshelutViewHolderClicks listener;
        View clickable;

        HishtaleshelutViewHolder(View v, IHishtaleshelutViewHolderClicks listener) {
            super(v);

            this.listener = listener;
            //this.text = (EditText) v.findViewById(R.id.rhText);
            this.clickable = v.findViewById(R.id.rhClickable);
            this.clickable.setOnClickListener(this);

            this.hishtalshelutMelel = (EditText) v.findViewById(R.id.rhText);
        }


        @Override
        public void onClick(View v) {
            if (v.getId() == R.id.rhClickable) {
//                listener.onLayoutClick(v, hishtalshelout.get(getAdapterPosition()).getTachnaId());
            }
        }

    }

    interface IHishtaleshelutViewHolderClicks {
        void onLayoutClick(View clicked, int id);
    }
}

