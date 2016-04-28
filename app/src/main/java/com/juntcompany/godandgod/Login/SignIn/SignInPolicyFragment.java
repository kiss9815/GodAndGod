package com.juntcompany.godandgod.Login.SignIn;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.ActionBar;
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


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_sign_in_policy, container, false);
        TextView ttn = (TextView) view.findViewById(R.id.nextEmailPhone);//다음페이지
        TextView ttb = (TextView) view.findViewById(R.id.backLoginPage);//이전페이지
        SignInActivity.fNum = 1;
        ttn.setOnClickListener(new View.OnClickListener() {//다음페이지로
            @Override
            public void onClick(View v) {
                SignInPhoneFragment f = new SignInPhoneFragment();
                FragmentTransaction ft = getActivity().getSupportFragmentManager().beginTransaction();
                ft.replace(R.id.container, f);
                ft.commit();    //어떤 버튼이 눌리던 백스택에 해당 프래그먼트가 저장됨
            }
        });

        return view;
    }

    private static final String Title = "약관 및 개인정보";

    @Override
    public void onResume() {
        super.onResume();
        ActionBar actionBar = ((SignInActivity) getActivity()).getSupportActionBar();
        View view = actionBar.getCustomView();
        TextView textView = (TextView) view.findViewById(R.id.toolbar_text);
        textView.setText(Title);

    }

}
