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
                SignInActivity.fNum = 0;
                SignInActivity.personalStatue = 0;
                SignInActivity.birthYear = 1980;
                SignInActivity.birthMonth = 1;
                SignInActivity.birthDate = 1;
                SignInActivity.male = 0;
                SignInActivity.female = 0;
                SignInActivity.pwInput = null;
                SignInActivity.fName = null;
                SignInActivity.oName = null;
                Activity sa = SignInActivity.signActvity;
                sa.finish();
            }
        });

        TextView policy = (TextView) view.findViewById(R.id.policyText);
        TextView phone = (TextView) view.findViewById(R.id.phoneText);
        TextView email = (TextView) view.findViewById(R.id.emailText);
        TextView name = (TextView) view.findViewById(R.id.nameText);
        TextView birth = (TextView) view.findViewById(R.id.birthText);
        TextView pw = (TextView) view.findViewById(R.id.pwText);
        TextView religion = (TextView) view.findViewById(R.id.religionText);
        TextView gender = (TextView) view.findViewById(R.id.genderText);


        String sex = "";
        if (SignInActivity.male == 1 && SignInActivity.female == 0) {
            sex = "남성";
        } else if (SignInActivity.male == 0 && SignInActivity.female == 1) {
            sex = "여성";
        } else {
            sex = "오류";
        }
        String ok = null;
        if(SignInActivity.personalStatue == 2)
        {
            ok = "동의";
        }
        String birthday = SignInActivity.birthYear + "년 " + SignInActivity.birthMonth + "월" + SignInActivity.birthDate + "일";
        String username = SignInActivity.fName + SignInActivity.oName;
        policy.setText(ok);
        policy.setTextColor(Color.BLACK);
        name.setText(username);
        name.setTextColor(Color.BLACK);
        birth.setText(birthday);
        birth.setTextColor(Color.BLACK);
        pw.setText(SignInActivity.pwInput);
        pw.setTextColor(Color.BLACK);
        gender.setText(sex);
        gender.setTextColor(Color.BLACK);

        ((SignInActivity) getActivity()).hideActionBar();

        ((SignInActivity) getActivity()).setActionTitle(Title);
        return view;
    }

}
