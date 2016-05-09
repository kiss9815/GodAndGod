package com.juntcompany.godandgod.Main.Home;


import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.ActionBar;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.juntcompany.godandgod.Data.Post;
import com.juntcompany.godandgod.Main.MainActivity;
import com.juntcompany.godandgod.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class HomeFragment extends Fragment {


    public HomeFragment() {
        // Required empty public constructor
    }

    RecyclerView recyclerView;
    HomeAdapter mAdapter;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_home, container, false);
        recyclerView = (RecyclerView)view.findViewById(R.id.recyclerView);
        mAdapter = new HomeAdapter();
        recyclerView.setAdapter(mAdapter);

        LinearLayoutManager layoutManager = new LinearLayoutManager(getContext(), LinearLayoutManager.VERTICAL,false);
        recyclerView.setLayoutManager(layoutManager);

        initData();
        return view;
    }

    private void initData(){
        for(int i=0; i<10; i++) {
            Post post = new Post();
            post.postUserName = "가라이름 : " + i;
            post.postUserPicture = getResources().getDrawable(R.mipmap.ic_launcher);
            post.postContent = "가라내용asdfasdfasdasdfasdfasdfasdfasdfaseveveveveveveveveveve : " + (i*1000);
            mAdapter.add(post);
        }

    }

    ActionBar actionBar;

    @Override
    public void onResume() {
        super.onResume();
//        actionBar = ((MainActivity) getActivity()).getSupportActionBar();

//        View view = actionBar.getCustomView();
//        Button btn = (Button)view.findViewById(R.id.buttonChat);
//        btn.setVisibility(View.VISIBLE);


    }

}
