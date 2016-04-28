package com.juntcompany.godandgod.Login.SignIn;


import android.app.Activity;
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
public class SignInPhoneFragment extends Fragment {


    public SignInPhoneFragment() {
        // Required empty public constructor
    }


    private static final String Title = "휴대 전화 입력";

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_sign_in_phone, container, false);
        Button btn = (Button)view.findViewById(R.id.buttonNext);
        SignInActivity.fNum = 2;
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SignInEmailFragment f = new SignInEmailFragment();
                FragmentTransaction ft = getActivity().getSupportFragmentManager().beginTransaction();
                ft.replace(R.id.container, f);
                ft.commit();    //어떤 버튼이 눌리던 백스택에 해당 프래그먼트가 저장됨
            }
        });
        ((SignInActivity) getActivity()).setActionTitle(Title);
        return view;
    }
//    @Override
//    public void onResume() {
//        super.onResume();
//        ActionBar actionBar = ((SignInActivity) getActivity()).getSupportActionBar();
//        View view = actionBar.getCustomView();
//        TextView textView = (TextView)view.findViewById(R.id.toolbar_text);
//        textView.setText(Title);
//
//    }

}