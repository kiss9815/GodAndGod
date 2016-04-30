package com.juntcompany.godandgod.Login.SignIn;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import com.juntcompany.godandgod.R;

public class SignInNameFragment extends Fragment {
    private static final String Title = "이름 입력";
    public SignInNameFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view =inflater.inflate(R.layout.fragment_sign_in_name, container, false);
        Button btn = (Button)view.findViewById(R.id.buttonNext);
        final EditText fText = (EditText) view.findViewById(R.id.familyName);
        final EditText oText = (EditText) view.findViewById(R.id.otherName);
        if(SignInActivity.fName != null)
        {
            fText.setText(SignInActivity.fName);
        }
        if(SignInActivity.oName != null)
        {
            oText.setText(SignInActivity.oName);
        }


        SignInActivity.fNum = 5;
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SignInActivity.fName = fText.getText().toString();
                SignInActivity.oName = oText.getText().toString();
                SignInBirthFragment f = new SignInBirthFragment();
                FragmentTransaction ft = getActivity().getSupportFragmentManager().beginTransaction();
                ft.replace(R.id.container, f);
                ft.commit();    //어떤 버튼이 눌리던 백스택에 해당 프래그먼트가 저장됨

            }
        });

        ((SignInActivity) getActivity()).setActionTitle(Title);
        return view;
    }

}
