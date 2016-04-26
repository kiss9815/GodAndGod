package com.juntcompany.godandgod.Main;

import android.app.FragmentTransaction;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.KeyEvent;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.juntcompany.godandgod.Main.Main.Friend.FriendFragment;
import com.juntcompany.godandgod.Main.Main.Home.HomeFragment;
import com.juntcompany.godandgod.Main.Main.Live.LiveFragment;
import com.juntcompany.godandgod.Main.Main.Love.LoveFragment;
import com.juntcompany.godandgod.Main.Main.MainToolbar.ChatFragment;
import com.juntcompany.godandgod.Main.Main.Search.SearchFragment;
import com.juntcompany.godandgod.Main.Main.Video.VideoFragment;
import com.juntcompany.godandgod.R;

public class MainActivity extends AppCompatActivity {

    TabLayout tabLayout;
    ViewPager pager;
    MainPagerAdapter pagerAdapter;
    Fragment f;
    private backpress backPressCloseHandler;
    boolean isEditClicked = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        ActionBar actionBar = getSupportActionBar();
        actionBar.setDisplayShowCustomEnabled(true);
        actionBar.setDisplayShowTitleEnabled(false);

        View titleView = getLayoutInflater().inflate(R.layout.toolbar_main, null);
        final Button btn = (Button) titleView.findViewById(R.id.buttonChat);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ChatFragment f = new ChatFragment();
                getSupportFragmentManager()
                        .beginTransaction()
                        .replace(R.id.container, f)
                        .commit();
            }
        });

        final EditText editSearch = (EditText) titleView.findViewById(R.id.editSearch);

        editSearch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SearchFragment f = new SearchFragment();

                getSupportFragmentManager()
                        .beginTransaction()
                        .replace(R.id.container, f)
                        .addToBackStack("search")
                        .commit();
            }
        });

        actionBar.setCustomView(titleView);

        tabLayout = (TabLayout) findViewById(R.id.tab_layout);
//        pager = (ViewPager)findViewById(R.id.pager);

//        pagerAdapter = new MainPagerAdapter(getSupportFragmentManager());
//        pager.setAdapter(pagerAdapter);
//        tabLayout.setupWithViewPager(pager);
//        tabLayout.removeAllTabs();


        tabLayout.addTab(tabLayout.newTab().setText("첫번째"));
        tabLayout.addTab(tabLayout.newTab().setText("두번째"));
        tabLayout.addTab(tabLayout.newTab().setText("세번째"));
        tabLayout.addTab(tabLayout.newTab().setText("네번째"));
        tabLayout.addTab(tabLayout.newTab().setText("다섯번째"));

        tabLayout.setOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                int position = tab.getPosition();
                Fragment f = new Fragment();
                switch (position) {
                    case 0:
                        f = new HomeFragment();
                        break;
                    case 1:
                        f = new FriendFragment();
                        break;
                    case 2:
                        f = new LiveFragment();
                        break;
                    case 3:
                        f = new VideoFragment();
                        break;
                    case 4:
                        f = new LoveFragment();
                        break;
                }
                getSupportFragmentManager()
                        .beginTransaction()
                        .replace(R.id.container, f)
                        .commit();
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });

        HomeFragment f = new HomeFragment();
        getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.container, f)
                .commit();



        backPressCloseHandler = new backpress(this);
    }
    @Override
    public void onBackPressed() {

        backPressCloseHandler.onBackPressed();

    }



}
