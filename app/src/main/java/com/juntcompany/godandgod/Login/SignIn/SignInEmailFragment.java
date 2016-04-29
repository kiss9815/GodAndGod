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
import android.widget.EditText;
import android.widget.TextView;

import com.juntcompany.godandgod.Manager.PropertyManager;
import com.juntcompany.godandgod.R;
public class SignInEmailFragment extends Fragment {


    private static final String Title = "이메일 주소 입력";


    public SignInEmailFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        final View view =inflater.inflate(R.layout.fragment_sign_in_email, container, false);
        Button btn = (Button)view.findViewById(R.id.buttonNext);
        EditText email = (EditText) view.findViewById(R.id.inputEmail);
        SignInActivity.fNum = 3;
        if(SignInActivity.email != null)
        {
            email.setText(SignInActivity.email);
        }
        btn.setOnClickListener(new View.OnClickListener() {
            EditText email = (EditText) view.findViewById(R.id.inputEmail);
            @Override
            public void onClick(View v) {
                SignInActivity.email = email.getText().toString();
                SignInNameFragment f = new SignInNameFragment();
                FragmentTransaction ft = getActivity().getSupportFragmentManager().beginTransaction();
                ft.replace(R.id.container, f);
                ft.commit();    //어떤 버튼이 눌리던 백스택에 해당 프래그먼트가 저장됨
            }
        });
        ((SignInActivity) getActivity()).setActionTitle(Title);


        return view;
    }


}
