package com.juntcompany.godandgod.Login.SignIn;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Gravity;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.juntcompany.godandgod.R;

public class SignInActivity extends AppCompatActivity {
    public static int fNum = 0;//count 대체한 프래그먼트 넘버
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_in);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);


        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
            ////
        ActionBar actionBar = getSupportActionBar();
//        actionBar.setDisplayHomeAsUpEnabled(true);
        actionBar.setDisplayShowTitleEnabled(false);
        actionBar.setDisplayShowCustomEnabled(true);
        View view = getLayoutInflater().inflate(R.layout.toolbar_sign_in, null);
        actionBar.setCustomView(view, new ActionBar.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT, Gravity.CENTER));

        Fragment f = new SignInPolicyFragment();//첫번째 프래그먼트를 설정
        SignInActivity.fNum = -1;//첫 프래그먼트에서 종료하기 위해 설정
        FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
        ft.replace(R.id.container, f);
        ft.commit();


    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        FragmentTransaction ft;
        switch (item.getItemId()) {
            case android.R.id.home:
                switch (fNum) {
                    case -1:
                        finish();
                        break;
                    case 0:
                        SignInPolicyFragment policy = new SignInPolicyFragment();
                        SignInActivity.fNum--;
                        ft = getSupportFragmentManager().beginTransaction();
                        ft.replace(R.id.container, policy);
                        ft.addToBackStack("" + SignInActivity.fNum);
                        ft.commit();
                        break;
                    case 1:
                        SignInPhoneFragment phone = new SignInPhoneFragment();
                        SignInActivity.fNum--;
                        ft = getSupportFragmentManager().beginTransaction();
                        ft.replace(R.id.container, phone);
                        ft.addToBackStack("" + SignInActivity.fNum);
                        ft.commit();
                        break;
                }
                return true;

            default:
                return super.onOptionsItemSelected(item);
        }
    }

}
