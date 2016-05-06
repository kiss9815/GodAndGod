package com.juntcompany.godandgod.Login.LoginHelper;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.juntcompany.godandgod.Login.SignIn.SignInActivity;
import com.juntcompany.godandgod.R;


public class HelperMainFragment extends Fragment {

    String Title = "로그인 도움말";

    public HelperMainFragment() {

    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        final View view = inflater.inflate(R.layout.fragment_helper_main, container, false);

        HelperActivity.fNum = 1;
        ((HelperActivity) getActivity()).setActionTitle(Title);
        return view ;
    }



}
