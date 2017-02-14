package com.themeteam.app.activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.themeteam.app.R;
import com.themeteam.app.adapters.MainPagerAdapter;
import com.themeteam.app.fragments.AddCaseFragment;
import com.themeteam.app.utils.CapturePhotoUtils;

public class MainActivity extends BaseActivity {

    private TextView txtId;
    private ImageView image;

    //region Base
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    void init() {
        super.initToolbar();
        txtId = (EditText) findViewById(R.id.cmIdentifier);
        image = (ImageView) findViewById(R.id.cmImage);
        initPager();
    }

    private void initPager() {
        ViewPager viewPager = (ViewPager) findViewById(R.id.amPager);
        viewPager.setAdapter(new MainPagerAdapter(getSupportFragmentManager(), this));
        TabLayout tabLayout = (TabLayout) findViewById(R.id.amTabLayout);
        tabLayout.setupWithViewPager(viewPager);
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
            getAddCaseFragment().next();
        }

        return super.onOptionsItemSelected(item);
    }
    //endregion

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        getAddCaseFragment().onActivityResult(requestCode, resultCode, data);

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        CapturePhotoUtils.deleteTempImg();
    }

    private AddCaseFragment getAddCaseFragment() {
        for (Fragment fragment : getSupportFragmentManager().getFragments()) {
            if (fragment != null && fragment.getClass() == AddCaseFragment.class) {
                return (AddCaseFragment) fragment;
            }
        }

        return null;
    }
}

