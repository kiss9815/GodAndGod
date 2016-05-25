package com.juntcompany.godandgod.Main.Profile.MyProfile;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TableRow;
import android.widget.TextView;

import com.juntcompany.godandgod.Data.Post;
import com.juntcompany.godandgod.Main.MainActivity;
import com.juntcompany.godandgod.R;

public class ProfileMyprofileFragment extends Fragment {

    public ProfileMyprofileFragment() {
        // Required empty public constructor
    }

    RecyclerView recyclerView;
    public static ProfileMyProfileAdapter mAdapter;

    Context context;
    int heartOn = 0;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_profile_myprofile, container, false);
        recyclerView = (RecyclerView) view.findViewById(R.id.recyclerView);
        mAdapter = new ProfileMyProfileAdapter();
        recyclerView.setAdapter(mAdapter);
        MainActivity.storyLine = 1;

        LinearLayoutManager layoutManager = new LinearLayoutManager(getContext(), LinearLayoutManager.VERTICAL, false);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.addOnItemTouchListener(new MainActivity.RecyclerTouchListener(context, recyclerView, new MainActivity.ClickListener() {
            @Override
            public void onClick(View view, int position) {
                TableRow myLikeBox = (TableRow) view.findViewById(R.id.myLikeBox);
                final TextView myProfileUserLikeNum = (TextView) view.findViewById(R.id.myProfileUserLikeNum);
                final ImageView heartStatue = (ImageView) view.findViewById(R.id.heartStatue);

//                myLikeBox.setOnClickListener(new View.OnClickListener() {
//                    @Override
//                    public void onClick(View v) {
//                        if (heartOn == 0) {
//                            int num = Integer.parseInt(myProfileUserLikeNum.getText().toString()) + 1;
//                            myProfileUserLikeNum.setText(String.valueOf(num));
//                            heartStatue.setBackgroundResource(R.drawable.heart);
//                            heartOn = 1;
//                        } else {
//                            int num = Integer.parseInt(myProfileUserLikeNum.getText().toString()) - 1;
//                            myProfileUserLikeNum.setText(String.valueOf(num));
//                            heartStatue.setBackgroundResource(R.drawable.fillheart);
//                            heartOn = 0;
//                        }
//
//                    }
//                });

            }

            @Override
            public void onLongClick(View view, int position) {

            }
        }));

        return view;
    }


}
