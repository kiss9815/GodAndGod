package com.juntcompany.godandgod.Main.Profile;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.NumberPicker;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;
import android.widget.Toast;

import com.juntcompany.godandgod.Login.LoginHelper.HelperActivity;
import com.juntcompany.godandgod.Login.SignIn.SignInActivity;
import com.juntcompany.godandgod.Login.SignIn.SignInFinalFragment;
import com.juntcompany.godandgod.Login.SignIn.SignInPasswordFragment;
import com.juntcompany.godandgod.Main.MainActivity;
import com.juntcompany.godandgod.Main.Search.SearchFragment;
import com.juntcompany.godandgod.Manager.PropertyManager;
import com.juntcompany.godandgod.R;

public class ProfileFragment extends Fragment {


    public ProfileFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        final View view = inflater.inflate(R.layout.fragment_profile, container, false);


        if(MainActivity.profileNum == 0) {
            ProfileMainFragment fmain = new ProfileMainFragment();
            getChildFragmentManager()
                    .beginTransaction()
                    .replace(R.id.container, fmain)
                    .commit();
        }
        if(MainActivity.profileNum == 1) {
            ProfileMyprofileFragment fmain = new ProfileMyprofileFragment();
            getChildFragmentManager()
                    .beginTransaction()
                    .replace(R.id.container, fmain)
                    .commit();
        }
        if(MainActivity.profileNum == 2) {
            ProfileChargeheartFragment fmain = new ProfileChargeheartFragment();
            getChildFragmentManager()
                    .beginTransaction()
                    .replace(R.id.container, fmain)
                    .commit();
        }
        if(MainActivity.profileNum == 3) {
            ProfileSettingFragment fmain = new ProfileSettingFragment();
            getChildFragmentManager()
                    .beginTransaction()
                    .replace(R.id.container, fmain)
                    .commit();
        }





        return inflater.inflate(R.layout.fragment_profile, container, false);
    }



}