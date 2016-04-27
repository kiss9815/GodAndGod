package com.juntcompany.godandgod.MainToolbar;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.juntcompany.godandgod.Main.Home.HomeFragment;

/**
 * Created by EOM on 2016-04-25.
 */
public class ChatPagerAdapter extends FragmentPagerAdapter {

    private static final int TAB_COUNT = 2;

    public ChatPagerAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {

        switch (position) {
            case 0:
                return new ChatMessageFragment();

            case 1:
                return new ChatGroupFragment();

            default:
                return new HomeFragment(); // 걸릴일 없음
        }
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return "tab" + position;
    }

    @Override
    public int getCount() {
        return TAB_COUNT;
    }

}

