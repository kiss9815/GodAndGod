package com.juntcompany.godandgod.Login.LoginHelper;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.juntcompany.godandgod.R;


public class HelperCodeInputFragment extends Fragment {
    Context context;
    String Title = "계정 인증";
    public HelperCodeInputFragment() {

    }

    public static HelperCodeInputFragment newInstance(String param1, String param2) {
        HelperCodeInputFragment fragment = new HelperCodeInputFragment();
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
        final View view = inflater.inflate(R.layout.fragment_helper_code_input, container, false);
        final Button btn = (Button) view.findViewById(R.id.buttonNext);
        Button codebtn = (Button) view.findViewById(R.id.recode);

        HelperActivity.fNum = 4;
        btn.setVisibility(View.INVISIBLE);

        final EditText codeText = (EditText) view.findViewById(R.id.idText);
        codeText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence arg0, int arg1, int arg2, int arg3) {
                if (codeText.getText().length() == 1) {
                    btn.setVisibility(View.VISIBLE);
                } else if (codeText.getText().length() <= 1) {
                    btn.setVisibility(View.INVISIBLE);
                }
            }

            @Override
            public void afterTextChanged(Editable arg0) {

            }

        });

        codebtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                switch (v.getId()){
                    case R.id.recode:
                        Toast.makeText(getActivity(), "코드가 다시 전송되었습니다.", Toast.LENGTH_SHORT).show();
                        break;
                }
            }
        });

        ((HelperActivity) getActivity()).setActionTitle(Title);
        return view ;
    }





}
