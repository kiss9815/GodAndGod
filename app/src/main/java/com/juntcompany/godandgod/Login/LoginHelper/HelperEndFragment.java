package com.juntcompany.godandgod.Login.LoginHelper;

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
import android.widget.RadioButton;
import android.widget.TableLayout;
import android.widget.TextView;

import com.juntcompany.godandgod.Login.SignIn.SignInActivity;
import com.juntcompany.godandgod.Login.SignIn.SignInFinalFragment;
import com.juntcompany.godandgod.R;

public class HelperEndFragment extends Fragment {
    String Title = "계정 인증";
    public HelperEndFragment() {
        // Required empty public constructor
    }

    public static HelperEndFragment newInstance(String param1, String param2) {
        HelperEndFragment fragment = new HelperEndFragment();
        Bundle args = new Bundle();
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        final View view = inflater.inflate(R.layout.fragment_helper_end, container, false);
        Button btn = (Button)view.findViewById(R.id.buttonNext);
        TableLayout Sms = (TableLayout) view.findViewById(R.id.SmsFindLayout);
        TableLayout Em = (TableLayout) view.findViewById(R.id.emailFindLayout);
        RadioButton phonecheck = (RadioButton) view.findViewById(R.id.findPhone);
        RadioButton emailcheck = (RadioButton) view.findViewById(R.id.findEmaill);
        TextView smsfind = (TextView) view.findViewById(R.id.phoneNum);
        TextView emfind = (TextView) view.findViewById(R.id.EmailAddr);
        smsfind.setText(HelperActivity.phonenumber);
        emfind.setText(HelperActivity.Emailaddr);
        HelperActivity.fNum = 3;

        btn.setOnClickListener(new View.OnClickListener() {
            RadioButton phonecheck = (RadioButton) view.findViewById(R.id.findPhone);
            RadioButton emailcheck = (RadioButton) view.findViewById(R.id.findEmaill);
            @Override
            public void onClick(View v) {
                if(phonecheck.isChecked())
                {
                    HelperActivity.Sms = 1;
                    HelperActivity.Em = 0;
                    HelperCodeInputFragment f = new HelperCodeInputFragment();
                    FragmentTransaction ft = getActivity().getSupportFragmentManager().beginTransaction();
                    ft.replace(R.id.container, f);
                    ft.commit();
                }
                else if(emailcheck.isChecked())
                {
                    HelperActivity.Sms = 0;
                    HelperActivity.Em = 1;
                    HelperCodeInputFragment f = new HelperCodeInputFragment();
                    FragmentTransaction ft = getActivity().getSupportFragmentManager().beginTransaction();
                    ft.replace(R.id.container, f);
                    ft.commit();
                }

                //HelperMainFragment f = new HelperMainFragment();
                //FragmentTransaction ft = getActivity().getSupportFragmentManager().beginTransaction();
                //ft.replace(R.id.container, f);
                //ft.commit();    //어떤 버튼이 눌리던 백스택에 해당 프래그먼트가 저장됨
            }
        });

        Em.setOnClickListener(new View.OnClickListener() {
            RadioButton emailcheck = (RadioButton) view.findViewById(R.id.findEmaill);
            @Override
            public void onClick(View v) {
                emailcheck.setChecked(true);
            }
        });

        Sms.setOnClickListener(new View.OnClickListener() {
            RadioButton phonecheck = (RadioButton) view.findViewById(R.id.findPhone);
            @Override
            public void onClick(View v) {
                phonecheck.setChecked(true);
            }
        });

        ((HelperActivity) getActivity()).setActionTitle(Title);
        return view;
    }



}
