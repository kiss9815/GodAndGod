package com.juntcompany.godandgod.Login.LoginHelper;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

import com.juntcompany.godandgod.Dialog.EqualDialogActivity;
import com.juntcompany.godandgod.R;

public class HelperPhoneFindFragment extends Fragment {

    String Title = "휴대폰 번호";
    public static String phoneCheck;

    public HelperPhoneFindFragment() {

    }


    @Override
    public View onCreateView(final LayoutInflater inflater, final ViewGroup container,
                             Bundle savedInstanceState) {
        final View view = inflater.inflate(R.layout.fragment_helper_phone_find, container, false);
        final Button btn = (Button) view.findViewById(R.id.nextfind);

        btn.setVisibility(View.INVISIBLE);
        HelperActivity.helpStatue = 0;
        HelperActivity.fNum = 2;


        final EditText phoneText = (EditText) view.findViewById(R.id.HelperPhoneInput);

        phoneText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence arg0, int arg1, int arg2, int arg3) {
                if (phoneText.getText().length() == 1) {
                    btn.setVisibility(View.VISIBLE);
                } else if (phoneText.getText().length() <= 1) {
                    btn.setVisibility(View.INVISIBLE);
                }
            }

            @Override
            public void afterTextChanged(Editable arg0) {

            }

        });

        btn.setOnClickListener(new View.OnClickListener() {
            EditText phonefind = (EditText) view.findViewById(R.id.HelperPhoneInput);

            @Override
            public void onClick(View v) {
                switch (v.getId()) {
                    case R.id.nextfind:
                        if (phonefind.getText().toString().equals("0123456789")) {
                            HelperActivity.phonenumber = phonefind.getText().toString();
                            HelperEndFragment f = new HelperEndFragment();
                            FragmentTransaction ft = getActivity().getSupportFragmentManager().beginTransaction();
                            ft.replace(R.id.container, f);
                            ft.commit();    //어떤 버튼이 눌리던 백스택에 해당 프래그먼트가 저장됨
                        } else {
                            HelperActivity.phonenumber = "";
                            EditText p = (EditText) view.findViewById(R.id.HelperPhoneInput);
                            p.setText(HelperActivity.phonenumber);
                            startActivity(new Intent(HelperActivity.helperActvity.getApplicationContext(), EqualDialogActivity.class));

                        }
                        break;
                }
            }
        });


        //스피너
        ((HelperActivity) getActivity()).setActionTitle(Title);
        Spinner s = (Spinner) view.findViewById(R.id.helperspinner);
        String[] str = getResources().getStringArray(R.array.nation);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>
                (getActivity().getApplication(), android.R.layout.simple_list_item_1, str);

        s.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                                        @Override
                                        public void onItemSelected(AdapterView<?> parent, View view,
                                                                   int position, long id) {
                                            final View helperview = inflater.inflate(R.layout.fragment_helper_phone_find, container, false);

                                            TextView tv = (TextView) helperview.findViewById(R.id.nationNum);

                                            switch (position) {
                                                case 0:
                                                    tv.setText(" ");
                                                    break;
                                                case 1:
                                                    tv.setText("+82");
                                                    break;
                                                case 2:
                                                    tv.setText("+84");
                                                    break;
                                                case 3:
                                                    tv.setText("+86");
                                                    break;
                                                case 4:
                                                    tv.setText("+87");
                                                    break;
                                                default:
                                                    return;
                                            }

                                        }

                                        @Override
                                        public void onNothingSelected(AdapterView<?> parent) {
                                        }

                                    }
        );
        return view;

    }


}
