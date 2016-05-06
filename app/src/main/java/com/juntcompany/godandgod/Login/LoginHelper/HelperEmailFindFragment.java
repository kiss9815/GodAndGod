package com.juntcompany.godandgod.Login.LoginHelper;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

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
        final View view = inflater.inflate(R.layout.fragment_helper_email_find, container, false);

        return view ;
    }



}
