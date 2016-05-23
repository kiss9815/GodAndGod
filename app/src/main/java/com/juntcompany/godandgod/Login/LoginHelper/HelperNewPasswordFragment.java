package com.juntcompany.godandgod.Login.LoginHelper;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import com.juntcompany.godandgod.R;


public class HelperNewPasswordFragment extends Fragment {

    String Title = "계정 비밀번호";

    public HelperNewPasswordFragment() {

    }

    public static HelperNewPasswordFragment newInstance(String param1, String param2) {
        HelperNewPasswordFragment fragment = new HelperNewPasswordFragment();
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
        // Inflate the layout for this fragment
        final View view = inflater.inflate(R.layout.fragment_helper_new_password, container, false);

        final Button btn = (Button) view.findViewById(R.id.buttonNext);
        final EditText editText = (EditText) view.findViewById(R.id.InputNewPassword);

        HelperActivity.fNum = 5;
        btn.setVisibility(View.INVISIBLE);

        editText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence arg0, int arg1, int arg2, int arg3) {
                if (editText.getText().length() == 1) {
                    btn.setVisibility(View.VISIBLE);
                } else if (editText.getText().length() <= 1) {
                    btn.setVisibility(View.INVISIBLE);
                }
            }

            @Override
            public void afterTextChanged(Editable arg0) {

            }

        });

        btn.setOnClickListener(new View.OnClickListener(){
                                   @Override
                                   public void onClick(View v) {
                                      getActivity().finish();
                                   }
                               }
        );
        ((HelperActivity) getActivity()).setActionTitle(Title);
        return view;
    }

}
