package com.juntcompany.godandgod.Login.SignIn;

import android.app.Activity;
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

import com.juntcompany.godandgod.Login.LoginActivity;
import com.juntcompany.godandgod.Main.MainActivity;
import com.juntcompany.godandgod.R;

public class SignInGenderFragment extends Fragment {
    private static final String Title = "성별 입력";
    public SignInGenderFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view =inflater.inflate(R.layout.fragment_sign_in_gender, container, false);
        Button btn = (Button)view.findViewById(R.id.buttonNext);
        SignInActivity.fNum = 8;
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Activity sa = SignInActivity.signActvity;
                sa.finish();
            }
        });

        ((SignInActivity) getActivity()).setActionTitle(Title);
        return view;
    }

}
