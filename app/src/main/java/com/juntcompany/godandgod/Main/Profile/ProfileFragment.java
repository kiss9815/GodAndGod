package com.juntcompany.godandgod.Main.Profile;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.juntcompany.godandgod.Main.Search.SearchFragment;
import com.juntcompany.godandgod.R;

public class ProfileFragment extends Fragment {

    public ProfileFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        ProfileTopFragment f = new ProfileTopFragment();

        getChildFragmentManager()
                .beginTransaction()
                .replace(R.id.container, f)
                .commit();
        return inflater.inflate(R.layout.fragment_profile, container, false);
    }

}
