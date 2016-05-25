package com.juntcompany.godandgod.Login.LoginHelper;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
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

import com.juntcompany.godandgod.Dialog.ChatAllContentDeleteDialog;
import com.juntcompany.godandgod.Dialog.ChatDeleteDialog;
import com.juntcompany.godandgod.Dialog.CommentStatueDialog;
import com.juntcompany.godandgod.Dialog.EqualDialogActivity;
import com.juntcompany.godandgod.Dialog.FriendDeleteDialog;
import com.juntcompany.godandgod.Dialog.FriendRealDeleteDialog;
import com.juntcompany.godandgod.Dialog.MyProfileUpdateDialog;
import com.juntcompany.godandgod.Dialog.NoFriendResultDialog;
import com.juntcompany.godandgod.R;


public class HelperEmailFindFragment extends Fragment {

    public HelperEmailFindFragment() {

    }

    public static HelperEmailFindFragment newInstance(String param1, String param2) {
        HelperEmailFindFragment fragment = new HelperEmailFindFragment();
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
        HelperActivity.helpStatue = 1;
        HelperActivity.fNum = 7;
        final View view = inflater.inflate(R.layout.fragment_helper_email_find, container, false);
        final EditText emailText = (EditText) view.findViewById(R.id.InputEmailAddr);
        final Button btn = (Button) view.findViewById(R.id.buttonNext);
       // btn.setVisibility(View.INVISIBLE);
        emailText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence arg0, int arg1, int arg2, int arg3) {
                if (emailText.getText().length() == 1) {
                    btn.setVisibility(View.VISIBLE);
                } else if (emailText.getText().length() <= 1) {
                    btn.setVisibility(View.INVISIBLE);
                }
            }

            @Override
            public void afterTextChanged(Editable arg0) {

            }

        });

        btn.setOnClickListener(new View.OnClickListener() {
            EditText emailfind = (EditText) view.findViewById(R.id.InputEmailAddr);

            @Override
            public void onClick(View v) {
                        if (emailfind.getText().toString().equals("s")) {
                            HelperActivity.Emailaddr = emailfind.getText().toString();
                            HelperEndFragment f = new HelperEndFragment();
                            FragmentTransaction ft = getActivity().getSupportFragmentManager().beginTransaction();
                            ft.replace(R.id.container, f);
                            ft.commit();    //어떤 버튼이 눌리던 백스택에 해당 프래그먼트가 저장됨
                        } else {
                      //      HelperActivity.Emailaddr = "";
                         //   EditText p = (EditText) view.findViewById(R.id.InputEmailAddr);
                        //    p.setText(HelperActivity.Emailaddr);
                            startActivity(new Intent(HelperActivity.helperActvity.getApplicationContext(), FriendRealDeleteDialog.class));
                        }
            }
        });

        return view ;
    }



}
