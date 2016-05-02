package com.juntcompany.godandgod.Login.SignIn;


import android.app.Activity;
import android.os.Bundle;
import android.renderscript.Sampler;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.widget.RecyclerView ;
import android.support.v7.app.ActionBar;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.EditText;

import com.juntcompany.godandgod.Manager.PropertyManager;
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
        final View view = inflater.inflate(R.layout.fragment_sign_in_phone, container, false);
        Button btn = (Button) view.findViewById(R.id.buttonNext);
        Button btclear = (Button) view.findViewById(R.id.PhoneClear);
        EditText phone = (EditText) view.findViewById(R.id.inputPhone);
        Spinner spnation = (Spinner) view.findViewById(R.id.spinner) ;

        SignInActivity.fNum = 2;
        spnation.setSelection(0);

        if(SignInActivity.phone != null)
        {
            phone.setText(SignInActivity.phone);
        }

       if(SignInActivity.spnation != 0)
        {
          spnation.setSelection(SignInActivity.spnation);
        }

        btn.setOnClickListener(new View.OnClickListener() {
            EditText phone = (EditText) view.findViewById(R.id.inputPhone);
            @Override
            public void onClick(View v) {
                if (SignInActivity.resultpage == false) {
                    SignInActivity.phone = phone.getText().toString();
                    SignInEmailFragment f = new SignInEmailFragment();
                    FragmentTransaction ft = getActivity().getSupportFragmentManager().beginTransaction();
                    ft.replace(R.id.container, f);
                    ft.commit();    //어떤 버튼이 눌리던 백스택에 해당 프래그먼트가 저장됨
                }
                else if (SignInActivity.resultpage == true) {
                    SignInActivity.phone = phone.getText().toString();
                    SignInFinalFragment f = new SignInFinalFragment();
                    FragmentTransaction ft = getActivity().getSupportFragmentManager().beginTransaction();
                    ft.replace(R.id.container, f);
                    ft.commit();
                }
            }
        });

        btclear.setOnClickListener(new View.OnClickListener() {
            EditText phone = (EditText) view.findViewById(R.id.inputPhone);
            @Override
            public void onClick(View v) {
                phone.setText("");
            }
        });


        ((SignInActivity) getActivity()).getApplicationContext();
        ((SignInActivity) getActivity()).setActionTitle(Title);

        String[] str = getResources().getStringArray(R.array.nation);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>
                (getActivity().getApplication(), android.R.layout.simple_spinner_dropdown_item, str);
        Spinner s = (Spinner) view.findViewById(R.id.spinner);
        s.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                                        @Override
                                        public void onItemSelected(AdapterView<?> parent, View view,
                                                                   int position, long id) {
                                            if(position == 1){
                                                SignInActivity.spnation = 1;
                                            }
                                            else if(position == 2){
                                                SignInActivity.spnation = 2;
                                            }
                                            else if(position == 3){
                                                SignInActivity.spnation = 3;
                                            }
                                            else if(position == 4){
                                                SignInActivity.spnation = 4;
                                            }

                                        }
                                        @Override
                                        public void onNothingSelected(AdapterView<?> parent) {}

                                    }
        );

        return view;

    }
}
