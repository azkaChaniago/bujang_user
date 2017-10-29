package com.example.azka.practiceapp;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

/**
 * Created by azka on 25/09/17.
 */

public class ViewPagerAdapter extends FragmentStatePagerAdapter {

    int mNumOfTabs;

    public ViewPagerAdapter(FragmentManager fm, int NumOfTabs) {
        super(fm);
        this.mNumOfTabs = NumOfTabs;
    }

    @Override
    public Fragment getItem(int position) {
        switch (position) {
            case 0:
                FragmentOne tab1 = new FragmentOne();
                return tab1;
            case 1:
                FragmentTwo tab2 = new FragmentTwo();
                return tab2;
            case 2:
                FragmentThree tab3 = new FragmentThree();
                return tab3;
            default:
                return null;
        }
    }

    @Override
    public int getCount() {
        return mNumOfTabs;
    }

}
