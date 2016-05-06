package com.juntcompany.godandgod.Login.LoginHelper;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.juntcompany.godandgod.R;

public class HelperPhoneFindFragment extends Fragment {

    public HelperPhoneFindFragment() {

    }

    String Title = "휴대폰 번호";


    public static HelperPhoneFindFragment newInstance(String param1, String param2) {
        HelperPhoneFindFragment fragment = new HelperPhoneFindFragment();
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
        final View view = inflater.inflate(R.layout.fragment_helper_phone_find, container, false);


        return view ;
    }



}
