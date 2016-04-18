package com.juntcompany.godandgod;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    TabLayout tabLayout;
    ViewPager pager;
    MainPagerAdapter pagerAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        ActionBar actionBar =  getSupportActionBar();
        actionBar.setDisplayShowCustomEnabled(true);
        actionBar.setDisplayShowTitleEnabled(false);

        View TitleView = getLayoutInflater().inflate(R.layout.toolbar_main, null);


        actionBar.setCustomView(TitleView);

        tabLayout = (TabLayout)findViewById(R.id.tab_layout);
        pager = (ViewPager)findViewById(R.id.pager);

        pagerAdapter = new MainPagerAdapter(getSupportFragmentManager());
        pager.setAdapter(pagerAdapter);
        tabLayout.setupWithViewPager(pager);
        tabLayout.removeAllTabs();


        tabLayout.addTab(tabLayout.newTab().setText("첫번째"));
        tabLayout.addTab(tabLayout.newTab().setText("두번째"));
        tabLayout.addTab(tabLayout.newTab().setText("세번째"));
        tabLayout.addTab(tabLayout.newTab().setText("네번째"));
        tabLayout.addTab(tabLayout.newTab().setText("다섯번째"));

        tabLayout.setOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                TabFragment tf = TabFragment.newInstance(tab.getText().toString());
                getSupportFragmentManager().beginTransaction().replace(R.id.container, tf)
                        .commit();

            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });
        TabFragment tf = TabFragment.newInstance("tab0");
        getSupportFragmentManager().beginTransaction()
                .replace(R.id.container, tf)
                .commit();

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
