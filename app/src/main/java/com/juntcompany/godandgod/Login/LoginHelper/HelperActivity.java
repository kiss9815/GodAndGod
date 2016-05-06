package com.juntcompany.godandgod.Login.LoginHelper;

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
    public static int fNum = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_help);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        Fragment f = new HelperMainFragment();//첫번째 프래그먼트를 설정
        FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
        ft.replace(R.id.container, f);
        ft.commit();
    }

    public void setActionTitle(String Title){
        getSupportActionBar().setTitle(Title);
    }

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
                        HelperPhoneFindFragment phonefind = new HelperPhoneFindFragment();
                        HelperActivity.fNum = 0;
                        ft = getSupportFragmentManager().beginTransaction();
                        ft.replace(R.id.container, phonefind);
                        ft.commit();
                        break;

                }
                return true;

            default:
                return super.onOptionsItemSelected(item);
        }
    }
}
