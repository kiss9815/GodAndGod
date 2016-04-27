package com.juntcompany.godandgod.Main;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.juntcompany.godandgod.Main.Friend.FriendFragment;
import com.juntcompany.godandgod.Main.Home.HomeFragment;
import com.juntcompany.godandgod.Main.Live.LiveFragment;
import com.juntcompany.godandgod.Main.Love.LoveFragment;
import com.juntcompany.godandgod.Main.Video.VideoFragment;

/**
 * Created by EOM on 2016-04-19.
 */
public class MainPagerAdapter extends FragmentPagerAdapter { // 안썸

    private static final int TAB_COUNT = 5;

    public MainPagerAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {

        switch (position) {
            case 0:
                return new HomeFragment();

            case 1:
                return new FriendFragment();
            case 2:
                return new LiveFragment();
            case 3:
                return new VideoFragment();

            case 4:
                return new LoveFragment();

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
