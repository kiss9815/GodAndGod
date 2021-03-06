package com.juntcompany.godandgod.Login.SignIn;

import android.app.Activity;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView ;
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
    public static int termsStatue = 0;
    public static int policyStatue = 0;
    public static int birthYear = 1980;
    public static int birthMonth = 1;
    public static int birthDate = 1;
    public static int male = 0;
    public static int female = 0;
    public static String pwInput = null;
    public static String fName = null;
    public static String oName = null;
    public static String phone = null ;
    public static int spnation = 0 ;
    public static String email = null;
    public static int christianStatue = 0;
    public static int catholicStatue = 0;
    public static int buddhismStatue = 0;
    public static int othersReligionStatue = 0;
    public static boolean resultpage = false;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_in);
        signActvity = SignInActivity.this;
        //Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        //setSupportActionBar(toolbar);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        Fragment f = new SignInChooseFragment();//첫번째 프래그먼트를 설정
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
    public void hideActionBar(){
        getSupportActionBar().hide();
    }//숨겨진 액션바를 드러내기 위한 메소드

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        FragmentTransaction ft;
        switch (item.getItemId()) {
            case android.R.id.home:
                switch (fNum) {
                    case 1:
                        getSupportActionBar().hide();
                        SignInChooseFragment choose = new SignInChooseFragment();
                        SignInActivity.fNum = 0;
                        ft = getSupportFragmentManager().beginTransaction();
                        ft.replace(R.id.container, choose);
                        ft.commit();
                        break;
                    case 2:
                        SignInTermsFragment terms = new SignInTermsFragment();
                        SignInActivity.fNum = 1;
                        ft = getSupportFragmentManager().beginTransaction();
                        ft.replace(R.id.container, terms);
                        ft.commit();
                        break;
                    case 3:
                        SignInPolicyFragment policy = new SignInPolicyFragment();
                        SignInActivity.fNum = 2;
                        ft = getSupportFragmentManager().beginTransaction();
                        ft.replace(R.id.container, policy);
                        ft.commit();
                        break;
                    case 4:
                        SignInPhoneFragment phone = new SignInPhoneFragment();
                        SignInActivity.fNum = 3;
                        ft = getSupportFragmentManager().beginTransaction();
                        ft.replace(R.id.container, phone);
                        ft.commit();
                        break;
                    case 5:
                        SignInEmailFragment email = new SignInEmailFragment();
                        SignInActivity.fNum = 4;
                        ft = getSupportFragmentManager().beginTransaction();
                        ft.replace(R.id.container, email);
                        ft.commit();
                        break;
                    case 6:
                        SignInNameFragment name = new SignInNameFragment();
                        SignInActivity.fNum = 5;
                        ft = getSupportFragmentManager().beginTransaction();
                        ft.replace(R.id.container, name);
                        ft.commit();
                        break;
                    case 7:
                        SignInBirthFragment birth = new SignInBirthFragment();
                        SignInActivity.fNum = 6;
                        ft = getSupportFragmentManager().beginTransaction();
                        ft.replace(R.id.container, birth);
                        ft.commit();
                        break;
                    case 8:
                        SignInPasswordFragment pw = new SignInPasswordFragment();
                        SignInActivity.fNum = 7;
                        ft = getSupportFragmentManager().beginTransaction();
                        ft.replace(R.id.container, pw);
                        ft.commit();
                        break;
                    case 9:
                        SignInReligionFragment religion = new SignInReligionFragment();
                        SignInActivity.fNum = 8;
                        ft = getSupportFragmentManager().beginTransaction();
                        ft.replace(R.id.container, religion);
                        ft.commit();
                        break;
                    case 10:
                        SignInGenderFragment result = new SignInGenderFragment();
                        SignInActivity.fNum = 9;
                        ft = getSupportFragmentManager().beginTransaction();
                        ft.replace(R.id.container, result);
                        ft.commit();
                        break;
                    default:
                        Activity sa = SignInActivity.signActvity;
                        sa.finish();
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
                SignInChooseFragment choose = new SignInChooseFragment();
                SignInActivity.fNum = 0;
                ft = getSupportFragmentManager().beginTransaction();
                ft.replace(R.id.container, choose);
                ft.commit();
                break;
            case 2:
                SignInTermsFragment terms = new SignInTermsFragment();
                SignInActivity.fNum = 1;
                ft = getSupportFragmentManager().beginTransaction();
                ft.replace(R.id.container, terms);
                ft.commit();
                break;
            case 3:
                SignInPolicyFragment policy = new SignInPolicyFragment();
                SignInActivity.fNum = 2;
                ft = getSupportFragmentManager().beginTransaction();
                ft.replace(R.id.container, policy);
                ft.commit();
                break;
            case 4:
                SignInPhoneFragment phone = new SignInPhoneFragment();
                SignInActivity.fNum = 3;
                ft = getSupportFragmentManager().beginTransaction();
                ft.replace(R.id.container, phone);
                ft.commit();
                break;
            case 5:
                SignInEmailFragment email = new SignInEmailFragment();
                SignInActivity.fNum = 4;
                ft = getSupportFragmentManager().beginTransaction();
                ft.replace(R.id.container, email);
                ft.commit();
                break;
            case 6:
                SignInNameFragment name = new SignInNameFragment();
                SignInActivity.fNum = 5;
                ft = getSupportFragmentManager().beginTransaction();
                ft.replace(R.id.container, name);
                ft.commit();
                break;
            case 7:
                SignInBirthFragment birth = new SignInBirthFragment();
                SignInActivity.fNum = 6;
                ft = getSupportFragmentManager().beginTransaction();
                ft.replace(R.id.container, birth);
                ft.commit();
                break;
            case 8:
                SignInPasswordFragment pw = new SignInPasswordFragment();
                SignInActivity.fNum = 7;
                ft = getSupportFragmentManager().beginTransaction();
                ft.replace(R.id.container, pw);
                ft.commit();
                break;
            case 9:
                SignInReligionFragment religion = new SignInReligionFragment();
                SignInActivity.fNum = 8;
                ft = getSupportFragmentManager().beginTransaction();
                ft.replace(R.id.container, religion);
                ft.commit();
                break;
            case 10:
                SignInGenderFragment result = new SignInGenderFragment();
                SignInActivity.fNum = 9;
                ft = getSupportFragmentManager().beginTransaction();
                ft.replace(R.id.container, result);
                ft.commit();
                break;
            default:
                Activity sa = SignInActivity.signActvity;
                sa.finish();
                break;
        }
    }
    @Override
    public void onDestroy(){
        super.onDestroy();
        SignInActivity.fNum = 0;
        SignInActivity.termsStatue = 0;
        SignInActivity.policyStatue = 0;
        SignInActivity.birthYear = 1980;
        SignInActivity.birthMonth = 1;
        SignInActivity.birthDate = 1;
        SignInActivity.male = 0;
        SignInActivity.female = 0;
        SignInActivity.pwInput = null;
        SignInActivity.fName = null;
        SignInActivity.oName = null;
        SignInActivity.phone = null ;
        SignInActivity.spnation = 0 ;
        SignInActivity.email = null;
        SignInActivity.christianStatue = 0;
        SignInActivity.catholicStatue = 0;
        SignInActivity.buddhismStatue = 0;
        SignInActivity.othersReligionStatue = 0;
        SignInActivity.resultpage = false;
    }
}

