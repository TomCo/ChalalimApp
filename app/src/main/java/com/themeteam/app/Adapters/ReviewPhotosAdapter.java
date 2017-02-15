//package com.themeteam.app.adapters;
//
//import android.content.Context;
//import android.content.Intent;
//import android.support.v7.widget.RecyclerView;
//import android.view.LayoutInflater;
//import android.view.View;
//import android.view.ViewGroup;
//import android.widget.ImageView;
//import android.widget.TextView;
//
//import com.squareup.picasso.MemoryPolicy;
//import com.squareup.picasso.Picasso;
//import com.themeteam.app.R;
//import com.themeteam.app.activities.CropResultActivity;
//import com.themeteam.app.utils.CapturePhotoUtils;
//import com.themeteam.app.utils.GeneralUtils;
//
//import java.io.File;
//import java.io.IOException;
//import java.util.ArrayList;
//
//public class ReviewPhotosAdapter extends RecyclerView.Adapter {
//
//    private ArrayList<String> fingerDisplayNames;
//    private LayoutInflater layoutInflater;
//    private ArrayList<String> allNames;
//    private String casePath;
//    private Context context;
//
//    public ReviewPhotosAdapter(Context context, ArrayList<String> fileNames, String casePath) {
//        this.allNames = fileNames;
//        this.casePath = casePath;
//        this.context = context;
//
//        String[] names = context.getResources().getStringArray(R.array.fingerDisplayNames);
//        fingerDisplayNames = new ArrayList<>();
//        for (String name : this.allNames) {
//            // Take the first letter of each name, which is the finger index
//            this.fingerDisplayNames.add(names[getIndexFromFileName(name)]);
//        }
//
//        this.layoutInflater = LayoutInflater.from(context);
//    }
//
//    @Override
//    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
//        View view = layoutInflater.inflate(R.layout.review_photos_row, parent, false);
//        PhotosViewHolder viewHolder = new PhotosViewHolder(view, new PhotoHolderClicks() {
//            @Override
//            public void onLayoutClick(View clicked, int pos) {
//                Intent intent = null;
//                try {
//                    intent = CropResultActivity.intentFactory(
//                            CapturePhotoUtils.getFileForTitle(casePath, allNames.get(pos)).getPath(),
//                            fingerDisplayNames.get(pos), GeneralUtils.iconResources[getIndexFromFileName(allNames.get(pos))], context);
//
//                } catch (IOException ignore) {
//                }
//                context.startActivity(intent);
//            }
//        });
//        return viewHolder;
//    }
//
//    @Override
//    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
//        PhotosViewHolder photosViewHolder = (PhotosViewHolder) holder;
//        photosViewHolder.title.setText(fingerDisplayNames.get(position));
//        File image = new File(casePath, allNames.get(position));
//        Picasso.with(context).load(image).memoryPolicy(MemoryPolicy.NO_CACHE).into(photosViewHolder.image);
//        Picasso.with(context).load(GeneralUtils.iconResources[getIndexFromFileName(allNames.get(position))])
//                .resize(150, 150).into(photosViewHolder.fingerIcon);
//    }
//
//    @Override
//    public int getItemCount() {
//        return allNames.size();
//    }
//
//
//    private static class PhotosViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
//        public TextView title;
//        public ImageView image;
//        public ImageView fingerIcon;
//        PhotoHolderClicks listener;
//        View clickable;
//
//        PhotosViewHolder(View v, PhotoHolderClicks listener) {
//            super(v);
//
//            this.listener = listener;
//            this.clickable = v.findViewById(R.id.rprLayout);
//            this.title = (TextView) v.findViewById(R.id.rprTitle);
//            this.image = (ImageView) v.findViewById(R.id.rprImage);
//            this.fingerIcon = (ImageView) v.findViewById(R.id.rprIcon);
//            this.clickable.setOnClickListener(this);
//        }
//
//
//        @Override
//        public void onClick(View v) {
//            if (v.getId() == R.id.rprLayout) {
//                listener.onLayoutClick(v, getAdapterPosition());
//            }
//        }
//
//    }
//
//    public interface PhotoHolderClicks {
//        void onLayoutClick(View clicked, int pos);
//    }
//
//    private int getIndexFromFileName(String fileName) {
//        return Integer.parseInt(fileName.substring(0, 1));
//    }
//}