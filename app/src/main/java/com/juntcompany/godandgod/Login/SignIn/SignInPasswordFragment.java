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
import android.widget.TextView;

import com.juntcompany.godandgod.R;

public class SignInPasswordFragment extends Fragment {
    private static final String Title = "비밀번호 입력";
    public SignInPasswordFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        final View view =inflater.inflate(R.layout.fragment_sign_in_password, container, false);
        Button btn = (Button)view.findViewById(R.id.buttonNext);
        TextView pw = (TextView) view.findViewById(R.id.signInPwInput);
        if(SignInActivity.pwInput != null) {
            pw.setText(SignInActivity.pwInput);
        }
        SignInActivity.fNum = 7;
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                TextView pw = (TextView) view.findViewById(R.id.signInPwInput);
                SignInActivity.pwInput = pw.getText().toString();
                SignInReligionFragment f = new SignInReligionFragment();
                FragmentTransaction ft = getActivity().getSupportFragmentManager().beginTransaction();
                ft.replace(R.id.container, f);
                ft.commit();    //어떤 버튼이 눌리던 백스택에 해당 프래그먼트가 저장됨
            }
        });

        ((SignInActivity) getActivity()).setActionTitle(Title);
        return view;
    }

}
