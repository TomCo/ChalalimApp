package com.themeteam.app.activities;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Menu;
import android.view.MenuItem;

import com.themeteam.app.R;
import com.themeteam.app.adapters.ReviewPhotosAdapter;

import java.io.File;
import java.io.FilenameFilter;
import java.util.ArrayList;

public class ReviewPhotosActivity extends BaseActivity {

    private static final String CASE_FILE_KEY = "filekey";

    public static Intent intentFactory(String uri, Context context) {
        Intent intent = new Intent(context, ReviewPhotosActivity.class);
        intent.putExtra(CASE_FILE_KEY, uri);

        return intent;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_review_photos);
    }

    @Override
    void init() {
        super.initToolbar("צפה בתמונות");
        String uri = getIntent().getStringExtra(CASE_FILE_KEY);

        // Get all files except for the full pic
        File[] files = new File(uri).listFiles(new FilenameFilter() {
            @Override
            public boolean accept(File dir, String filename) {
                return !filename.contains("FullPic");
            }
        });

        ArrayList<String> names = new ArrayList<>();

        for (File file : files) {
            names.add(file.getName());
        }

        RecyclerView recycler = (RecyclerView) findViewById(R.id.crpPhotos);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        layoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        recycler.setLayoutManager(layoutManager);

        recycler.setAdapter(new ReviewPhotosAdapter(this, names, uri));

    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id == R.id.mmNext) {
            AlertDialog.Builder builder = new AlertDialog.Builder(this);
            builder.setTitle("האם אתה בטוח שברצונך לשלוח לזיהוי?");
            builder.setNegativeButton("לא", null);
            builder.setPositiveButton("כן", null);
            builder.show();
        }
        return super.onOptionsItemSelected(item);
    }

}
