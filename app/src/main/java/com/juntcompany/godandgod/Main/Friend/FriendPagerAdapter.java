package com.juntcompany.godandgod.Main.Friend;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.juntcompany.godandgod.Main.Friend.FriendList.FriendListFragment;
import com.juntcompany.godandgod.Main.Friend.FriendRequest.FriendRequestFragment;
import com.juntcompany.godandgod.Main.Home.HomeFragment;

/**
 * Created by Jiseong on 2016-05-12.
 */
public class FriendPagerAdapter extends FragmentPagerAdapter {

    private static final int TAB_COUNT = 2;

    public FriendPagerAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {



        switch (position) {
            case 0:
                return new FriendRequestFragment();

            case 1:
                return new FriendListFragment();

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

