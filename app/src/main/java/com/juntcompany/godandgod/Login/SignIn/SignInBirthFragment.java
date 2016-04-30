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
import android.widget.NumberPicker;

import com.juntcompany.godandgod.R;

public class SignInBirthFragment extends Fragment {
    private static final String Title = "생일 입력";
    public SignInBirthFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        final View view =inflater.inflate(R.layout.fragment_sign_in_birth, container, false);
        Button btn = (Button)view.findViewById(R.id.buttonNext);
        SignInActivity.fNum = 6;

        NumberPicker year = (NumberPicker) view.findViewById(R.id.year);
        NumberPicker month = (NumberPicker) view.findViewById(R.id.month);
        NumberPicker date = (NumberPicker) view.findViewById(R.id.date);

        year.setMaxValue(2100);
        year.setMinValue(1900);
        month.setMaxValue(12);
        month.setMinValue(1);
        date.setMaxValue(31);
        date.setMinValue(1);
        year.setValue(SignInActivity.birthYear);
        month.setValue(SignInActivity.birthMonth);
        date.setValue(SignInActivity.birthDate);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                NumberPicker year = (NumberPicker) view.findViewById(R.id.year);
                NumberPicker month = (NumberPicker) view.findViewById(R.id.month);
                NumberPicker date = (NumberPicker) view.findViewById(R.id.date);
                SignInActivity.birthYear = year.getValue();
                SignInActivity.birthMonth = month.getValue();
                SignInActivity.birthDate = date.getValue();

                SignInPasswordFragment f = new SignInPasswordFragment();
                FragmentTransaction ft = getActivity().getSupportFragmentManager().beginTransaction();
                ft.replace(R.id.container, f);
                ft.commit();    //어떤 버튼이 눌리던 백스택에 해당 프래그먼트가 저장됨
            }
        });

        ((SignInActivity) getActivity()).setActionTitle(Title);
        return view;
    }

}
