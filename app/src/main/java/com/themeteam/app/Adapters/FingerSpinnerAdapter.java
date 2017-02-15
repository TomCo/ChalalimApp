//package com.themeteam.app.adapters;
//
//
//import android.content.Context;
//import android.view.LayoutInflater;
//import android.view.View;
//import android.view.ViewGroup;
//import android.widget.ArrayAdapter;
//import android.widget.ImageView;
//import android.widget.TextView;
//
//import com.squareup.picasso.Picasso;
//import com.themeteam.app.R;
//import com.themeteam.app.utils.GeneralUtils;
//
//import java.io.File;
//
//public class FingerSpinnerAdapter extends ArrayAdapter<String> {
//    private LayoutInflater inflater;
//    private String[] displayNames;
//    private String[] fileNames;
//    private String caseFileUri;
//    //private static final int[] fingerIcons = ;
//
//    public void setCaseFileUri(String caseFileUri) {
//        this.caseFileUri = caseFileUri;
//    }
//
//    public FingerSpinnerAdapter(Context context, int textViewResourceId, String[] objects) {
//        super(context, textViewResourceId, objects);
//        this.inflater = LayoutInflater.from(context);
//        this.displayNames = objects;
//        this.fileNames = context.getResources().getStringArray(R.array.fingerFileNames);
//    }
//
//    @Override
//    public View getDropDownView(int position, View convertView, ViewGroup parent) {
//        return getCustomView(position, convertView, parent);
//    }
//
//    @Override
//    public View getView(int position, View convertView, ViewGroup parent) {
//        return getCustomView(position, convertView, parent);
//    }
//
//    private View getCustomView(final int position, View convertView, ViewGroup parent) {
//        View row = convertView;
//        FingerSpinnerViewHolder holder;
//
//        if (row == null) {
//            row = this.inflater.inflate(R.layout.finger_spinner_row, parent, false);
//
//            holder = new FingerSpinnerViewHolder(row);
//            row.setTag(holder);
//        }
//        else {
//            holder = (FingerSpinnerViewHolder) row.getTag();
//        }
//
//        holder.fingerName.setText(displayNames[position]);
//        if (new File(caseFileUri, fileNames[position]).exists()) {
//            holder.isPictureTakenIcon.setImageResource(R.drawable.ic_check);
//        }
//        else {
//            holder.isPictureTakenIcon.setImageResource(R.drawable.ic_x);
//        }
//
//        Picasso.with(getContext()).load(GeneralUtils.iconResources[position]).resize(150,150).into(holder.fingerIcon);
//
//
//        return row;
//    }
//
//
//    private static class FingerSpinnerViewHolder {
//        ImageView fingerIcon;
//        ImageView isPictureTakenIcon;
//        TextView fingerName;
//
//        FingerSpinnerViewHolder(View v) {
//            this.fingerIcon = (ImageView) v.findViewById(R.id.fsrFingerIcon);
//            this.isPictureTakenIcon = (ImageView) v.findViewById(R.id.fsrIsPhotoTaken);
//            this.fingerName = (TextView) v.findViewById(R.id.fsrFingerName);
//        }
//    }
//}
