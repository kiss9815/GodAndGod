package com.juntcompany.godandgod.Login.SignIn;

import android.app.Activity;
import android.content.Context;
import android.graphics.Color;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
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
        SignInActivity.fNum = 10;
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
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
                SignInActivity.email = null;
                SignInActivity.christianStatue = 0;
                SignInActivity.catholicStatue = 0;
                SignInActivity.buddhismStatue = 0;
                SignInActivity.othersReligionStatue = 0;
                SignInActivity.resultpage = false;
                Activity sa = SignInActivity.signActvity;
                sa.finish();
            }
        });

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
        String religionStatue = "";
        if(SignInActivity.christianStatue == 1)
        {
            religionStatue = "기독교";
        }else if(SignInActivity.catholicStatue == 1)
        {
            religionStatue = "천주교";
        }
        else if(SignInActivity.buddhismStatue == 1)
        {
            religionStatue = "불교";
        }
        else if(SignInActivity.othersReligionStatue == 1)
        {
            religionStatue = "기타";
        }


        String birthday = SignInActivity.birthYear + "년 " + SignInActivity.birthMonth + "월" + SignInActivity.birthDate + "일";
        String username = SignInActivity.fName + SignInActivity.oName;
        email.setText(SignInActivity.email);
        email.setTextColor(Color.BLACK);
        name.setText(username);
        name.setTextColor(Color.BLACK);
        birth.setText(birthday);
        birth.setTextColor(Color.BLACK);
        pw.setText(SignInActivity.pwInput);
        pw.setTextColor(Color.BLACK);
        religion.setText(religionStatue);
        religion.setTextColor(Color.BLACK);
        gender.setText(sex);
        gender.setTextColor(Color.BLACK);

        email.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SignInActivity.resultpage = true;
                SignInEmailFragment f = new SignInEmailFragment();
                FragmentTransaction ft = getActivity().getSupportFragmentManager().beginTransaction();
                ft.replace(R.id.container, f);
                ft.commit();
            }
        });
        name.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SignInActivity.resultpage = true;
                SignInNameFragment f = new SignInNameFragment();
                FragmentTransaction ft = getActivity().getSupportFragmentManager().beginTransaction();
                ft.replace(R.id.container, f);
                ft.commit();
            }
        });
        birth.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SignInActivity.resultpage = true;
                SignInBirthFragment f = new SignInBirthFragment();
                FragmentTransaction ft = getActivity().getSupportFragmentManager().beginTransaction();
                ft.replace(R.id.container, f);
                ft.commit();
            }
        });
        pw.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SignInActivity.resultpage = true;
                SignInPasswordFragment f = new SignInPasswordFragment();
                FragmentTransaction ft = getActivity().getSupportFragmentManager().beginTransaction();
                ft.replace(R.id.container, f);
                ft.commit();
            }
        });
        religion.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SignInActivity.resultpage = true;
                SignInReligionFragment f = new SignInReligionFragment();
                FragmentTransaction ft = getActivity().getSupportFragmentManager().beginTransaction();
                ft.replace(R.id.container, f);
                ft.commit();
            }
        });
        gender.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SignInActivity.resultpage = true;
                SignInGenderFragment f = new SignInGenderFragment();
                FragmentTransaction ft = getActivity().getSupportFragmentManager().beginTransaction();
                ft.replace(R.id.container, f);
                ft.commit();
            }
        });


        ((SignInActivity) getActivity()).setActionTitle(Title);
        return view;
    }

}
