package com.themeteam.app.adapters;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.themeteam.app.R;
import com.themeteam.app.activities.ReviewPhotosActivity;
import com.themeteam.app.utils.CapturePhotoUtils;

import java.io.File;
import java.util.ArrayList;

/**
 * Created by Yoav on 03-Jul-16.
 */

public class ViewCasesAdapter extends RecyclerView.Adapter {

    private LayoutInflater layoutInflater;
    private ArrayList<String> allDirNames;
    private Context context;


    public ViewCasesAdapter(Context context) {
        this.allDirNames = new ArrayList<>();
        for (File f : CapturePhotoUtils.getAppStorageDir().listFiles()) {
            this.allDirNames.add(f.getName());
        }

        this.context = context;
        this.layoutInflater = LayoutInflater.from(context);
    }


    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = layoutInflater.inflate(R.layout.view_cases_row, parent, false);
        CasesViewHolder viewHolder = new CasesViewHolder(view, new casesViewHolderClicks() {
            @Override
            public void onLayoutClick(View clicked, int pos) {
                Intent intent = ReviewPhotosActivity.intentFactory(
                        CapturePhotoUtils.getAlbumStorageDirForCase(allDirNames.get(pos)).getPath(),
                        clicked.getContext());

                context.startActivity(intent);
            }
        });

        return viewHolder;
    }


    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        CasesViewHolder viewHolder = (CasesViewHolder) holder;
        viewHolder.dirName.setText(allDirNames.get(position));
    }

    @Override
    public int getItemCount() {
        return allDirNames.size();
    }


    private static class CasesViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        TextView dirName;
        casesViewHolderClicks listener;
        View clickable;

        CasesViewHolder(View v, casesViewHolderClicks listener) {
            super(v);

            this.listener = listener;
            this.clickable = v.findViewById(R.id.vcrLayout);
            this.clickable.setOnClickListener(this);

            this.dirName = (TextView) v.findViewById(R.id.vcrCaseId);
        }


        @Override
        public void onClick(View v) {
            if (v.getId() == R.id.vcrLayout) {
                listener.onLayoutClick(v, getAdapterPosition());
            }
        }

    }

    interface casesViewHolderClicks {
        void onLayoutClick(View clicked, int pos);
    }
}
