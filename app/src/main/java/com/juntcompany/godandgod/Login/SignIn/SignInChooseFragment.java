package com.juntcompany.godandgod.Login.SignIn;

import android.app.Activity;
import android.app.Dialog;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.ActionBar;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.TextView;
import android.widget.Toast;

import com.juntcompany.godandgod.R;

public class SignInChooseFragment extends Fragment {
    String Title = "회원 가입";

    public SignInChooseFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_sign_in_choose, container, false);
        TextView ttn = (TextView) view.findViewById(R.id.nextEmailPhone);//다음페이지
        TextView ttb = (TextView) view.findViewById(R.id.backLoginPage);//이전페이지
        SignInActivity.fNum = 0;
        ttn.setOnClickListener(new View.OnClickListener() {//다음페이지로
            @Override
            public void onClick(View v) {
                SignInTermsFragment f = new SignInTermsFragment();
                SignInActivity.fNum = getActivity().getSupportFragmentManager().getBackStackEntryCount();
                FragmentTransaction ft = getActivity().getSupportFragmentManager().beginTransaction();
                ft.replace(R.id.container, f);
                ft.addToBackStack("" + SignInActivity.fNum);
                ft.commit();    //어떤 버튼이 눌리던 백스택에 해당 프래그먼트가 저장됨
            }
        });
        ttb.setOnClickListener(new View.OnClickListener() {//아이디가 있을 경우에 로그인페이지로 다시 돌아가는 것
            @Override
            public void onClick(View v) {
                SignInActivity.signActvity.finish();
            }
        });
        ((SignInActivity) getActivity()).setActionTitle(Title);
        return view;
    }

}
