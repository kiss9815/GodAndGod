package com.juntcompany.godandgod.Main;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.Movie;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.view.GestureDetector;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.juntcompany.godandgod.Login.LoginActivity;
import com.juntcompany.godandgod.Login.LoginHelper.HelperActivity;
import com.juntcompany.godandgod.Main.Friend.FriendFragment;
import com.juntcompany.godandgod.Main.Home.HomeFragment;
import com.juntcompany.godandgod.Main.Live.LiveFragment;
import com.juntcompany.godandgod.Main.Love.LoveFragment;
import com.juntcompany.godandgod.Main.Profile.ProfileFragment;
import com.juntcompany.godandgod.Main.Search.SearchActivity;
import com.juntcompany.godandgod.Main.Video.VideoFragment;
import com.juntcompany.godandgod.MainToolbar.ChatFragment;
import com.juntcompany.godandgod.R;

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
    public static Activity mainActivity;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final ActionBar actionBar = getSupportActionBar();
        actionBar.setDisplayShowCustomEnabled(true);
        actionBar.setDisplayShowTitleEnabled(false);
//


        View titleView = getLayoutInflater().inflate(R.layout.toolbar_main, null);
        final RelativeLayout searchLayout = (RelativeLayout) titleView.findViewById(R.id.searchActivityMove);
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
        Button f1 = (Button) findViewById(R.id.function1);
        f1.setVisibility(View.INVISIBLE);


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
            Button f1 = (Button) findViewById(R.id.function1);
            Button f2 = (Button) findViewById(R.id.function2);
            Button f3 = (Button) findViewById(R.id.function3);
            TextView searchTitle = (TextView) findViewById(R.id.searchTitle);

            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                View underLine = (View) findViewById(R.id.underLine);
                int position = tab.getPosition();
                Fragment f = new Fragment();
                switch (position) {
                    case 0:
                        f = new HomeFragment();
                        actionBar.setDisplayShowCustomEnabled(true);
                        actionBar.setDisplayShowTitleEnabled(false);
                        f2.setBackgroundResource(R.drawable.chat);
                        f1.setVisibility(View.INVISIBLE);
                        f2.setVisibility(View.VISIBLE);
                        f3.setVisibility(View.VISIBLE);
                        searchLayout.setVisibility(View.VISIBLE);
                        searchTitle.setText("검색");
                        underLine.setVisibility(View.VISIBLE);
                        break;
                    case 1:
                        f = new FriendFragment();
                        actionBar.setDisplayShowCustomEnabled(true);
                        actionBar.setDisplayShowTitleEnabled(false);
                        f2.setBackgroundResource(R.drawable.chat);
                        f1.setVisibility(View.INVISIBLE);
                        f2.setVisibility(View.VISIBLE);
                        f3.setVisibility(View.VISIBLE);
                        searchLayout.setVisibility(View.VISIBLE);
                        searchTitle.setText("검색");
                        underLine.setVisibility(View.VISIBLE);
                        break;
                    case 2:
                        f = new LiveFragment();
                        actionBar.setDisplayShowCustomEnabled(true);
                        actionBar.setDisplayShowTitleEnabled(false);
                        f2.setBackgroundResource(R.drawable.whitestar);
                        searchTitle.setText("라이브 검색");
                        f1.setBackgroundResource(R.drawable.refresh);
                        f1.setVisibility(View.VISIBLE);
                        f2.setVisibility(View.VISIBLE);
                        f3.setVisibility(View.VISIBLE);
                        searchLayout.setVisibility(View.VISIBLE);
                        underLine.setVisibility(View.VISIBLE);
                        break;
                    case 3:
                        f = new VideoFragment();
                        actionBar.setDisplayShowCustomEnabled(true);
                        actionBar.setDisplayShowTitleEnabled(false);
                        f1.setVisibility(View.INVISIBLE);
                        f2.setVisibility(View.INVISIBLE);
                        f3.setVisibility(View.VISIBLE);
                        searchTitle.setText("동영상 검색");
                        searchLayout.setVisibility(View.VISIBLE);
                        underLine.setVisibility(View.VISIBLE);
                        break;
                    case 4:
                        f = new LoveFragment();
                        actionBar.setDisplayShowTitleEnabled(true);
                        actionBar.setDisplayShowCustomEnabled(true);
                        actionBar.setTitle("게시물 활동");
                        f1.setVisibility(View.INVISIBLE);
                        f2.setVisibility(View.INVISIBLE);
                        f3.setVisibility(View.VISIBLE);
                        searchLayout.setVisibility(View.INVISIBLE);
                        underLine.setVisibility(View.INVISIBLE);
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

    public void ToolbarOnClick(View v) {
        ProfileFragment f;
        switch (v.getId()) {
            case R.id.function1:
                ChatFragment cf = new ChatFragment();
                getSupportFragmentManager()
                        .beginTransaction()
                        .replace(R.id.container, cf)
                        .commit();

                break;
            case R.id.function2:
                cf = new ChatFragment();
                getSupportFragmentManager()
                        .beginTransaction()
                        .replace(R.id.container, cf)
                        .commit();
                break;
            case R.id.function3:
                profileNum = 0;
                f = new ProfileFragment();
                getSupportFragmentManager()
                        .beginTransaction()
                        .replace(R.id.container, f)
                        .commit();
                break;
        }

    }

    public void ProfileSettingClick(View v) {
        switch (v.getId()) {
            case R.id.changePw:
                Intent intent = new Intent(getApplicationContext(), HelperActivity.class);
                startActivity(intent);
                break;
            case R.id.findFriendEmail:
                intent = new Intent(getApplicationContext(), SearchActivity.class);
                startActivity(intent);
                break;
            case R.id.findFriendPhone:
                intent = new Intent(getApplicationContext(), SearchActivity.class);
                startActivity(intent);
                break;
        }

    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        return super.onOptionsItemSelected(item);
    }


    public interface ClickListener {
        void onClick(View view, int position);

        void onLongClick(View view, int position);
    }

    public static class RecyclerTouchListener implements RecyclerView.OnItemTouchListener {

        private GestureDetector gestureDetector;
        private MainActivity.ClickListener clickListener;

        public RecyclerTouchListener(Context context, final RecyclerView recyclerView, final MainActivity.ClickListener clickListener) {
            this.clickListener = clickListener;
            gestureDetector = new GestureDetector(context, new GestureDetector.SimpleOnGestureListener() {
                @Override
                public boolean onSingleTapUp(MotionEvent e) {
                    return true;
                }

                @Override
                public void onLongPress(MotionEvent e) {
//                    View child = recyclerView.findChildViewUnder(e.getX(), e.getY());
//                    if (child != null && clickListener != null) {
//                        clickListener.onLongClick(child, recyclerView.getChildPosition(child));
//                    }
                }
            });
        }

        @Override
        public boolean onInterceptTouchEvent(RecyclerView rv, MotionEvent e) {

            View child = rv.findChildViewUnder(e.getX(), e.getY());
            if (child != null && clickListener != null && gestureDetector.onTouchEvent(e)) {
                clickListener.onClick(child, rv.getChildPosition(child));
            }
            return false;
        }

        @Override
        public void onTouchEvent(RecyclerView rv, MotionEvent e) {
        }


        @Override
        public void onRequestDisallowInterceptTouchEvent(boolean disallowIntercept) {

        }
    }
}