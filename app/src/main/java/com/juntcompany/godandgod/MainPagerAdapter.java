package com.juntcompany.godandgod;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

/**
 * Created by EOM on 2016-04-19.
 */
public class MainPagerAdapter extends FragmentPagerAdapter {
    public MainPagerAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {
        return TabFragment.newInstance("Item " + position);
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return "tab" + position;
    }

    @Override
    public int getCount() {
        return 10;
    }
}
