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
import android.widget.RadioButton;
import android.widget.TextView;

import com.juntcompany.godandgod.R;

public class SignInReligionFragment extends Fragment {
    private static final String Title = "종교 입력";
    public SignInReligionFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        final View view =inflater.inflate(R.layout.fragment_sign_in_religion, container, false);
        Button btn = (Button)view.findViewById(R.id.buttonNext);
        TextView christian = (TextView)view.findViewById(R.id.Christian);
        TextView catholic = (TextView)view.findViewById(R.id.Catholic);
        final TextView buddhism = (TextView)view.findViewById(R.id.Buddhism);
        TextView othersReligion = (TextView)view.findViewById(R.id.othersReligion);

        final RadioButton christiancheck = (RadioButton) view.findViewById(R.id.ChristianCheck);
        final RadioButton catholiccheck = (RadioButton) view.findViewById(R.id.CatholicCheck);
        final RadioButton buddhismcheck = (RadioButton) view.findViewById(R.id.BuddhismCheck);
        final RadioButton othersReligioncheck = (RadioButton) view.findViewById(R.id.othersReligionCheck);
        SignInActivity.fNum = 8;

        if(SignInActivity.christianStatue == 1)
        {
            christiancheck.setChecked(true);
        }else if(SignInActivity.catholicStatue == 1)
        {
            catholiccheck.setChecked(true);
        }
        else if(SignInActivity.buddhismStatue == 1)
        {
            buddhismcheck.setChecked(true);
        }
        else if(SignInActivity.othersReligionStatue == 1)
        {
            othersReligioncheck.setChecked(true);
        }

        christian.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                christiancheck.setChecked(true);
            }
        });
        catholic.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                catholiccheck.setChecked(true);
            }
        });
        buddhism.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                buddhismcheck.setChecked(true);
            }
        });
        othersReligion.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                othersReligioncheck.setChecked(true);
            }
        });



        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (SignInActivity.resultpage == false) {
                    if (christiancheck.isChecked()) {
                        SignInActivity.christianStatue = 1;
                        SignInActivity.catholicStatue = 0;
                        SignInActivity.buddhismStatue = 0;
                        SignInActivity.othersReligionStatue = 0;
                    } else if (catholiccheck.isChecked()) {
                        SignInActivity.christianStatue = 0;
                        SignInActivity.catholicStatue = 1;
                        SignInActivity.buddhismStatue = 0;
                        SignInActivity.othersReligionStatue = 0;
                    } else if (buddhismcheck.isChecked()) {
                        SignInActivity.christianStatue = 0;
                        SignInActivity.catholicStatue = 0;
                        SignInActivity.buddhismStatue = 1;
                        SignInActivity.othersReligionStatue = 0;
                    } else if (othersReligioncheck.isChecked()) {
                        SignInActivity.christianStatue = 0;
                        SignInActivity.catholicStatue = 0;
                        SignInActivity.buddhismStatue = 0;
                        SignInActivity.othersReligionStatue = 1;
                    }
                    SignInGenderFragment f = new SignInGenderFragment();
                    FragmentTransaction ft = getActivity().getSupportFragmentManager().beginTransaction();
                    ft.replace(R.id.container, f);
                    ft.commit();    //어떤 버튼이 눌리던 백스택에 해당 프래그먼트가 저장됨
                }
                else if (SignInActivity.resultpage == true) {
                    if (christiancheck.isChecked()) {
                        SignInActivity.christianStatue = 1;
                        SignInActivity.catholicStatue = 0;
                        SignInActivity.buddhismStatue = 0;
                        SignInActivity.othersReligionStatue = 0;
                    } else if (catholiccheck.isChecked()) {
                        SignInActivity.christianStatue = 0;
                        SignInActivity.catholicStatue = 1;
                        SignInActivity.buddhismStatue = 0;
                        SignInActivity.othersReligionStatue = 0;
                    } else if (buddhismcheck.isChecked()) {
                        SignInActivity.christianStatue = 0;
                        SignInActivity.catholicStatue = 0;
                        SignInActivity.buddhismStatue = 1;
                        SignInActivity.othersReligionStatue = 0;
                    } else if (othersReligioncheck.isChecked()) {
                        SignInActivity.christianStatue = 0;
                        SignInActivity.catholicStatue = 0;
                        SignInActivity.buddhismStatue = 0;
                        SignInActivity.othersReligionStatue = 1;
                    }
                    SignInFinalFragment f = new SignInFinalFragment();
                    FragmentTransaction ft = getActivity().getSupportFragmentManager().beginTransaction();
                    ft.replace(R.id.container, f);
                    ft.commit();    //어떤 버튼이 눌리던 백스택에 해당 프래그먼트가 저장됨
                }
            }
        });

        ((SignInActivity) getActivity()).setActionTitle(Title);
        return view;
    }

}
