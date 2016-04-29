package com.juntcompany.godandgod.Login.SignIn;


import android.app.Activity;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.ActionBar;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.juntcompany.godandgod.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class SignInPolicyFragment extends Fragment {


    public SignInPolicyFragment() {
        // Required empty public constructor
    }


    private static final String Title = "약관 및 개인정보";

    @Override
    public View onCreateView(final LayoutInflater inflater, final ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        final View view = inflater.inflate(R.layout.fragment_sign_in_policy, container, false);
        Button agree = (Button) view.findViewById(R.id.agree);
        final Button btn = (Button) view.findViewById(R.id.nextpage);//다음페이지
        SignInActivity.fNum = 1;
        btn.setVisibility(View.INVISIBLE);
        if(SignInActivity.personalStatue==2)
        {
            agree.setBackgroundColor(Color.parseColor("#6495ed"));
            agree.setTextColor(Color.WHITE);
            btn.setVisibility(View.VISIBLE);
        }
        agree.setOnClickListener(new View.OnClickListener() {
            Button btn = (Button) view.findViewById(R.id.nextpage);
            Button agree = (Button) view.findViewById(R.id.agree);
            @Override
            public void onClick(View v) {
                if (SignInActivity.personalStatue == 0) {
                    SignInActivity.personalStatue = 1;
                    agree.setBackgroundColor(Color.parseColor("#6495ed"));
                    agree.setTextColor(Color.WHITE);
                    btn.setVisibility(View.VISIBLE);
                } else{
                    SignInActivity.personalStatue = 0;
                    agree.setBackgroundColor(Color.parseColor("#dcdcdc"));
                    agree.setTextColor(Color.BLACK);
                    btn.setVisibility(View.INVISIBLE);
                }
            }
        });
        btn.setOnClickListener(new View.OnClickListener() {//다음페이지로
            @Override
            public void onClick(View v) {
                SignInActivity.personalStatue = 2;
                SignInPhoneFragment f = new SignInPhoneFragment();
                FragmentTransaction ft = getActivity().getSupportFragmentManager().beginTransaction();
                ft.replace(R.id.container, f);
                ft.commit();    //어떤 버튼이 눌리던 백스택에 해당 프래그먼트가 저장됨
            }
        });
        ((SignInActivity) getActivity()).setActionTitle(Title);
        ((SignInActivity) getActivity()).showActionBar();
        return view;
    }


}
