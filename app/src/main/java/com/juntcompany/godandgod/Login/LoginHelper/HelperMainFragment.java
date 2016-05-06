package com.juntcompany.godandgod.Login.LoginHelper;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.juntcompany.godandgod.R;


public class HelperMainFragment extends Fragment {

    private static final String Title = "휴대폰 번호";

    public HelperMainFragment() {
        // Required empty public constructor
    }




    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        final View view = inflater.inflate(R.layout.fragment_helper_main, container, false);

        return view ;
    }

}
