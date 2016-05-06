package com.juntcompany.godandgod.Login.LoginHelper;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import com.juntcompany.godandgod.Login.SignIn.SignInActivity;
import com.juntcompany.godandgod.Login.LoginHelper.HelperActivity;
import com.juntcompany.godandgod.Login.SignIn.SignInChooseFragment;
import com.juntcompany.godandgod.R;



public class HelperActivity extends AppCompatActivity {
    Intent intent;
    public static Activity helperActvity;
    public static int fNum = 0;

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

    public void setActionTitle(String Title){
        getSupportActionBar().setTitle(Title);
    }

    public void showActionBar(){
        getSupportActionBar().show();
    }//숨겨진 액션바를 드러내기 위한 메소드
    public void hideActionBar(){
        getSupportActionBar().hide();
    }//숨겨진 액션바를 드러내기 위한 메소드


    public void helperclock(View v){

        switch (v.getId()){
            case R.id.searchphone:
                intent = new Intent(getApplicationContext(),HelperPhoneFindFragment.class);
                startActivity(intent);
                break;
        }
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        FragmentTransaction ft ;
        switch (item.getItemId()) {
            case android.R.id.home:
                switch (fNum){
                    case 1 :
                        getSupportActionBar().hide();
                        Activity ss = HelperActivity.helperActvity;
                        ss.finish();
                        break;
                    case 2 :
                        HelperMainFragment main = new HelperMainFragment();
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
                HelperMainFragment main = new HelperMainFragment();
                HelperActivity.fNum = 0;
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
