package com.juntcompany.godandgod.Login.SignIn;

import android.app.Activity;
import android.os.Bundle;
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
    public static Activity signActvity;
    public static int fNum = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_in);
        signActvity = SignInActivity.this;
        //Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        //setSupportActionBar(toolbar);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        ////
//        ActionBar actionBar = getSupportActionBar();
//        actionBar.setDisplayShowTitleEnabled(false);
//        actionBar.setDisplayShowCustomEnabled(true);
//        View view = getLayoutInflater().inflate(R.layout.toolbar_sign_in, null);
//        actionBar.setCustomView(view, new ActionBar.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT, Gravity.CENTER));

        Fragment f = new SignChooseFragment();//첫번째 프래그먼트를 설정
        FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
        ft.replace(R.id.container, f);
        ft.commit();
        getSupportActionBar().hide();
    }

    public void setActionTitle(String Title){
        getSupportActionBar().setTitle(Title);
    }//액션바 타이틀 변경 위한 메소드

    public void showActionBar(){
        getSupportActionBar().show();
    }//숨겨진 액션바를 드러내기 위한 메소드

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        FragmentTransaction ft;
        switch (item.getItemId()) {
            case android.R.id.home:
                switch (fNum) {
                    case 1:
                        getSupportActionBar().hide();
                        SignChooseFragment choose = new SignChooseFragment();
                        SignInActivity.fNum = 0;
                        ft = getSupportFragmentManager().beginTransaction();
                        ft.replace(R.id.container, choose);
                        ft.commit();
                        break;
                    case 2:
                        SignInPolicyFragment policy = new SignInPolicyFragment();
                        SignInActivity.fNum = 1;
                        ft = getSupportFragmentManager().beginTransaction();
                        ft.replace(R.id.container, policy);
                        ft.commit();
                        break;
                    case 3:
                        SignInPhoneFragment phone = new SignInPhoneFragment();
                        SignInActivity.fNum = 2;
                        ft = getSupportFragmentManager().beginTransaction();
                        ft.replace(R.id.container, phone);
                        ft.commit();
                        break;
                    case 4:
                        SignInEmailFragment email = new SignInEmailFragment();
                        SignInActivity.fNum = 3;
                        ft = getSupportFragmentManager().beginTransaction();
                        ft.replace(R.id.container, email);
                        ft.commit();
                        break;
                    case 5:
                        SignNameFragment name = new SignNameFragment();
                        SignInActivity.fNum = 4;
                        ft = getSupportFragmentManager().beginTransaction();
                        ft.replace(R.id.container, name);
                        ft.commit();
                        break;
                    case 6:
                        SignBirthFragment birth = new SignBirthFragment();
                        SignInActivity.fNum = 5;
                        ft = getSupportFragmentManager().beginTransaction();
                        ft.replace(R.id.container, birth);
                        ft.commit();
                        break;
                    case 7:
                        SignPasswordFragment pw = new SignPasswordFragment();
                        SignInActivity.fNum = 6;
                        ft = getSupportFragmentManager().beginTransaction();
                        ft.replace(R.id.container, pw);
                        ft.commit();
                        break;
                    case 8:
                        SignReligionFragment religion = new SignReligionFragment();
                        SignInActivity.fNum = 7;
                        ft = getSupportFragmentManager().beginTransaction();
                        ft.replace(R.id.container, religion);
                        ft.commit();
                        break;
                    default:
                        SignInActivity.signActvity.finish();
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
                SignChooseFragment choose = new SignChooseFragment();
                SignInActivity.fNum = 0;
                ft = getSupportFragmentManager().beginTransaction();
                ft.replace(R.id.container, choose);
                ft.commit();
                break;
            case 2:
                SignInPolicyFragment policy = new SignInPolicyFragment();
                SignInActivity.fNum = 1;
                ft = getSupportFragmentManager().beginTransaction();
                ft.replace(R.id.container, policy);
                ft.commit();
                break;
            case 3:
                SignInPhoneFragment phone = new SignInPhoneFragment();
                SignInActivity.fNum = 2;
                ft = getSupportFragmentManager().beginTransaction();
                ft.replace(R.id.container, phone);
                ft.commit();
                break;
            case 4:
                SignInEmailFragment email = new SignInEmailFragment();
                SignInActivity.fNum = 3;
                ft = getSupportFragmentManager().beginTransaction();
                ft.replace(R.id.container, email);
                ft.commit();
                break;
            case 5:
                SignNameFragment name = new SignNameFragment();
                SignInActivity.fNum = 4;
                ft = getSupportFragmentManager().beginTransaction();
                ft.replace(R.id.container, name);
                ft.commit();
                break;
            case 6:
                SignBirthFragment birth = new SignBirthFragment();
                SignInActivity.fNum = 5;
                ft = getSupportFragmentManager().beginTransaction();
                ft.replace(R.id.container, birth);
                ft.commit();
                break;
            case 7:
                SignPasswordFragment pw = new SignPasswordFragment();
                SignInActivity.fNum = 6;
                ft = getSupportFragmentManager().beginTransaction();
                ft.replace(R.id.container, pw);
                ft.commit();
                break;
            case 8:
                SignReligionFragment religion = new SignReligionFragment();
                SignInActivity.fNum = 7;
                ft = getSupportFragmentManager().beginTransaction();
                ft.replace(R.id.container, religion);
                ft.commit();
                break;
            default:
                SignInActivity.signActvity.finish();
                break;
        }

    }
}

