package com.juntcompany.godandgod.Main.Friend;


import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.app.ActionBar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.juntcompany.godandgod.Main.MainActivity;
import com.juntcompany.godandgod.MainToolbar.ChatPagerAdapter;
import com.juntcompany.godandgod.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class FriendFragment extends Fragment {


    public FriendFragment() {
        // Required empty public constructor
    }

    TabLayout tabLayout;
    ViewPager pager;
    FriendPagerAdapter pagerAdapter;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_friend, container, false);

        TabLayout tabLayout = (TabLayout)view.findViewById(R.id.tab_layout);
        pager = (ViewPager)view.findViewById(R.id.pager);

        pagerAdapter = new FriendPagerAdapter(getChildFragmentManager());
        pager.setAdapter(pagerAdapter);
        tabLayout.setupWithViewPager(pager);
        tabLayout.removeAllTabs();

        tabLayout.addTab(tabLayout.newTab().setText("친구 요청"));
        tabLayout.addTab(tabLayout.newTab().setText("친구 목록"));

        return view;
    }

    ActionBar actionBar;

    @Override
    public void onResume() {
        super.onResume();
        actionBar = ((MainActivity) getActivity()).getSupportActionBar();

        View view = actionBar.getCustomView();
//        Button btn = (Button)view.findViewById(R.id.buttonChat);
//        btn.setVisibility(View.VISIBLE);


    }

}
