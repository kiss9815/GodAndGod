package com.juntcompany.godandgod.Login.SignIn;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;

import com.juntcompany.godandgod.Login.LoginActivity;
import com.juntcompany.godandgod.Main.MainActivity;
import com.juntcompany.godandgod.Manager.PropertyManager;
import com.juntcompany.godandgod.R;

public class SignInGenderFragment extends Fragment {
    private static final String Title = "성별 입력";
    public SignInGenderFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        final View view =inflater.inflate(R.layout.fragment_sign_in_gender, container, false);
        Button btn = (Button)view.findViewById(R.id.buttonNext);
        TextView male = (TextView)view.findViewById(R.id.male);
        TextView female = (TextView)view.findViewById(R.id.female);
        RadioButton malecheck = (RadioButton) view.findViewById(R.id.maleCheck);
        RadioButton femalecheck = (RadioButton) view.findViewById(R.id.femaleCheck);
        SignInActivity.fNum = 9;

               if (SignInActivity.male == 1 && SignInActivity.female == 0) {
            malecheck.setChecked(true);
        } else if (SignInActivity.male == 0 && SignInActivity.female == 1) {
            femalecheck.setChecked(true);
        }
        male.setOnClickListener(new View.OnClickListener() {
            RadioButton malecheck = (RadioButton) view.findViewById(R.id.maleCheck);
            @Override
            public void onClick(View v) {
                malecheck.setChecked(true);
            }
        });
        female.setOnClickListener(new View.OnClickListener() {
            RadioButton femalecheck = (RadioButton) view.findViewById(R.id.femaleCheck);
            @Override
            public void onClick(View v) {
                femalecheck.setChecked(true);
            }
        });



        btn.setOnClickListener(new View.OnClickListener() {
            RadioButton malecheck = (RadioButton) view.findViewById(R.id.maleCheck);
            RadioButton femalecheck = (RadioButton) view.findViewById(R.id.femaleCheck);
            @Override
            public void onClick(View v) {
                if(malecheck.isChecked())
                {
                    SignInActivity.male = 1;
                    SignInActivity.female = 0;
                }
                else if(femalecheck.isChecked())
                {
                    SignInActivity.male = 0;
                    SignInActivity.female = 1;
                }
                SignInFinalFragment f = new SignInFinalFragment();
                FragmentTransaction ft = getActivity().getSupportFragmentManager().beginTransaction();
                ft.replace(R.id.container, f);
                ft.commit();    //어떤 버튼이 눌리던 백스택에 해당 프래그먼트가 저장됨
            }
        });

        ((SignInActivity) getActivity()).setActionTitle(Title);
        return view;
    }

}
