package com.juntcompany.godandgod.Main.Profile;

import android.annotation.TargetApi;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.juntcompany.godandgod.Data.sendData;
import com.juntcompany.godandgod.Main.MainActivity;
import com.juntcompany.godandgod.Main.Profile.MyProfile.ProfileMyprofileFragment;
import com.juntcompany.godandgod.Main.Profile.chargeHeart.ProfileChargeheartFragment;
import com.juntcompany.godandgod.R;

public class ProfileFragment extends Fragment {
    public ProfileFragment() {
        // Required empty public constructor
    }

    @TargetApi(Build.VERSION_CODES.JELLY_BEAN)
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