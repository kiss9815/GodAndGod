package com.juntcompany.godandgod.Login.LoginHelper;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.view.View;

import com.juntcompany.godandgod.R;


public class HelperActivity extends AppCompatActivity {
    public static String phonenumber = null;
    public static String Emailaddr = null;
    public static String codenumber = null;

    public static Activity helperActvity;
    public static int fNum = 0;
    public static int fphone = 0;
    public static int Sms = 0;
    public static int Em = 0;

    public static int helpStatue = 0;//0 = phone, 1= email

    Intent intent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_help);
        helperActvity = HelperActivity.this;

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        Fragment f = new HelperMainFragment(); //첫번째 프래그먼트를 설정
        FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
        ft.replace(R.id.container, f);
        ft.commit();
        //getSupportActionBar().hide();
    }

    public void setActionTitle(String Title) {
        getSupportActionBar().setTitle(Title);
    }

    public void showActionBar() {
        getSupportActionBar().show();
    }//숨겨진 액션바를 드러내기 위한 메소드

    public void hideActionBar() {
        getSupportActionBar().hide();
    }//숨겨진 액션바를 드러내기 위한 메소드


    public void helperclock(View v) {
        FragmentTransaction ft;
        switch (v.getId()) {
            case R.id.searchphone:
                HelperPhoneFindFragment phonedfind = new HelperPhoneFindFragment();
                HelperActivity.fNum = 2;
                ft = getSupportFragmentManager().beginTransaction();
                ft.replace(R.id.container, phonedfind);
                ft.commit();
                break;
            case R.id.serachemail:
                HelperEmailFindFragment emailfind = new HelperEmailFindFragment();
                HelperActivity.fNum = 6;
                ft = getSupportFragmentManager().beginTransaction();
                ft.replace(R.id.container, emailfind);
                ft.commit();
                break;
        }
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        FragmentTransaction ft;
        switch (item.getItemId()) {
            case android.R.id.home:
                switch (fNum) {
                    case 1:
                        getSupportActionBar().hide();
                        Activity ss = HelperActivity.helperActvity;
                        ss.finish();
                        break;
                    case 2:
                        HelperMainFragment main = new HelperMainFragment();
                        HelperActivity.fNum = 1;
                        ft = getSupportFragmentManager().beginTransaction();
                        ft.replace(R.id.container, main);
                        ft.commit();
                        break;
                    case 3:
                        HelperPhoneFindFragment phonefind = new HelperPhoneFindFragment();
                        HelperActivity.fNum = 2;
                        ft = getSupportFragmentManager().beginTransaction();
                        ft.replace(R.id.container, phonefind);
                        ft.commit();
                        break;
                    case 4:
                        HelperEndFragment phoneend = new HelperEndFragment();
                        HelperActivity.fNum = 3;
                        ft = getSupportFragmentManager().beginTransaction();
                        ft.replace(R.id.container, phoneend);
                        ft.commit();
                        break;
                    case 5:
                        HelperCodeInputFragment codein = new HelperCodeInputFragment();
                        HelperActivity.fNum = 4;
                        ft = getSupportFragmentManager().beginTransaction();
                        ft.replace(R.id.container, codein);
                        ft.commit();
                        break;
                    case 6:
                        HelperNewPasswordFragment newpassword = new HelperNewPasswordFragment();
                        HelperActivity.fNum = 5;
                        ft = getSupportFragmentManager().beginTransaction();
                        ft.replace(R.id.container, newpassword);
                        ft.commit();
                        break;
                    case 7:
                        main = new HelperMainFragment();
                        HelperActivity.fNum = 1;
                        ft = getSupportFragmentManager().beginTransaction();
                        ft.replace(R.id.container, main);
                        ft.commit();
                        break;
                }

                return true;

            default:
                return super.onOptionsItemSelected(item);
        }
    }

    @Override
    public void onBackPressed() {
        FragmentTransaction ft;
        switch (fNum) {
            case 1:
                getSupportActionBar().hide();
                Activity ss = HelperActivity.helperActvity;
                ss.finish();
                break;
            case 2:
                HelperMainFragment main = new HelperMainFragment();
                HelperActivity.fNum = 1;
                ft = getSupportFragmentManager().beginTransaction();
                ft.replace(R.id.container, main);
                ft.commit();
                break;
            case 3:
                HelperPhoneFindFragment phonefind = new HelperPhoneFindFragment();
                HelperActivity.fNum = 2;
                ft = getSupportFragmentManager().beginTransaction();
                ft.replace(R.id.container, phonefind);
                ft.commit();
                break;
            case 4:
                HelperEndFragment phoneend = new HelperEndFragment();
                HelperActivity.fNum = 3;
                ft = getSupportFragmentManager().beginTransaction();
                ft.replace(R.id.container, phoneend);
                ft.commit();
                break;
            case 5:
                HelperCodeInputFragment codein = new HelperCodeInputFragment();
                HelperActivity.fNum = 4;
                ft = getSupportFragmentManager().beginTransaction();
                ft.replace(R.id.container, codein);
                ft.commit();
                break;
            case 6:
                HelperNewPasswordFragment newpassword = new HelperNewPasswordFragment();
                HelperActivity.fNum = 5;
                ft = getSupportFragmentManager().beginTransaction();
                ft.replace(R.id.container, newpassword);
                ft.commit();
                break;
            case 7:
                main = new HelperMainFragment();
                HelperActivity.fNum = 1;
                ft = getSupportFragmentManager().beginTransaction();
                ft.replace(R.id.container, main);
                ft.commit();
                break;
            default:
                Activity sa1 = HelperActivity.helperActvity;
                sa1.finish();
                break;

        }
    }
}
