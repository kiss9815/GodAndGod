package com.juntcompany.godandgod.Main.Profile;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.juntcompany.godandgod.Login.LoginActivity;
import com.juntcompany.godandgod.Login.LoginHelper.HelperActivity;
import com.juntcompany.godandgod.Login.SignIn.SignInActivity;
import com.juntcompany.godandgod.Main.MainActivity;
import com.juntcompany.godandgod.MainToolbar.ChatFragment;
import com.juntcompany.godandgod.R;

public class ProfileSettingFragment extends Fragment {

    public ProfileSettingFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        return inflater.inflate(R.layout.fragment_profile_setting, container, false);
    }


}
