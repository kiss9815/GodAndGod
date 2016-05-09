package com.juntcompany.godandgod.Main;

import android.annotation.TargetApi;
import android.app.Activity;
import android.app.SearchManager;
import android.app.SearchableInfo;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.SearchView;
import android.support.v7.widget.Toolbar;
import android.text.Layout;
import android.util.Log;
import android.view.MenuInflater;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.Toast;

import com.juntcompany.godandgod.Login.LoginActivity;
import com.juntcompany.godandgod.Main.Friend.FriendFragment;
import com.juntcompany.godandgod.Main.Home.HomeFragment;
import com.juntcompany.godandgod.Main.Live.LiveFragment;
import com.juntcompany.godandgod.Main.Love.LoveFragment;
import com.juntcompany.godandgod.Main.Profile.ProfileFragment;
import com.juntcompany.godandgod.Main.Profile.ProfileSettingFragment;
import com.juntcompany.godandgod.Main.Search.SearchActivity;
import com.juntcompany.godandgod.MainToolbar.ChatFragment;
import com.juntcompany.godandgod.Main.Search.SearchFragment;
import com.juntcompany.godandgod.Main.Video.VideoFragment;
import com.juntcompany.godandgod.R;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    Intent intent;
    TabLayout tabLayout;
    ViewPager pager;
    MainPagerAdapter pagerAdapter;
    Fragment f;
    private backpress backPressCloseHandler;
    boolean isEditClicked = false;
    public static boolean loginStatus = false;
    public static boolean logout = false;
    public static int profileNum = 0;
    public SearchView mSearchView;
    public MenuItem searchItem;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final ActionBar actionBar = getSupportActionBar();
        actionBar.setDisplayShowCustomEnabled(true);
        actionBar.setDisplayShowTitleEnabled(false);
//


        View titleView = getLayoutInflater().inflate(R.layout.toolbar_main, null);
        RelativeLayout searchLayout = (RelativeLayout) titleView.findViewById(R.id.searchActivityMove);
        actionBar.setCustomView(titleView);
        searchLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                intent = new Intent(getApplicationContext(), SearchActivity.class);
                startActivity(intent);
                overridePendingTransition(0, 0);
            }
        });

//        final Button btn = (Button) titleView.findViewById(R.id.buttonChat);
//        btn.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                ChatFragment f = new ChatFragment();
//                getSupportFragmentManager()
//                        .beginTransaction()
//                        .replace(R.id.container, f)
//                        .commit();
//            }
//        });
//
//        final EditText editSearch = (EditText) titleView.findViewById(R.id.editSearch);
//
//        editSearch.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                SearchFragment f = new SearchFragment();
//
//                getSupportFragmentManager()
//                        .beginTransaction()
//                        .replace(R.id.container, f)
//                        .addToBackStack("search")
//                        .commit();
//            }
//        });


        tabLayout = (TabLayout) findViewById(R.id.tab_layout);
//        pager = (ViewPager)findViewById(R.id.pager);

//        pagerAdapter = new MainPagerAdapter(getSupportFragmentManager());
//        pager.setAdapter(pagerAdapter);
//        tabLayout.setupWithViewPager(pager);
//        tabLayout.removeAllTabs();

        tabLayout.setBackgroundColor(Color.BLACK);
        tabLayout.addTab(tabLayout.newTab().setIcon(R.drawable.home));
        tabLayout.addTab(tabLayout.newTab().setIcon(R.drawable.friendhome));
        tabLayout.addTab(tabLayout.newTab().setIcon(R.drawable.live));
        tabLayout.addTab(tabLayout.newTab().setIcon(R.drawable.replay));
        tabLayout.addTab(tabLayout.newTab().setIcon(R.drawable.timeline));

        tabLayout.setOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                int position = tab.getPosition();
                Fragment f = new Fragment();
                switch (position) {
                    case 0:
                        f = new HomeFragment();
                        actionBar.setDisplayShowCustomEnabled(true);
                        actionBar.setDisplayShowTitleEnabled(false);
                        break;
                    case 1:
                        f = new FriendFragment();
                        actionBar.setDisplayShowCustomEnabled(true);
                        actionBar.setDisplayShowTitleEnabled(false);
                        break;
                    case 2:
                        f = new LiveFragment();
                        actionBar.setDisplayShowCustomEnabled(true);
                        actionBar.setDisplayShowTitleEnabled(false);
                        break;
                    case 3:
                        f = new VideoFragment();
                        actionBar.setDisplayShowCustomEnabled(true);
                        actionBar.setDisplayShowTitleEnabled(false);
                        break;
                    case 4:
                        f = new LoveFragment();
                        actionBar.setDisplayShowTitleEnabled(true);
                        actionBar.setDisplayShowCustomEnabled(false);
                        actionBar.setTitle("게시물 활동");
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

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        // 메뉴버튼이 처음 눌러졌을 때 실행되는 콜백메서드
        // 메뉴버튼을 눌렀을 때 보여줄 menu 에 대해서 정의
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }


    public void profileOnClick(View v) {
        ProfileFragment f;
        switch (v.getId()) {
            case R.id.myProfile:
                profileNum = 1;
                f = new ProfileFragment();
                getSupportFragmentManager()
                        .beginTransaction()
                        .replace(R.id.container, f)
                        .commit();
                break;
            case R.id.chargeHeart:
                profileNum = 2;
                f = new ProfileFragment();
                getSupportFragmentManager()
                        .beginTransaction()
                        .replace(R.id.container, f)
                        .commit();
                break;
            case R.id.profileSetting:
                profileNum = 3;
                f = new ProfileFragment();
                getSupportFragmentManager()
                        .beginTransaction()
                        .replace(R.id.container, f)
                        .commit();
                break;
            case R.id.loginAction:
                MainActivity.logout = true;
                intent = new Intent(getApplicationContext(), LoginActivity.class);
                startActivity(intent);
                break;
        }

    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        // 메뉴의 항목을 선택(클릭)했을 때 호출되는 콜백메서드
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        Log.d("test", "onOptionsItemSelected - 메뉴항목을 클릭했을 때 호출됨");

        int id = item.getItemId();


        switch (id) {
            case R.id.profile:
                ProfileFragment f = new ProfileFragment();
                getSupportFragmentManager()
                        .beginTransaction()
                        .replace(R.id.container, f)
                        .commit();
                profileNum = 0;
                break;
            case R.id.chatNgroup:
                ChatFragment cf = new ChatFragment();
                getSupportFragmentManager()
                        .beginTransaction()
                        .replace(R.id.container, cf)
                        .commit();
        }
        return super.onOptionsItemSelected(item);
    }


}