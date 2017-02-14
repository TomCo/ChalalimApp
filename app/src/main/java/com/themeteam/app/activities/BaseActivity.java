package com.themeteam.app.activities;

import android.annotation.TargetApi;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.LayoutRes;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;

import com.themeteam.app.R;

/**
 * Created by Yoav on 15-Jun-16.
 */

public abstract class BaseActivity extends AppCompatActivity {

    protected Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public void setContentView(@LayoutRes int layoutResID) {
        super.setContentView(layoutResID);
        init();
    }

    protected void initToolbar(String title) {
        this.toolbar = (Toolbar) findViewById(R.id.toolbar);
        this.toolbar.setTitle(title);
        setSupportActionBar(this.toolbar);
    }

    protected void initToolbar() {
        this.toolbar = (Toolbar) findViewById(R.id.toolbar);
        this.toolbar.setLogo(R.drawable.ic_fingerprint);
        this.toolbar.setTitle("");
        this.setToolbarElevationToZero();
        setSupportActionBar(this.toolbar);
    }

    @TargetApi(Build.VERSION_CODES.LOLLIPOP)
    private void setToolbarElevationToZero() {
        if (Build.VERSION.SDK_INT >= 21)
            this.toolbar.setElevation(0);
    }


    abstract void init();

}
