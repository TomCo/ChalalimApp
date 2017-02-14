package com.themeteam.app.adapters;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.themeteam.app.R;
import com.themeteam.app.fragments.AddCaseFragment;
import com.themeteam.app.fragments.ViewCasesFragment;

/**
 * Created by Yoav on 03-Jul-16.
 */

public class MainPagerAdapter extends FragmentPagerAdapter {

    private final String[] titles;

    public MainPagerAdapter(FragmentManager fm, Context context) {
        super(fm);
        this.titles = context.getResources().getStringArray(R.array.tabTitles);
    }

    @Override
    public Fragment getItem(int position) {
        switch (position) {
            case (0): {
                return ViewCasesFragment.newInstance();
            }
            case (1): {
                return AddCaseFragment.newInstance();
            }
        }

        return null;
    }

    @Override
    public int getCount() {
        return 2;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return titles[position];
    }
}
