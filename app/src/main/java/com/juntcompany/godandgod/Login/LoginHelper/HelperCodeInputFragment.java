package com.juntcompany.godandgod.Login.LoginHelper;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.juntcompany.godandgod.Dialog.EqualDialogActivity;
import com.juntcompany.godandgod.Dialog.NoEqualCodeActivity;
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
        TextView ctt = (TextView) view.findViewById(R.id.nember);
        TextView ctb = (TextView) view.findViewById(R.id.emailrecode);
        Button codebtn = (Button) view.findViewById(R.id.recode);

        if(HelperActivity.helpStatue == 0)
        {
            ctt.setText("번호로 SMS가 전송되었습니다.");
            ctb.setText("이메일로 코드 받기");
        }
        else if(HelperActivity.helpStatue == 1)
        {
            ctt.setText("이메일 주소로 메세지가 전송되었습니다.");
            ctb.setText("SMS로 코드 받기");
        }

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


        btn.setOnClickListener(new View.OnClickListener() {
            EditText codeinput = (EditText) view.findViewById(R.id.idText);

            @Override
            public void onClick(View v) {
                switch (v.getId()) {
                    case R.id.buttonNext:
                        if (codeinput.getText().toString().equals("1")) {
                            HelperActivity.codenumber = codeinput.getText().toString();
                            HelperNewPasswordFragment f = new HelperNewPasswordFragment();
                            FragmentTransaction ft = getActivity().getSupportFragmentManager().beginTransaction();
                            ft.replace(R.id.container, f);
                            ft.commit();   //어떤 버튼이 눌리던 백스택에 해당 프래그먼트가 저장됨
                        } else {
                            HelperActivity.codenumber = "";
                            EditText p = (EditText) view.findViewById(R.id.idText);
                            p.setText(HelperActivity.codenumber);
                            startActivity(new Intent(HelperActivity.helperActvity.getApplicationContext(),NoEqualCodeActivity.class));
                        }
                        break;
                }
            }
        });


        ((HelperActivity) getActivity()).setActionTitle(Title);
        return view ;
    }





}
