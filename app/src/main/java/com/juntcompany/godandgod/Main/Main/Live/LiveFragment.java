package com.juntcompany.godandgod.Main.Main.Live;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.ActionBar;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.juntcompany.godandgod.Main.MainActivity;
import com.juntcompany.godandgod.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class LiveFragment extends Fragment {


    public LiveFragment() {
        // Required empty public constructor
        setHasOptionsMenu(true);
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_live, container, false);
    }

    ActionBar actionBar;
    @Override
    public void onResume() {
        super.onResume();
        actionBar = ((MainActivity) getActivity()).getSupportActionBar();

        View view = actionBar.getCustomView();
        Button btn = (Button)view.findViewById(R.id.buttonChat);
        btn.setVisibility(View.GONE);

        Button buttonStar = new Button(getContext());
        buttonStar.setBackgroundResource(android.R.drawable.btn_star);


    }



}
