package com.juntcompany.godandgod.Login.SignIn;

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

import com.juntcompany.godandgod.R;

public class SignInTermsFragment extends Fragment {

    public SignInTermsFragment() {
        // Required empty public constructor
    }


    private static final String Title = "약관";

    @Override
    public View onCreateView(final LayoutInflater inflater, final ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        final View view = inflater.inflate(R.layout.fragment_sign_in_terms, container, false);
        Button agree = (Button) view.findViewById(R.id.agree);
        final Button btn = (Button) view.findViewById(R.id.buttonNext);//다음페이지
        SignInActivity.fNum = 1;
        btn.setVisibility(View.INVISIBLE);
        if(SignInActivity.termsStatue==2)
        {
            agree.setBackgroundResource(R.drawable.buttonstyle1);
            agree.setTextColor(Color.WHITE);
            btn.setVisibility(View.VISIBLE);
        }
        agree.setOnClickListener(new View.OnClickListener() {
            Button btn = (Button) view.findViewById(R.id.buttonNext);
            Button agree = (Button) view.findViewById(R.id.agree);
            @Override
            public void onClick(View v) {
                if (SignInActivity.termsStatue == 0) {
                    SignInActivity.termsStatue = 1;
                    agree.setBackgroundResource(R.drawable.buttonstyle1);
                    agree.setTextColor(Color.WHITE);
                    btn.setVisibility(View.VISIBLE);
                } else{
                    SignInActivity.termsStatue = 0;
                    agree.setBackgroundResource(R.drawable.buttonstyle2);
                    agree.setTextColor(Color.BLACK);
                    btn.setVisibility(View.INVISIBLE);
                }
            }
        });
        btn.setOnClickListener(new View.OnClickListener() {//다음페이지로
            @Override
            public void onClick(View v) {
                SignInActivity.termsStatue = 2;
                SignInPolicyFragment f = new SignInPolicyFragment();
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
