package com.juntcompany.godandgod.Login.SignIn;

import android.app.Activity;
import android.content.Context;
import android.graphics.Color;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.juntcompany.godandgod.R;

public class SignInFinalFragment extends Fragment {

    private static final String Title = "가입 완료";

    public SignInFinalFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_sign_in_final, container, false);
        Button btn = (Button) view.findViewById(R.id.buttonNext);
        SignInActivity.fNum = 9;
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Activity sa = SignInActivity.signActvity;
                sa.finish();
            }
        });

        TextView policy = (TextView) view.findViewById(R.id.policyText);
        TextView phone = (TextView) view.findViewById(R.id.phoneText);
        TextView email = (TextView) view.findViewById(R.id.emailText);
        TextView name = (TextView) view.findViewById(R.id.nameText);
        TextView birth = (TextView) view.findViewById(R.id.birthText);
        TextView pw = (TextView) view.findViewById(R.id.passwordText);
        TextView religion = (TextView) view.findViewById(R.id.religionText);
        TextView gender = (TextView) view.findViewById(R.id.genderText);


        String birthday = SignInActivity.birthYear + "년 " + SignInActivity.birthMonth + "월" + SignInActivity.birthDate + "일";
        policy.setText(String.valueOf(SignInActivity.personalStatue));
        policy.setTextColor(Color.BLACK);
        birth.setText(birthday);
        birth.setTextColor(Color.BLACK);

        ((SignInActivity) getActivity()).showActionBar();

        ((SignInActivity) getActivity()).setActionTitle(Title);
        return view;
    }

}
