package com.juntcompany.godandgod.Main.Home;


import android.annotation.TargetApi;
import android.content.Context;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.ActionBar;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TableRow;
import android.widget.TextView;

import com.juntcompany.godandgod.Data.Post;
import com.juntcompany.godandgod.Data.sendData;
import com.juntcompany.godandgod.Main.MainActivity;
import com.juntcompany.godandgod.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class HomeFragment extends Fragment {

    public HomeFragment() {
        // Required empty public constructor
    }

    Context context;
    int heartOn = 0;
    RecyclerView recyclerView;
    public static HomeAdapter mAdapter;


    @TargetApi(Build.VERSION_CODES.JELLY_BEAN)
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_home, container, false);
        recyclerView = (RecyclerView) view.findViewById(R.id.recyclerView);
        mAdapter = new HomeAdapter();
        recyclerView.setAdapter(mAdapter);
        LinearLayoutManager layoutManager = new LinearLayoutManager(getContext(), LinearLayoutManager.VERTICAL, false);
        recyclerView.setLayoutManager(layoutManager);
        ImageView myPic = (ImageView)view.findViewById(R.id.userPicture);
        myPic.setBackground(MainActivity.HomeUserPicture);
        MainActivity.storyLine = 0;

        recyclerView.addOnItemTouchListener(new MainActivity.RecyclerTouchListener(context, recyclerView, new MainActivity.ClickListener() {
            @Override
            public void onClick(View view, int position) {
                TableRow likeBox = (TableRow) view.findViewById(R.id.likeBox);
                final TextView homeUserLikeNum = (TextView)view.findViewById(R.id.homeUserLikeNum);
                final ImageView heartStatue = (ImageView)view.findViewById(R.id.heartStatue);
                likeBox.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        if(heartOn == 0) {
                            int num = Integer.parseInt(homeUserLikeNum.getText().toString()) + 1;
                            homeUserLikeNum.setText(String.valueOf(num));
                            heartStatue.setBackgroundResource(R.drawable.heart);
                            heartOn = 1;
                        }
                        else
                        {
                            int num = Integer.parseInt(homeUserLikeNum.getText().toString()) - 1;
                            homeUserLikeNum.setText(String.valueOf(num));
                            heartStatue.setBackgroundResource(R.drawable.fillheart);
                            heartOn = 0;
                        }

                    }
                });

            }

            @Override
            public void onLongClick(View view, int position) {

            }
        }));


        return view;
    }


    @Override
    public void onResume() {
        super.onResume();


    }

}
