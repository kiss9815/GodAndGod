package com.juntcompany.godandgod.MainToolbar.ChatGroup;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.juntcompany.godandgod.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class ChatGroupFragment extends Fragment {


    public ChatGroupFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_chat_group, container, false);
    }

}
